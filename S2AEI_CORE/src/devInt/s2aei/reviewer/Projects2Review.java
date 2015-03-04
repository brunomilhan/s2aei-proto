package devInt.s2aei.reviewer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import devInt.s2aei.project.Project;

@Entity(name="projects2review")
public class Projects2Review implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7054430463589380241L;

	@Column(name="idprojects2review")
	@Id
	@GeneratedValue
	private int idProjects2Review;
	
	@ManyToOne
	@JoinColumn(name="project")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="reviewer")
	private Reviewer reviewer;
	private String status;
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Reviewer getReviewer() {
		return reviewer;
	}
	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProjects2Review;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result
				+ ((reviewer == null) ? 0 : reviewer.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Projects2Review other = (Projects2Review) obj;
		if (idProjects2Review != other.idProjects2Review)
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (reviewer == null) {
			if (other.reviewer != null)
				return false;
		} else if (!reviewer.equals(other.reviewer))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
