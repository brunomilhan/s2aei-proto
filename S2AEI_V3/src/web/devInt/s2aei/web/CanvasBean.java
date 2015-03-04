package web.devInt.s2aei.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import devInt.s2aei.canvas.CanvasBR;
import devInt.s2aei.canvas.CanvasQuestions;
import devInt.s2aei.canvas.QuestionCanvas;
import devInt.s2aei.project.Project;
import devInt.s2aei.project.ProjectBR;
import devInt.s2aei.student.Student;
import devInt.s2aei.student.StudentBR;

@ManagedBean
@RequestScoped
public class CanvasBean {
	
	private CanvasBR canvasBR = new CanvasBR();
	
	//private QuestionCanvas questionCanvas = new QuestionCanvas();
	private Project project;
	private ProjectBR projectBR = new ProjectBR();
	
	private List<QuestionCanvas> questionsCanvas;
	private Student student;
	private StudentBR studentBR = new StudentBR();
	
	
	@PostConstruct
	public void construct(){
		//this.questionsCanvas = this.canvasBR.listByProject(project);
		this.student = this.studentBR.findStudentByLogin(SessionBean.getLoginUserLogged());
		this.project = this.projectBR.findProjectActiveByStudent(student);
		
		this.questionsCanvas = this.canvasBR.listByProject(project);
	}
	
	public List<QuestionCanvas> listAll(){
		return this.questionsCanvas;
	}

	public List<QuestionCanvas> getQuestionsCanvas() {
		return this.questionsCanvas;
	}

	public void setQuestionsCanvas(List<QuestionCanvas> questionsCanvas) {
		this.questionsCanvas = questionsCanvas;
	}

}
