package devInt.s2aei.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{ 
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			//Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		}catch(Throwable e){
			System.out.println("Criacao falhou"+ e);
			throw new ExceptionInInitializerError(e);
		}		
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
