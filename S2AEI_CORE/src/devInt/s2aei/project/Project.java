package devInt.s2aei.project;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import devInt.s2aei.knowledge.KnowledgeArea;
import devInt.s2aei.student.Student;
import devInt.s2aei.studentProject.StudentProject;
import devInt.s2aei.teacher.Teacher;

@Entity
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7377228563009884171L;
	@Column(name = "idproject")
	@Id
	@GeneratedValue
	private int idProject;
	private String title;
	private String description;

	@ManyToOne
	@JoinColumn(name = "leader")
	private Student leader; // this is necessary for queries, 'duplicate fk'.

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "last_mod")
	private Date lastModDate;
	private String status;

	@ManyToOne
	@JoinColumn(name = "student_member")
	private StudentProject studentMembers; // student_project fk

	@ManyToOne
	@JoinColumn(name = "knowledge_area")
	private KnowledgeArea knowledgeArea;

	@ManyToOne
	@JoinColumn(name = "teacher_ad")
	private Teacher teacherAdvisor;
	private String textXml; // think about this, maybe keep route for txt
	private String answers; // think about this

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Student getLeader() {
		return leader;
	}

	public void setLeader(Student leader) {
		this.leader = leader;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StudentProject getStudentMembers() {
		return studentMembers;
	}

	public void setStudentMembers(StudentProject studentMembers) {
		this.studentMembers = studentMembers;
	}

	public KnowledgeArea getKnowledgeArea() {
		return knowledgeArea;
	}

	public void setKnowledgeArea(KnowledgeArea knowledgeArea) {
		this.knowledgeArea = knowledgeArea;
	}

	public Teacher getTeacherAdvisor() {
		return teacherAdvisor;
	}

	public void setTeacherAdvisor(Teacher teacherAdvisor) {
		this.teacherAdvisor = teacherAdvisor;
	}

	public String getTextXml() {
		return textXml;
	}

	public void setTextXml(String textXml) {
		this.textXml = textXml;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + idProject;
		result = prime * result
				+ ((knowledgeArea == null) ? 0 : knowledgeArea.hashCode());
		result = prime * result
				+ ((lastModDate == null) ? 0 : lastModDate.hashCode());
		result = prime * result + ((leader == null) ? 0 : leader.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((studentMembers == null) ? 0 : studentMembers.hashCode());
		result = prime * result
				+ ((teacherAdvisor == null) ? 0 : teacherAdvisor.hashCode());
		result = prime * result + ((textXml == null) ? 0 : textXml.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idProject != other.idProject)
			return false;
		if (knowledgeArea == null) {
			if (other.knowledgeArea != null)
				return false;
		} else if (!knowledgeArea.equals(other.knowledgeArea))
			return false;
		if (lastModDate == null) {
			if (other.lastModDate != null)
				return false;
		} else if (!lastModDate.equals(other.lastModDate))
			return false;
		if (leader == null) {
			if (other.leader != null)
				return false;
		} else if (!leader.equals(other.leader))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (studentMembers == null) {
			if (other.studentMembers != null)
				return false;
		} else if (!studentMembers.equals(other.studentMembers))
			return false;
		if (teacherAdvisor == null) {
			if (other.teacherAdvisor != null)
				return false;
		} else if (!teacherAdvisor.equals(other.teacherAdvisor))
			return false;
		if (textXml == null) {
			if (other.textXml != null)
				return false;
		} else if (!textXml.equals(other.textXml))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
