package web.devInt.s2aei.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.HibernateException;

import devInt.s2aei.project.Project;
import devInt.s2aei.project.ProjectBR;
import devInt.s2aei.student.Student;
import devInt.s2aei.student.StudentBR;
import devInt.s2aei.teacher.Teacher;
import devInt.s2aei.teacher.TeacherBR;

@ManagedBean
@RequestScoped
public class ProjectBean {

	private Project project = new Project();
	private ProjectBR projectBR = new ProjectBR();
	private List<Project> listAll;

	private Integer idStudentLeader;
	private Integer idTeacherAd;

	private StudentBR studentBR = new StudentBR();
	private TeacherBR TeacherBR = new TeacherBR();

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
			this.construct();
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

			if (this.idStudentLeader != null || this.idStudentLeader != 0) {
				this.project.setLeader(this.studentBR
						.findById(this.idStudentLeader));
			}

			if (this.idTeacherAd != null || this.idTeacherAd != 0) {
				this.project.setTeacherAdvisor(this.TeacherBR
						.findById(this.idTeacherAd));
			}

			projectBR.save(project);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Cadastrado com sucesso!"));
			this.project = new Project();
			this.construct();
		} catch (Exception e) {
			System.out.println("errroooo>>> " + e);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Não foi possível, verifique os dados inseridos.",
							""));
		}

	}

	// List Selects
	private List<SelectItem> leaderSelect;
	private List<SelectItem> teacherAdSelect;

	// student leader select
	public List<SelectItem> getLeaderSelect() {
		List<Student> students = studentBR.listAll();
		this.leaderSelect = new ArrayList<SelectItem>();
		this.mountStudentSelect(this.leaderSelect, students);
		return leaderSelect;

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

	// teacher advisor select
	public List<SelectItem> getTeacherAdSelect() {
		List<Teacher> teachers = this.TeacherBR.listAll();
		this.teacherAdSelect = new ArrayList<SelectItem>();
		this.mountTeacherAdSelect(this.teacherAdSelect, teachers);
		return teacherAdSelect;

	}

	private void mountTeacherAdSelect(List<SelectItem> select,
			List<Teacher> teachers) {
		SelectItem item = null;
		if (teachers != null) {
			for (Teacher teacher : teachers) {
				item = new SelectItem(teacher.getIdTeacher(), teacher.getName());
				item.setEscape(true);
				select.add(item);
			}
		}
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setIdStudentLeader(Integer idStudentLeader) {
		this.idStudentLeader = idStudentLeader;
	}

	public Integer getIdStudentLeader() {
		return idStudentLeader;
	}

	public Integer getIdTeacherAd() {
		return idTeacherAd;
	}

	public void setIdTeacherAd(Integer idTeacherAd) {
		this.idTeacherAd = idTeacherAd;
	}

}
