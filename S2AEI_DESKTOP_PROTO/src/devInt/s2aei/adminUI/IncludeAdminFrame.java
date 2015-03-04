package devInt.s2aei.adminUI;

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

import devInt.s2aei.admin.Admin;
import devInt.s2aei.admin.AdminBR;
import devInt.s2aei.util.Logger;
import devInt.s2aei.utils.DBController;

public class IncludeAdminFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9078388417334101248L;
	
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private JFormattedTextField textFieldId;
	
	private JButton buttonSave;
	private JButton buttonCancel;
	protected JButton buttonDelete;
	
	private AdminGUIFrame mainFrame;

	public IncludeAdminFrame(AdminGUIFrame mainFrame) {
		this.mainFrame = mainFrame;
		setTitle("Tela Manter Administradores");
		setSize(300,250);
		setLocationRelativeTo(null);
		setResizable(false);
		initComponents();
		resetForm();
	}
	
	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(mountPanelEditAdmin(), BorderLayout.CENTER);
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
		buttonSave.addActionListener(new SaveAdminListener());
		panel.add(buttonSave);

		buttonCancel = new JButton("Cancelar");
		buttonCancel.setMnemonic(KeyEvent.VK_C);
		buttonCancel.addActionListener(new CancelListener());
		panel.add(buttonCancel);
		
		buttonDelete = new JButton();
		buttonDelete.setText("Excluir");
		buttonDelete.setMnemonic(KeyEvent.VK_E);
		buttonDelete.addActionListener(new DeleteAdminListener());
		buttonDelete.setVisible(false);
		panel.add(buttonDelete);

		return panel;
	}

	private JPanel mountPanelEditAdmin() {
		JPanel panelEditAdmin = new JPanel();
		panelEditAdmin.setLayout(new GridLayout(8, 1));
		
		textFieldName = new JTextField();
		textFieldPassword = new JTextField();
		textFieldEmail = new JFormattedTextField();
		textFieldId = new JFormattedTextField();
		textFieldId.setEnabled(false);

		panelEditAdmin.add(new JLabel("Nome:"));
		panelEditAdmin.add(textFieldName);
		panelEditAdmin.add(new JLabel("Email:"));
		panelEditAdmin.add(textFieldEmail);
		panelEditAdmin.add(new JLabel("Senha:"));
		panelEditAdmin.add(textFieldPassword);
		panelEditAdmin.add(new JLabel("Id:"));
		panelEditAdmin.add(textFieldId);
		
		return panelEditAdmin;
	}
	
	private void resetForm() {
		textFieldId.setValue(null);
		textFieldName.setText("");
		textFieldEmail.setText("");
		textFieldPassword.setText("");
	}
	
	private void popTextFields(Admin admin){
		textFieldId.setValue(admin.getIdAdmin());
		textFieldName.setText(admin.getName());
		textFieldEmail.setText(admin.getEmail());
		textFieldPassword.setText(admin.getPassword());
		
	}
	
	protected Integer getIdAdmin(){
		try {
			return Integer.parseInt(textFieldId.getText());
		} catch (Exception e) {
			return null;
		}
	}
	
	protected Admin loadAdminFromPanel() {
		
		Admin admin = new Admin();
		admin.setName(this.textFieldName.getText());
		admin.setEmail(this.textFieldEmail.getText());
		admin.setPassword(this.textFieldPassword.getText());
	
		return admin;
	}
	
	public void setAdmin(Admin admin){
		resetForm();
		if (admin != null) {
			popTextFields(admin);
		}
	}
	
	private class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			resetForm();
		}
	}
	
	private class SaveAdminListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				// dynamic code here
				Admin admin = loadAdminFromPanel();
				
				AdminBR adminBR = new AdminBR();
				DBController dbController = new DBController();				
				try {
					dbController.getTransaction().begin();
					adminBR.save(admin);
					dbController.getTransaction().commit();
					Logger.log(Logger.DB_CTRL, Logger.DBG, "Salvou admin. ID=" +admin.getIdAdmin());
				} catch (Exception e2) {
					Logger.log(Logger.DB_CTRL, Logger.DBG, "erro ao salvar admin." +e2);
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
				SwingUtilities.invokeLater(mainFrame.newUpdateAdminsAction());
				
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(IncludeAdminFrame.this, 
						ex.getMessage(), "Erro ao incluir Admin", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class DeleteAdminListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			
		}
	}
}
