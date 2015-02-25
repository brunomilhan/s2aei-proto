package devInt.s2aei.project;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import devInt.s2aei.student.Student;

public class ProjectDAOHibernate implements ProjectDAO {

	private Session session;

	@Override
	public void save(Project project) {
		this.session.save(project);
	}

	@Override
	public void update(Project project) {
		this.session.flush();
		this.session.clear();
		this.session.update(project);

	}

	@Override
	public void delete(Project project) {
		this.session.delete(project);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> listAll() {
		// TODO Auto-generated method stub
		return this.session.createCriteria(Project.class).list();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findProjectByStudent(Student student) {
		return this.session.createCriteria(Project.class).add(Restrictions.eq("leader", student)).list();
		
	}

}
