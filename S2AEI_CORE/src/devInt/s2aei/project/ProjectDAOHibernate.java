package devInt.s2aei.project;

import java.util.List;

import org.hibernate.Session;

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

	@Override
	public List<Project> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
