package devInt.s2aei.teacherUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import devInt.s2aei.teacher.Teacher;
import devInt.s2aei.teacher.TeacherBR;
import devInt.s2aei.util.Logger;
import devInt.s2aei.utils.DBController;

public class IncludeTeacherFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9078388417334101248L;
	
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private JTextField textFieldDepartament;
	private JFormattedTextField textFieldId;
	
	private JButton buttonSave;
	private JButton buttonCancel;
	protected JButton buttonDelete;
	
	private TeacherGUIFrame mainFrame;

	public IncludeTeacherFrame(TeacherGUIFrame mainFrame) {
		this.mainFrame = mainFrame;
		setTitle("Tela Manter Professores");
		setSize(300,250);
		setLocationRelativeTo(null);
		setResizable(false);
		initComponents();
		resetForm();
	}
	
	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(mountPanelEditTeacher(), BorderLayout.CENTER);
		panel.add(mountPanelBtnEdit(), BorderLayout.SOUTH);
		add(panel);
		
		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
	}
	
	private JPanel mountPanelBtnEdit() {
		JPanel panel = new JPanel();

		buttonSave = new JButton("Salvar");
		buttonSave.setMnemonic(KeyEvent.VK_S);
		buttonSave.addActionListener(new SaveTeacherListener());
		panel.add(buttonSave);

		buttonCancel = new JButton("Cancelar");
		buttonCancel.setMnemonic(KeyEvent.VK_C);
		buttonCancel.addActionListener(new CancelListener());
		panel.add(buttonCancel);
		
		buttonDelete = new JButton();
		buttonDelete.setText("Excluir");
		buttonDelete.setMnemonic(KeyEvent.VK_E);
		buttonDelete.addActionListener(new DeleteTeacherListener());
		buttonDelete.setVisible(false);
		panel.add(buttonDelete);

		return panel;
	}

	private JPanel mountPanelEditTeacher() {
		JPanel panelEditTeacher = new JPanel();
		panelEditTeacher.setLayout(new GridLayout(8, 1));
		
		textFieldName = new JTextField();
		textFieldDepartament = new JTextField();
		textFieldPassword = new JTextField();
		textFieldEmail = new JFormattedTextField();
		textFieldId = new JFormattedTextField();
		textFieldId.setEnabled(false);

		panelEditTeacher.add(new JLabel("Nome:"));
		panelEditTeacher.add(textFieldName);
		panelEditTeacher.add(new JLabel("Email:"));
		panelEditTeacher.add(textFieldEmail);
		panelEditTeacher.add(new JLabel("Senha:"));
		panelEditTeacher.add(textFieldPassword);
		panelEditTeacher.add(new JLabel("Departament:"));
		panelEditTeacher.add(textFieldDepartament);
		
		panelEditTeacher.add(new JLabel("Id:"));
		panelEditTeacher.add(textFieldId);
		
		return panelEditTeacher;
	}
	
	private void resetForm() {
		textFieldId.setValue(null);
		textFieldName.setText("");
		textFieldDepartament.setText("");
		textFieldEmail.setText("");
		textFieldPassword.setText("");
	}
	
	private void popTextFields(Teacher teacher){
		textFieldId.setValue(teacher.getIdTeacher());
		textFieldName.setText(teacher.getName());
		textFieldEmail.setText(teacher.getEmail());
		textFieldDepartament.setText(teacher.getDepartment());
		textFieldPassword.setText(teacher.getPassword());
		
	}
	
	protected Integer getIdTeacher(){
		try {
			return Integer.parseInt(textFieldId.getText());
		} catch (Exception e) {
			return null;
		}
	}
	
	protected Teacher loadTeacherFromPanel() {
		
		Teacher teacher = new Teacher();
		teacher.setName(this.textFieldName.getText());
		teacher.setEmail(this.textFieldEmail.getText());
		teacher.setDepartment(this.textFieldDepartament.getText());
		teacher.setPassword(this.textFieldPassword.getText());
	
		return teacher;
	}
	
	public void setTeacher(Teacher teacher){
		resetForm();
		if (teacher != null) {
			popTextFields(teacher);
		}
	}
	
	private class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			resetForm();
		}
	}
	
	private class SaveTeacherListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				// dynamic code here
				Teacher teacher = loadTeacherFromPanel();
				
				TeacherBR teacherBR = new TeacherBR();
				DBController dbController = new DBController();				
				try {
					dbController.getTransaction().begin();
					teacherBR.save(teacher);
					dbController.getTransaction().commit();
					Logger.log(Logger.DB_CTRL, Logger.DBG, "Salvou professor. ID=" +teacher.getIdTeacher());
				} catch (Exception e2) {
					Logger.log(Logger.DB_CTRL, Logger.DBG, "erro ao salvar professor." +e2);
					if (dbController.getSession().isOpen()) {
    					dbController.getSession().close();
					}
				} finally {
        			try {
        				if (dbController.getSession().isOpen()) {
        					dbController.getSession().close();
						}
        				
        				//session.close();
        			} catch (Exception e2) {
        				Logger.log(Logger.DB_CTRL, Logger.DBG, "Erro ao fechar seção. " +e2);
        			}
        		}
				setVisible(false);
				resetForm();
				SwingUtilities.invokeLater(mainFrame.newUpdateTeachersAction());
				
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(IncludeTeacherFrame.this, 
						ex.getMessage(), "Erro ao incluir Professor", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class DeleteTeacherListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}
}
