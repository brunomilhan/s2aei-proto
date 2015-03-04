package devInt.s2aei.reviewerUI;

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

import devInt.s2aei.reviewer.Reviewer;
import devInt.s2aei.reviewer.ReviewerBR;
import devInt.s2aei.util.Logger;
import devInt.s2aei.utils.DBController;

public class IncludeReviewerFrame extends JFrame {

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
	
	private ReviewerGUIFrame mainFrame;

	public IncludeReviewerFrame(ReviewerGUIFrame mainFrame) {
		this.mainFrame = mainFrame;
		setTitle("Tela Manter Avaliadores");
		setSize(300,250);
		setLocationRelativeTo(null);
		setResizable(false);
		initComponents();
		resetForm();
	}
	
	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(mountPanelEditReviewer(), BorderLayout.CENTER);
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
		buttonSave.addActionListener(new SaveReviewerListener());
		panel.add(buttonSave);

		buttonCancel = new JButton("Cancelar");
		buttonCancel.setMnemonic(KeyEvent.VK_C);
		buttonCancel.addActionListener(new CancelListener());
		panel.add(buttonCancel);
		
		buttonDelete = new JButton();
		buttonDelete.setText("Excluir");
		buttonDelete.setMnemonic(KeyEvent.VK_E);
		buttonDelete.addActionListener(new DeleteReviewerListener());
		buttonDelete.setVisible(false);
		panel.add(buttonDelete);

		return panel;
	}

	private JPanel mountPanelEditReviewer() {
		JPanel panelEditReviewer = new JPanel();
		panelEditReviewer.setLayout(new GridLayout(8, 1));
		
		textFieldName = new JTextField();
		textFieldPassword = new JTextField();
		textFieldEmail = new JFormattedTextField();
		textFieldId = new JFormattedTextField();
		textFieldId.setEnabled(false);

		panelEditReviewer.add(new JLabel("Nome:"));
		panelEditReviewer.add(textFieldName);
		panelEditReviewer.add(new JLabel("Email:"));
		panelEditReviewer.add(textFieldEmail);
		panelEditReviewer.add(new JLabel("Senha:"));
		panelEditReviewer.add(textFieldPassword);
		panelEditReviewer.add(new JLabel("Id:"));
		panelEditReviewer.add(textFieldId);
		
		return panelEditReviewer;
	}
	
	private void resetForm() {
		textFieldId.setValue(null);
		textFieldName.setText("");
		textFieldEmail.setText("");
		textFieldPassword.setText("");
	}
	
	private void popTextFields(Reviewer reviewer){
		textFieldId.setValue(reviewer.getIdReviewer());
		textFieldName.setText(reviewer.getName());
		textFieldEmail.setText(reviewer.getEmail());
		textFieldPassword.setText(reviewer.getPassword());
		
	}
	
	protected Integer getIdReviewer(){
		try {
			return Integer.parseInt(textFieldId.getText());
		} catch (Exception e) {
			return null;
		}
	}
	
	protected Reviewer loadReviewerFromPanel() {
		
		Reviewer reviewer = new Reviewer();
		reviewer.setName(this.textFieldName.getText());
		reviewer.setEmail(this.textFieldEmail.getText());
		reviewer.setPassword(this.textFieldPassword.getText());
	
		return reviewer;
	}
	
	public void setReviewer(Reviewer reviewer){
		resetForm();
		if (reviewer != null) {
			popTextFields(reviewer);
		}
	}
	
	private class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			resetForm();
		}
	}
	
	private class SaveReviewerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				// dynamic code here
				Reviewer reviewer = loadReviewerFromPanel();
				
				ReviewerBR reviewerBR = new ReviewerBR();
				DBController dbController = new DBController();				
				try {
					dbController.getTransaction().begin();
					reviewerBR.save(reviewer);
					dbController.getTransaction().commit();
					Logger.log(Logger.DB_CTRL, Logger.DBG, "Salvou reviewer. ID=" +reviewer.getIdReviewer());
				} catch (Exception e2) {
					Logger.log(Logger.DB_CTRL, Logger.DBG, "erro ao salvar reviewer." +e2);
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
				SwingUtilities.invokeLater(mainFrame.newUpdateReviewersAction());
				
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(IncludeReviewerFrame.this, 
						ex.getMessage(), "Erro ao incluir Avaliador", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class DeleteReviewerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}
}
