package devInt.s2aei.knowledge;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "knowledge_area")
public class KnowledgeArea implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7337796658167030666L;
	
	
	@Id
	@GeneratedValue
	@Column(name = "idknowledge_area")
	private int idKnowledgeArea;
	private String description;

	public int getIdKnowledgeArea() {
		return idKnowledgeArea;
	}

	public void setIdKnowledgeArea(int idKnowledgeArea) {
		this.idKnowledgeArea = idKnowledgeArea;
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
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + idKnowledgeArea;
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
		KnowledgeArea other = (KnowledgeArea) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idKnowledgeArea != other.idKnowledgeArea)
			return false;
		return true;
	}

}
