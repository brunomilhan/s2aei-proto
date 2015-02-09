package devInt.s2aei.reviewer;

import java.util.List;

import org.hibernate.Session;

public class ReviewerDAOHibernate implements ReviewerDAO {
	private Session session;
	
	@Override
	public void save(Reviewer inspector) {
		this.session.save(inspector);
		
	}

	@Override
	public void update(Reviewer inspector) {
		this.session.flush();
		this.session.clear();
		this.session.update(inspector);
		
	}

	@Override
	public void delete(Reviewer inspector) {
		this.session.delete(inspector);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reviewer> listAll() {
		// TODO Auto-generated method stub
		return this.session.createCriteria(Reviewer.class).list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
		
}
