package devInt.s2aei.project;

import java.util.List;

import devInt.s2aei.util.DAOFactory;

public class ProjectBR {

	private ProjectDAO projectDAO;

	public ProjectBR() {
		this.projectDAO = DAOFactory.createProjectDAO();
	}

	public void save(Project project) {

		Integer id = project.getIdProject();
		if (id == 0 || id == null) {
			this.projectDAO.save(project);
		} else
			this.projectDAO.update(project);

	}

	public void delete(Project project) {
		this.projectDAO.delete(project);
	}

	public List<Project> listAll() {
		return this.projectDAO.listAll();
	}

}
