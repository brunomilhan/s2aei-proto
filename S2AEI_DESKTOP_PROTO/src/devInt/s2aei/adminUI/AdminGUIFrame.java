package devInt.s2aei.adminUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import devInt.s2aei.admin.Admin;
import devInt.s2aei.admin.AdminBR;
import devInt.s2aei.utils.DBController;

public class AdminGUIFrame extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 3386662906919930428L;
	private AdminTable adminTable;
	private JScrollPane scrollPane;
	private JButton buttonNew;
//	private JButton buttonFindByName;
	private JButton buttonUpdateList;
	@SuppressWarnings("unused")
	private JMenuBar menubar;
	
	private IncludeAdminFrame includeFrame;
	private EditAdminFrame editFrame;
//	private FindAdminFrame findFrame;
	
	@SuppressWarnings("unused")
	private DBController dbController;
	private AdminBR adminBR = new AdminBR();
	
	public AdminGUIFrame() {
		setTitle("Manter Adiministradores");
		
		initComponent();
		addComponent();
		
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void initComponent() {
		adminTable = new AdminTable();
		adminTable.addMouseListener(new EditAdminListener());
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(adminTable);

		buttonNew = new JButton();
		buttonNew.setText("Novo");
		buttonNew.setMnemonic(KeyEvent.VK_N);
		buttonNew.addActionListener(new IncludeAdminListener());

//		buttonFindByName = new JButton();
//		buttonFindByName.setText("Buscar");
//		buttonFindByName.setMnemonic(KeyEvent.VK_B);
//		buttonFindByName.addActionListener(new FindAdminListener());
		
		buttonUpdateList = new JButton();
		buttonUpdateList.setText("Atualizar");
		buttonUpdateList.setMnemonic(KeyEvent.VK_A);
		buttonUpdateList.addActionListener(new UpdateAdminListener());
		
		menubar = new JMenuBar();
		
		includeFrame = new IncludeAdminFrame(this);
		editFrame = new EditAdminFrame(this);
//		findFrame = new FindAdminFrame(this);
		
		initDBController();
	}
	
	private void addComponent(){
		add(scrollPane);
		JPanel panel = new JPanel();
		panel.add(buttonNew);
//		panel.add(buttonFindByName);
		panel.add(buttonUpdateList);
		add(panel, BorderLayout.SOUTH);
	}
	
	private void initDBController() {
		try {
			this.dbController = new DBController();
			SwingUtilities.invokeLater(newUpdateAdminsAction());
		} catch (Exception e) {
			System.exit(0);
		}
	}
	
	public Runnable newUpdateAdminsAction() {
		return new Runnable() {
			public void run() {
				try {					
					adminTable.reload(adminBR.listAll());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(AdminGUIFrame.this,
							e.getMessage(), "Não foi possível carregar lista de professores", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}
	
	public void refreshTable(List<Admin> admins) {
		adminTable.reload(admins);
	}
	
	private class UpdateAdminListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(newUpdateAdminsAction());
		}
	}
	
	private class IncludeAdminListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			includeFrame.setVisible(true);
		}
	}
	
	private class EditAdminListener extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (event.getClickCount() == 2) {
				Admin admin = adminTable.getAdminSelected();
				if (admin != null) {
					editFrame.setAdmin(admin);
					editFrame.setVisible(true);
				}
			}
		}
	}
	
//	private class FindAdminListener implements ActionListener {
//		public void actionPerformed(ActionEvent event) {
//			findFrame.setVisible(true);
//		}
//	}

}
