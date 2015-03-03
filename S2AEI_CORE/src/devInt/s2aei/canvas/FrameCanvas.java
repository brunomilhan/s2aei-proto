package devInt.s2aei.canvas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="frame_canvas")
public class FrameCanvas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4199021495330182996L;
	
	@Column(name="idframe_canvas")
	@Id
	@GeneratedValue
	private int idFrameCanvas;
	
	
	private String description;
	private String comment;
	private int note;
	private String status;

	public int getIdFrameCanvas() {
		return idFrameCanvas;
	}
	public void setIdFrameCanvas(int idFrameCanvas) {
		this.idFrameCanvas = idFrameCanvas;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + idFrameCanvas;
		result = prime * result + note;
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
		FrameCanvas other = (FrameCanvas) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idFrameCanvas != other.idFrameCanvas)
			return false;
		if (note != other.note)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	
	
}
