package web.devInt.s2aei.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import devInt.s2aei.student.Student;
import devInt.s2aei.util.Logger;

@ManagedBean(name="sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8787885309651441508L;
	private String init = "init";
	
	private Student studentMembers;
	//ArrayList<Student> studentMembers = new ArrayList<Student>();

	public void setStudentMembers(Student student) {
		//Logger.log( Logger.DBG, Logger.SESSION_BEAN, "Size of studentMember list: "+ studentMembers.size());
		//this.studentMembers.add(student);		
		this.studentMembers = student;
		Logger.log(Logger.DBG, Logger.SESSION_BEAN, "Adicionou estudante na seção: NAME=" + student.getName());
	}
	
	public Student getStudentMembers() {
		return studentMembers;
	}

	public String getInit() {
		Logger.log( Logger.DBG, Logger.SESSION_BEAN, "Sessão iniciada");
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}
	
//	public void setMember(Student member) {
//		Logger.log( Logger.DBG, Logger.SESSION_BEAN, "Size of studentMember list: "+ );
//		this.studentMembers.size()
//		this.studentMembers.add(member);
//		
//		Logger.log( Logger.DBG, Logger.SESSION_BEAN, "Estudante adicionado");
//	}

}
