package devInt.s2aei.teacher;

import java.util.List;

import org.hibernate.Session;

public class TeacherDAOHibernate implements TeacherDAO{

	private Session session;
	
	@Override
	public void save(Teacher teacher) {
		this.session.save(teacher);
		
	}

	@Override
	public void update(Teacher teacher) {
		this.session.flush();
		this.session.clear();
		this.session.update(teacher);
		
	}

	@Override
	public void delete(Teacher teacher) {
		this.session.delete(teacher);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> listAll() {
		// TODO Auto-generated method stub
		return this.session.createCriteria(Teacher.class).list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
}
