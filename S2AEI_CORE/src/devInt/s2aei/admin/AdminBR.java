package devInt.s2aei.admin;

import java.util.List;

import devInt.s2aei.user.UserBR;
import devInt.s2aei.util.DAOFactory;

public class AdminBR {
	
	private AdminDAO adminDAO;
	public AdminBR(){
		this.adminDAO = DAOFactory.createAdminDAO();
	}

	public void save(Admin admin){
		Integer idAdmin = admin.getIdAdmin();
		
		if(idAdmin == null || idAdmin == 0){
			
			UserBR userBR = new UserBR(admin.getEmail(), admin.getPassword(), "ROLE_ADMIN");
			userBR.save();
			
			this.adminDAO.save(admin);
		}else{
			this.adminDAO.update(admin);
		}
	}

	public void delete(Admin admin){
		this.adminDAO.delete(admin);
	}

	public List<Admin> listAll(){
		return this.adminDAO.listAll();
	}

}
