package devInt.s2aei.util;

import devInt.s2aei.admin.AdminDAO;
import devInt.s2aei.admin.AdminDAOHibernate;
import devInt.s2aei.reviewer.ReviewerDAO;
import devInt.s2aei.reviewer.ReviewerDAOHibernate;
import devInt.s2aei.student.StudentDAO;
import devInt.s2aei.student.StudentDAOHibernate;
import devInt.s2aei.teacher.TeacherDAO;
import devInt.s2aei.teacher.TeacherDAOHibernate;

public class DAOFactory {

	public DAOFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static AdminDAO createAdminDAO(){
		AdminDAOHibernate adminDAO = new AdminDAOHibernate();
		adminDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return adminDAO;
	}
	
	public static StudentDAO createStudentDAO(){
		StudentDAOHibernate studentDAO = new StudentDAOHibernate();
		studentDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return studentDAO;
	}
	
	public static TeacherDAO createTeacherDAO(){
		TeacherDAOHibernate teacherDAO = new TeacherDAOHibernate();
		teacherDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return teacherDAO;
	}
	
	public static ReviewerDAO createInspectorDAO(){
		ReviewerDAOHibernate inspectorDAO = new ReviewerDAOHibernate();
		inspectorDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return inspectorDAO;
	}

}
