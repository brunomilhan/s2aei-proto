package devInt.s2aei.adminUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import devInt.s2aei.admin.Admin;


public class AdminTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5529636602851394745L;

	private List<Admin> admins;
	
	private String[] colNames = { "Nome", "Email", "Status" };
	private Class<?>[] colTypes = { String.class, String.class, String.class };
	
	public AdminTableModel(){
	}
	
	public void reload(List<Admin> admins) {
		this.admins = admins;
		fireTableDataChanged();
	}

	@Override
	public Class<?> getColumnClass(int column) {
		return colTypes[column];
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public int getRowCount() {
		if (admins == null){
			return 0;
		}
		return admins.size();
	}

	@Override
	public Object getValueAt(int line, int column) {
		Admin admin = admins.get(line);
		switch (column) {
		case 0:
			return admin.getName();
		case 1:
			return admin.getEmail();
		case 2:
			return admin.getStatus();
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Admin getAdminAt(int index) {
		return admins.get(index);
	}
}
