package devInt.s2aei.student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class StudentDAOHibernate implements StudentDAO {

	private Session session;

	@Override
	public void save(Student student) {
		this.session.save(student);

	}

	@Override
	public void update(Student student) {
		this.session.flush();
		this.session.clear();
		this.session.update(student);

	}

	@Override
	public void delete(Student student) {
		this.session.delete(student);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listAll() {
		// TODO Auto-generated method stub
		return this.session.createCriteria(Student.class).list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	// new changes v2
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listById(Integer idStudent) {

		return this.session.createCriteria(Student.class)
				.createAlias("student", "std")
				.add(Restrictions.eq("std.idStudent", idStudent)).list();
	}
}
