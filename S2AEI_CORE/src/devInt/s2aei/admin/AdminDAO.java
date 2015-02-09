package devInt.s2aei.admin;

import java.util.List;

public interface AdminDAO {
	public void save(Admin admin);
	public void delete(Admin admin);
	public void update(Admin admin);
	public List<Admin> listAll();
	

}
