package web.devInt.s2aei.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;

import devInt.s2aei.teacher.Teacher;
import devInt.s2aei.teacher.TeacherBR;


@ManagedBean
@RequestScoped
public class TeacherBean {
	
	private Teacher teacher = new Teacher();
	private TeacherBR teacherBR = new TeacherBR();
	private List<Teacher> listAll;
	
	@PostConstruct
	public void construct() {

		listAll = this.teacherBR.listAll();
	}

	public List<Teacher> listAll() {
		return listAll;
	}

		
	public void delete(){
		try{			
			teacherBR.delete(teacher);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Excluido com sucesso!"));
			this.teacher = new Teacher();
		}catch(HibernateException e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possível deletar.",""));
			this.teacher = new Teacher();
		}
	}

	public void save(){
		try{
			teacherBR.save(teacher);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Cadastrado com sucesso!"));
			this.teacher = new Teacher();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possível, verifique se os dados estão corretos.",""));
		}
				
		
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
