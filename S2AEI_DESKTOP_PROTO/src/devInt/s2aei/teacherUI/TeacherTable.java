package devInt.s2aei.teacherUI;

import java.util.List;

import javax.swing.JTable;

import devInt.s2aei.teacher.Teacher;

public class TeacherTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 834285452360487161L;
	private TeacherTableModel model;
	
	public TeacherTable() {
		model = new TeacherTableModel();
		setModel(model);
	}
	
	public Teacher getTeacherSelected() {
		int i = getSelectedRow();
		if (i < 0) {
			return null;
		}
		return model.getTeacherAt(i);
	}
	
	public void reload(List<Teacher> teachers) {
		model.reload(teachers);
	}
}
