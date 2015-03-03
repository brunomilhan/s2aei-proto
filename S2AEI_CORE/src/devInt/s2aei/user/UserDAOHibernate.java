package devInt.s2aei.user;

import org.hibernate.Session;

public class UserDAOHibernate implements UserDAO {

	private Session session;
	
	@Override
	public void save(User user) {
		this.session.save(user);

	}

	public void setSession(Session session) {
		this.session = session;
	}

}
