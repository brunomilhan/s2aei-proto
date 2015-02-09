package devInt.s2aei.student;

import java.util.List;

import devInt.s2aei.util.DAOFactory;

public class StudentBR {
	
	private StudentDAO studentDAO;
	
	public StudentBR(){
		this.studentDAO = DAOFactory.createStudentDAO();
	}

	public void save(Student student){
		Integer idStudent = student.getIdStudent();
		
		if(idStudent == null || idStudent == 0){
			this.studentDAO.save(student);
		}else{
			this.studentDAO.update(student);
		}
	}

	public void delete(Student student){
		this.studentDAO.delete(student);
	}

	public List<Student> listAll(){
		return this.studentDAO.listAll();
	}

}
