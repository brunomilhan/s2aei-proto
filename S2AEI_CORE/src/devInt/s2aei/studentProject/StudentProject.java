package devInt.s2aei.studentProject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import devInt.s2aei.project.Project;
import devInt.s2aei.student.Student;

@Entity(name="student_project")
public class StudentProject implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8986862669610770740L;

	@Column(name="idstudent_project")
	@Id
	@GeneratedValue
	private int idStudentProject;
	
	@ManyToOne
	@JoinColumn(name="student")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="project")
	private Project project;

	public int getIdStudentProject() {
		return idStudentProject;
	}

	public void setIdStudentProject(int idStudentProject) {
		this.idStudentProject = idStudentProject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStudentProject;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		StudentProject other = (StudentProject) obj;
		if (idStudentProject != other.idStudentProject)
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}
	
	

}
