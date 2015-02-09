package devInt.s2aei.teacher;

import java.util.List;

import devInt.s2aei.util.DAOFactory;

public class TeacherBR {

	private TeacherDAO teacherDAO;

	public TeacherBR(){
		this.teacherDAO = DAOFactory.createTeacherDAO();
	}

	public void save(Teacher teacher){
		Integer idTeacher = teacher.getIdTeacher();
		
		if(idTeacher == null || idTeacher == 0){
			this.teacherDAO.save(teacher);
		}else{
			this.teacherDAO.update(teacher);
		}
	}

	public void delete(Teacher teacher){
		this.teacherDAO.delete(teacher);
	}

	public List<Teacher> listAll(){
		return this.teacherDAO.listAll();
	}
}
