package devInt.s2aei.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import devInt.s2aei.util.HibernateUtil;
import devInt.s2aei.util.Logger;

public class DBController {

	private Session session = null;
	private Transaction transaction = null;

	public DBController() {
		try {
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
			if(!this.session.isOpen()) {				
				this.session = HibernateUtil.getSessionFactory().openSession();
			}
			this.transaction = this.session.beginTransaction();
			
			Logger.log(Logger.DB_CTRL, Logger.INFO, "Session and transaction init.");
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void closeSession(){
		this.session.close();
	}

	public Session getSession() {
		return session;
	}

	public Transaction getTransaction() {
		return transaction;
	}

}
