package devInt.s2aei.studentProject;

import java.util.List;

import org.hibernate.Session;

public class StudentProjectDAOHibernate implements StudentProjectDAO {
	
	private Session session;

	@Override
	public void save(StudentProject studentProject) {
		this.session.save(studentProject);
		
	}

	@Override
	public void update(StudentProject studentProject) {
		this.session.clear();
		this.session.flush();
		this.session.update(studentProject);
		
	}

	@Override
	public void delete(StudentProject studentProject) {
		this.session.delete(studentProject);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentProject> listAll() {		
		return this.session.createCriteria(StudentProject.class).list();
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
