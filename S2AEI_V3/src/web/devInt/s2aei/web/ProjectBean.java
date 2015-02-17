package web.devInt.s2aei.web;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;

import devInt.s2aei.project.Project;
import devInt.s2aei.project.ProjectBR;

@ManagedBean
@RequestScoped
public class ProjectBean {

	private Project project = new Project();
	private ProjectBR projectBR = new ProjectBR();
	private List<Project> listAll;

	@PostConstruct
	public void construct() {
		listAll = this.projectBR.listAll();
	}

	public List<Project> listAll() {
		return listAll;
	}

	public void delete() {
		try {
			projectBR.delete(project);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Excluido com sucesso!"));
			this.project = new Project();
		} catch (HibernateException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Não foi possível deletar.", ""));
			this.project = new Project();
		}
	}

	public void save() {
		try {
			projectBR.save(project);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Cadastrado com sucesso!"));
			this.project = new Project();
		} catch (Exception e) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Não foi possivel, verifique se os dados estÃ£o corretos.",
									""));
		}

	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	
}
