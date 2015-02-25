package devInt.s2aei.studentProject;

import java.util.List;

import devInt.s2aei.project.Project;
import devInt.s2aei.student.Student;
import devInt.s2aei.util.DAOFactory;

public class StudentProjectBR {
	
	private StudentProjectDAO studentProjectDAO;
	private StudentProject studentProject;
	
	public StudentProjectBR(Project project, Student student) {
		this.studentProject.setProject(project);
		this.studentProject.setStudent(student);
		
		this.studentProjectDAO = DAOFactory.createStudentProjectDAO();
		
		this.save();
	}
	
	private void save(){
		this.studentProjectDAO.save(studentProject);
	}
	
	public void delete(StudentProject studentProject){
		this.studentProjectDAO.delete(studentProject);
	}
	
	public List<StudentProject> listAll(){
		return this.studentProjectDAO.listAll();
	}	

}
