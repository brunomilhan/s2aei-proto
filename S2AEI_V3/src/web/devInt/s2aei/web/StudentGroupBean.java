package web.devInt.s2aei.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import devInt.s2aei.project.Project;
import devInt.s2aei.project.ProjectBR;
import devInt.s2aei.student.Student;
import devInt.s2aei.student.StudentBR;
import devInt.s2aei.studentProject.StudentProject;
import devInt.s2aei.studentProject.StudentProjectBR;
import devInt.s2aei.util.BRException;

@ManagedBean
@RequestScoped
public class StudentGroupBean {
	private StudentProjectBR studentProjectBR;
	private StudentBR studentBR = new StudentBR();
	private ProjectBR projectBR = new ProjectBR();

	private Integer idStudent;
	private Integer idProject;

	public void save() {
		try {
			Student student = this.studentBR.findById(idStudent);
			Project project = this.projectBR.findById(idProject);

			studentProjectBR = new StudentProjectBR(project, student);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Membro adicionado ao projeto!"));

		} catch (Exception e) {
			
			System.out.println("asdsadsa>>>> "+ e);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Não foi possível Adicionar.", ""));
		}

	}

	// List Selects
	private List<SelectItem> studentSelect;
	private List<SelectItem> projectSelect;

	// student member select
	public List<SelectItem> getStudentSelect() {
		List<Student> students = studentBR.listAll();
		this.studentSelect = new ArrayList<SelectItem>();
		this.mountStudentSelect(this.studentSelect, students);
		return studentSelect;

	}

	private void mountStudentSelect(List<SelectItem> select,
			List<Student> students) {
		SelectItem item = null;
		if (students != null) {
			for (Student student : students) {
				item = new SelectItem(student.getIdStudent(), student.getName());
				item.setEscape(true);
				select.add(item);
			}
		}
	}

	// Project select
	public List<SelectItem> getProjectSelect() {
		List<Project> projects = projectBR.listAll();
		this.projectSelect = new ArrayList<SelectItem>();
		this.mountProjectSelect(this.projectSelect, projects);
		return projectSelect;

	}

	private void mountProjectSelect(List<SelectItem> select,
			List<Project> projects) {
		SelectItem item = null;
		if (projects != null) {
			for (Project project : projects) {
				item = new SelectItem(project.getIdProject(),
						project.getTitle());
				item.setEscape(true);
				select.add(item);
			}
		}
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public Integer getIdProject() {
		return idProject;
	}

	public void setIdProject(Integer idProject) {
		this.idProject = idProject;
	}

}
