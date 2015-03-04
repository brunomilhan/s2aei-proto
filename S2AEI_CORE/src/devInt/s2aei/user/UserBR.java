package devInt.s2aei.user;

import devInt.s2aei.util.DAOFactory;

public class UserBR {
	
	private UserDAO userDAO;
	private User user = new User();
	
	public UserBR(){
		
	}
	
	public UserBR(String login, String password, String permission) {
		this.userDAO = DAOFactory.createUserDAO();
				
		user.setLogin(login);
		user.setPassword(password);
		user.setPermission(permission);
		
	}
	
	public void save(){
		this.userDAO.save(user);
	}

	public User findByLogin(String login) {
		return this.userDAO.findByLogin(login);
	}

}
