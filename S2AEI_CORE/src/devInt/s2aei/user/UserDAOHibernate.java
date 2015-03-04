package devInt.s2aei.user;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserDAOHibernate implements UserDAO {

	private Session session;
	
	@Override
	public void save(User user) {
		this.session.save(user);

	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public User findByLogin(String login) {		
		return (User) this.session.createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
	}

}
