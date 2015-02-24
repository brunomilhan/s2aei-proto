package devInt.s2aei.student;

import java.util.Date;
import java.util.List;

import devInt.s2aei.util.DAOFactory;

public class StudentBR {

	private StudentDAO studentDAO;

	public StudentBR() {
		this.studentDAO = DAOFactory.createStudentDAO();
	}

	public void save(Student student) {
		Integer idStudent = student.getIdStudent();
		Date dateNow = new Date(System.currentTimeMillis());
		student.setLastModDate(dateNow);

		
		if (idStudent == null || idStudent == 0) {
			student.setCadDate(dateNow);
			student.setPermissions("student");
			student.setStatus("active");
			
			this.studentDAO.save(student);			
		} else {
			this.studentDAO.update(student);
		}
	}

	public void delete(Student student) {
		this.studentDAO.delete(student);
	}

	public List<Student> listAll() {
		return this.studentDAO.listAll();
	}

	// new changes v2
	public Student findById(Integer idStudent) {
		return this.studentDAO.findById(idStudent);

	}

}
