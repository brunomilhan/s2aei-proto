package web.devInt.s2aei.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;

import devInt.s2aei.student.Student;
import devInt.s2aei.student.StudentBR;
import devInt.s2aei.teacher.Teacher;
import devInt.s2aei.teacher.TeacherBR;


@ManagedBean
@RequestScoped
public class StudentBean {
	
	private Student student = new Student();
	private StudentBR studentBR = new StudentBR();
	private List<Student> listAll;
	
	@PostConstruct
	public void construct() {

		listAll = this.studentBR.listAll();
	}

	public List<Student> listAll() {
		return listAll;
	}

		
	public void delete(){
		try{			
			studentBR.delete(student);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Excluido com sucesso!"));
			this.student = new Student();
			this.construct();
		}catch(HibernateException e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi posssivel deletar.",""));
			this.student = new Student();
		}
	}
	
	public void save(){
		try{			
			this.studentBR.save(student);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Cadastrado com sucesso!"));
			this.student = new Student();
			this.construct();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possível, verifique os dados inseridos.",""));
		} 
		
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
