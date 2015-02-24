package devInt.s2aei.project;

import java.util.Date;
import java.util.List;

import devInt.s2aei.util.DAOFactory;

public class ProjectBR {

	private ProjectDAO projectDAO;

	public ProjectBR() {
		this.projectDAO = DAOFactory.createProjectDAO();
	}

	public void save(Project project) {
		Integer id = project.getIdProject();
		Date dateNow = new Date(System.currentTimeMillis());		
		project.setLastModDate(dateNow);
		
		
		if (id == 0 || id == null) {
			project.setCreationDate(dateNow);			
			project.setStatus("novo");
			
			this.projectDAO.save(project);
		} else
			this.projectDAO.update(project);

	}
	
	
	public void changeStatus(Project project, String status){
		project.setStatus(status);
		
		this.save(project);
		
	}

	public void delete(Project project) {
		this.projectDAO.delete(project);
	}

	public List<Project> listAll() {
		return this.projectDAO.listAll();
	}

}
