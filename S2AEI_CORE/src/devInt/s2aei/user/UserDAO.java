package devInt.s2aei.user;

public interface UserDAO {

	public void save(User user);

	public User findByLogin(String login);
}
