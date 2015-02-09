package devInt.s2aei.reviewer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="inspector")
public class Reviewer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3833548576592560930L;
	
	@Column(name="id_inspector")
	@Id
	@GeneratedValue
	private int idInspector;
	private String email;
	private String name;
	private String password;
	
	@Column(name="cad_date")
	private Date cadDate;
	
	@Column(name="last_mod_date")
	private Date lastModDate;
	private String status;
	private String function;
	private String field;
	private String degree;
	
	@Column(name="project_evaluates")
	private String projectEvalutes;
	
	@Column(name="project_evaluated")
	private String projectEvaluated;

	public int getIdInspector() {
		return idInspector;
	}

	public void setIdInspector(int idInspector) {
		this.idInspector = idInspector;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCadDate() {
		return cadDate;
	}

	public void setCadDate(Date cadDate) {
		this.cadDate = cadDate;
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

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getProjectEvalutes() {
		return projectEvalutes;
	}

	public void setProjectEvalutes(String projectEvalutes) {
		this.projectEvalutes = projectEvalutes;
	}

	public String getProjectEvaluated() {
		return projectEvaluated;
	}

	public void setProjectEvaluated(String projectEvaluated) {
		this.projectEvaluated = projectEvaluated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadDate == null) ? 0 : cadDate.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result
				+ ((function == null) ? 0 : function.hashCode());
		result = prime * result + idInspector;
		result = prime * result
				+ ((lastModDate == null) ? 0 : lastModDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime
				* result
				+ ((projectEvaluated == null) ? 0 : projectEvaluated.hashCode());
		result = prime * result
				+ ((projectEvalutes == null) ? 0 : projectEvalutes.hashCode());
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
		Reviewer other = (Reviewer) obj;
		if (cadDate == null) {
			if (other.cadDate != null)
				return false;
		} else if (!cadDate.equals(other.cadDate))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		if (idInspector != other.idInspector)
			return false;
		if (lastModDate == null) {
			if (other.lastModDate != null)
				return false;
		} else if (!lastModDate.equals(other.lastModDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (projectEvaluated == null) {
			if (other.projectEvaluated != null)
				return false;
		} else if (!projectEvaluated.equals(other.projectEvaluated))
			return false;
		if (projectEvalutes == null) {
			if (other.projectEvalutes != null)
				return false;
		} else if (!projectEvalutes.equals(other.projectEvalutes))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	

		
}
