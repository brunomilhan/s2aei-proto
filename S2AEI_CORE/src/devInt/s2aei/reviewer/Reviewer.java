package devInt.s2aei.reviewer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="reviewer")
public class Reviewer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3833548576592560930L;
	
	@Column(name="idreviewer")
	@Id
	@GeneratedValue
	private int idReviewer;
	private String email;
	private String name;
	private String password;
	
	@Column(name="cad_date")
	private Date cadDate;
	
	@Column(name="last_mod")
	private Date lastModDate;
	private String status;
	
	@Column(name="know_area")
	private String knowArea;
	private String degree;
	public int getIdReviewer() {
		return idReviewer;
	}
	public void setIdReviewer(int idReviewer) {
		this.idReviewer = idReviewer;
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
	public String getKnowArea() {
		return knowArea;
	}
	public void setKnowArea(String knowArea) {
		this.knowArea = knowArea;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadDate == null) ? 0 : cadDate.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idReviewer;
		result = prime * result
				+ ((knowArea == null) ? 0 : knowArea.hashCode());
		result = prime * result
				+ ((lastModDate == null) ? 0 : lastModDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
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
		if (idReviewer != other.idReviewer)
			return false;
		if (knowArea == null) {
			if (other.knowArea != null)
				return false;
		} else if (!knowArea.equals(other.knowArea))
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}	
	
}
