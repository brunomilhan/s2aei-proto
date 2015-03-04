package devInt.s2aei.reviewer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import devInt.s2aei.project.Project;

@Entity(name="projects_revised")
public class ProjectsRevised implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 597363574315486703L;
	
	@Column(name="idprojects_revised")
	@Id
	@GeneratedValue
	private int idProjectsRevised;
	
	@ManyToOne
	@JoinColumn(name="project")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="reviewer")
	private Reviewer reviewer;
	private String status;
	private int note;
	public int getIdProjectsRevised() {
		return idProjectsRevised;
	}
	public void setIdProjectsRevised(int idProjectsRevised) {
		this.idProjectsRevised = idProjectsRevised;
	}
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
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProjectsRevised;
		result = prime * result + note;
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
		ProjectsRevised other = (ProjectsRevised) obj;
		if (idProjectsRevised != other.idProjectsRevised)
			return false;
		if (note != other.note)
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
