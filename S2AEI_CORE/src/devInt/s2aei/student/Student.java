package devInt.s2aei.student;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="student")
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5342336028706686915L;
	
	@Column(name="id_student")
	@Id
	@GeneratedValue
	private int idStudent;
	private String email;
	private String name;
	private String password;
	
	@Column(name="cad_date")
	private Date cadDate;
	
	@Column(name="last_mod_date")
	private Date lastModDate;
	private String status;
	private String function;
	private String period;
	
	@Column(name="project_involved")
	private String projectInvolved;
	
	@Column(name="project_leader")
	private String projectLeader;

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
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

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getProjectInvolved() {
		return projectInvolved;
	}

	public void setProjectInvolved(String projectInvolved) {
		this.projectInvolved = projectInvolved;
	}

	public String getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadDate == null) ? 0 : cadDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((function == null) ? 0 : function.hashCode());
		result = prime * result + idStudent;
		result = prime * result
				+ ((lastModDate == null) ? 0 : lastModDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result
				+ ((projectInvolved == null) ? 0 : projectInvolved.hashCode());
		result = prime * result
				+ ((projectLeader == null) ? 0 : projectLeader.hashCode());
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
		Student other = (Student) obj;
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
		if (idStudent != other.idStudent)
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
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (projectInvolved == null) {
			if (other.projectInvolved != null)
				return false;
		} else if (!projectInvolved.equals(other.projectInvolved))
			return false;
		if (projectLeader == null) {
			if (other.projectLeader != null)
				return false;
		} else if (!projectLeader.equals(other.projectLeader))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


}
