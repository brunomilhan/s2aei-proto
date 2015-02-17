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
		}catch(HibernateException e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"N�o foi posssivel deletar.",""));
			this.student = new Student();
		}
	}

	public void save(){
		try{
			studentBR.save(student);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Cadastrado com sucesso!"));
			this.student = new Student();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possível, verifique se os dados estão corretos.",""));
		}
				
		
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
}
