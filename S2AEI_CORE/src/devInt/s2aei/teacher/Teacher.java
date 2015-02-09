package devInt.s2aei.teacher;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="teacher")
public class Teacher implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2273359820575705909L;
	
	@Id
	@GeneratedValue
	@Column(name="id_teacher")
	private int idTeacher;
	private String email;
	private String name;
	private String password;
	
	@Column(name="cad_date")
	private Date cadDate;
	
	@Column(name="last_mod_date")
	private Date lastModDate;
	private String status;
	private String function;
	
	@Column(name="main_discipline")
	private String mainDiscipline;
	
	@Column(name="project_guides")
	private String projectGuides;

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
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

	public String getMainDiscipline() {
		return mainDiscipline;
	}

	public void setMainDiscipline(String mainDiscipline) {
		this.mainDiscipline = mainDiscipline;
	}

	public String getProjectGuides() {
		return projectGuides;
	}

	public void setProjectGuides(String projectGuides) {
		this.projectGuides = projectGuides;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadDate == null) ? 0 : cadDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((function == null) ? 0 : function.hashCode());
		result = prime * result + idTeacher;
		result = prime * result
				+ ((lastModDate == null) ? 0 : lastModDate.hashCode());
		result = prime * result
				+ ((mainDiscipline == null) ? 0 : mainDiscipline.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((projectGuides == null) ? 0 : projectGuides.hashCode());
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
		Teacher other = (Teacher) obj;
		if (cadDate == null) {
			if (other.cadDate != null)
				return false;
		} else if (!cadDate.equals(other.cadDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		if (idTeacher != other.idTeacher)
			return false;
		if (lastModDate == null) {
			if (other.lastModDate != null)
				return false;
		} else if (!lastModDate.equals(other.lastModDate))
			return false;
		if (mainDiscipline == null) {
			if (other.mainDiscipline != null)
				return false;
		} else if (!mainDiscipline.equals(other.mainDiscipline))
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
		if (projectGuides == null) {
			if (other.projectGuides != null)
				return false;
		} else if (!projectGuides.equals(other.projectGuides))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
		
}
