package devInt.s2aei.canvas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import devInt.s2aei.project.Project;

@Entity(name="questions_canvas")
public class QuestionCanvas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 275645373417932709L;
	
	@Column(name="idquestions_canvas")
	@Id
	@GeneratedValue
	private int idQuestionCanvas;
	private String question;
	private String description;
	private String response;
	private String status;
	private int note;
	
	@ManyToOne
	@JoinColumn(name="project")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="frame_canvas")
	private FrameCanvas frameCanvas;

	public int getIdQuestionCanvas() {
		return idQuestionCanvas;
	}

	public void setIdQuestionCanvas(int idQuestionCanvas) {
		this.idQuestionCanvas = idQuestionCanvas;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public FrameCanvas getFrameCanvas() {
		return frameCanvas;
	}

	public void setFrameCanvas(FrameCanvas frameCanvas) {
		this.frameCanvas = frameCanvas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((frameCanvas == null) ? 0 : frameCanvas.hashCode());
		result = prime * result + idQuestionCanvas;
		result = prime * result + note;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result
				+ ((response == null) ? 0 : response.hashCode());
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
		QuestionCanvas other = (QuestionCanvas) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (frameCanvas == null) {
			if (other.frameCanvas != null)
				return false;
		} else if (!frameCanvas.equals(other.frameCanvas))
			return false;
		if (idQuestionCanvas != other.idQuestionCanvas)
			return false;
		if (note != other.note)
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
		
}
