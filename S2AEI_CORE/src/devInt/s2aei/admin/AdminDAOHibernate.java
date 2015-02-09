package devInt.s2aei.admin;

import java.util.List;

import org.hibernate.Session;

public class AdminDAOHibernate implements AdminDAO {
		
	private Session session;

	@Override
	public void save(Admin admin) {
		this.session.save(admin);
		
	}

	@Override
	public void delete(Admin admin) {
		this.session.delete(admin);
		
	}

	@Override
	public void update(Admin admin) {
		this.session.flush();
		this.session.clear();
		this.session.update(admin);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> listAll() {
		return this.session.createCriteria(Admin.class).list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
}
