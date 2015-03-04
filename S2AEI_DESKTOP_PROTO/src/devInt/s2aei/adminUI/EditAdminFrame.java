package devInt.s2aei.adminUI;

import devInt.s2aei.admin.Admin;

public class EditAdminFrame extends IncludeAdminFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6024577046235385895L;

	public EditAdminFrame(AdminGUIFrame mainFrame) {
		super(mainFrame);
		setTitle("Editar Administrador");
		buttonDelete.setVisible(true);
	}
	
	protected Admin loadAdminFromPanel() {
		Admin admin = super.loadAdminFromPanel();
		admin.setIdAdmin(getIdAdmin());
		return admin;
	}
	
}
