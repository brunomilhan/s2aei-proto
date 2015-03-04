package devInt.s2aei.teacherUI;

import devInt.s2aei.teacher.Teacher;

public class EditTeacherFrame extends IncludeTeacherFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6024577046235385895L;

	public EditTeacherFrame(TeacherGUIFrame mainFrame) {
		super(mainFrame);
		setTitle("Editar Professor");
		buttonDelete.setVisible(true);
	}
	
	protected Teacher loadTeacherFromPanel() {
		Teacher teacher = super.loadTeacherFromPanel();
		teacher.setIdTeacher(getIdTeacher());
		return teacher;
	}
	
}
