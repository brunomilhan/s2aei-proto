package devInt.s2aei.teacherUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import devInt.s2aei.teacher.Teacher;


public class TeacherTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5529636602851394745L;

	private List<Teacher> teachers;
	
	private String[] colNames = { "Nome", "Email", "Status", "Departamento" };
	private Class<?>[] colTypes = { String.class, String.class, String.class, String.class };
	
	public TeacherTableModel(){
	}
	
	public void reload(List<Teacher> teachers) {
		this.teachers = teachers;
		fireTableDataChanged();
	}

	@Override
	public Class<?> getColumnClass(int column) {
		return colTypes[column];
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public int getRowCount() {
		if (teachers == null){
			return 0;
		}
		return teachers.size();
	}

	@Override
	public Object getValueAt(int line, int column) {
		Teacher teacher = teachers.get(line);
		switch (column) {
		case 0:
			return teacher.getName();
		case 1:
			return teacher.getEmail();
		case 2:
			return teacher.getStatus();
		case 3:
			return teacher.getDepartment();
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Teacher getTeacherAt(int index) {
		return teachers.get(index);
	}
}
