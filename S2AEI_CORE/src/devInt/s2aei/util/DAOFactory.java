package devInt.s2aei.util;

import devInt.s2aei.admin.AdminDAO;
import devInt.s2aei.admin.AdminDAOHibernate;
import devInt.s2aei.project.ProjectDAO;
import devInt.s2aei.project.ProjectDAOHibernate;
import devInt.s2aei.reviewer.ReviewerDAO;
import devInt.s2aei.reviewer.ReviewerDAOHibernate;
import devInt.s2aei.student.StudentDAO;
import devInt.s2aei.student.StudentDAOHibernate;
import devInt.s2aei.studentProject.StudentProjectDAO;
import devInt.s2aei.studentProject.StudentProjectDAOHibernate;
import devInt.s2aei.teacher.TeacherDAO;
import devInt.s2aei.teacher.TeacherDAOHibernate;
import devInt.s2aei.user.UserDAO;
import devInt.s2aei.user.UserDAOHibernate;

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
		ReviewerDAOHibernate reviewerDAO = new ReviewerDAOHibernate();
		reviewerDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return reviewerDAO;
	}
	
	public static ProjectDAO createProjectDAO(){
		ProjectDAOHibernate projectDAO = new ProjectDAOHibernate();
		projectDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return projectDAO;
	}
	
	public static StudentProjectDAO createStudentProjectDAO(){
		StudentProjectDAOHibernate studentProjectDAO = new StudentProjectDAOHibernate();
		studentProjectDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return studentProjectDAO;
	}
	
	public static UserDAO createUserDAO(){
		UserDAOHibernate userDAO = new UserDAOHibernate();
		userDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return userDAO;
	}

}
