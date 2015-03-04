package devInt.s2aei.studentProject;

import java.util.List;

import devInt.s2aei.project.Project;
import devInt.s2aei.student.Student;
import devInt.s2aei.util.DAOFactory;
import devInt.s2aei.util.Logger;

public class StudentProjectBR {
	
	private StudentProjectDAO studentProjectDAO;
	private StudentProject studentProject = new StudentProject();
	
	public StudentProjectBR(Project project, Student student) {
		this.studentProject.setProject(project);
		this.studentProject.setStudent(student);
		
		Logger.log(Logger.DBG, Logger.STUDENT_PROJECT_BR, "Adicionou Estudante no objeto: " + student.getName());
		Logger.log(Logger.DBG, Logger.STUDENT_PROJECT_BR, "Adicionou Projeto no objeto: " + project.getTitle());
		
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
