package devInt.s2aei.user;

import devInt.s2aei.util.DAOFactory;

public class UserBR {
	
	private UserDAO userDAO;
	
	public UserBR() {
		this.userDAO = DAOFactory.createUserDAO();
	}
	
	public void save(User user){
		this.userDAO.save(user);
	}

}
