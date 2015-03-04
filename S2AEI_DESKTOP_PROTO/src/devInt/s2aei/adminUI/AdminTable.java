package devInt.s2aei.adminUI;

import java.util.List;

import javax.swing.JTable;

import devInt.s2aei.admin.Admin;

public class AdminTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 834285452360487161L;
	private AdminTableModel model;
	
	public AdminTable() {
		model = new AdminTableModel();
		setModel(model);
	}
	
	public Admin getAdminSelected() {
		int i = getSelectedRow();
		if (i < 0) {
			return null;
		}
		return model.getAdminAt(i);
	}
	
	public void reload(List<Admin> admins) {
		model.reload(admins);
	}
}
