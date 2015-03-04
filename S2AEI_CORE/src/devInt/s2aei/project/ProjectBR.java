package devInt.s2aei.project;

import java.util.Date;
import java.util.List;

import devInt.s2aei.canvas.CanvasBR;
import devInt.s2aei.student.Student;
import devInt.s2aei.util.BRException;
import devInt.s2aei.util.DAOFactory;
import devInt.s2aei.util.Logger;

public class ProjectBR {

	private ProjectDAO projectDAO;

	public ProjectBR() {
		this.projectDAO = DAOFactory.createProjectDAO();
	}

	public void save(Project project) throws BRException {

		Integer id = project.getIdProject();
		Date dateNow = new Date(System.currentTimeMillis());
		project.setLastModDate(dateNow);

		List<Project> projectUser = this.projectDAO
				.findProjectByStudent(project.getLeader());

		if (projectUser.size() >= 1) {
			Logger.log(
					Logger.PROJECT_BR,
					Logger.DBG,
					"Estudante já é lider de outro projeto: "
							+ projectUser.size());
			throw new BRException("Estudante já está ativo em outro projeto.");
		}

		if (id == 0 || id == null) {
			project.setCreationDate(dateNow);
			project.setStatus("novo");
			this.generateCanvas(project);

			this.projectDAO.save(project);

		} else
			this.projectDAO.update(project);

	}

	public void generateCanvas(Project project) throws BRException {
		CanvasBR canvasBR = new CanvasBR();
		
		try {
			canvasBR.generateQuestions2Project(project);
		} catch (BRException e) {
			throw new BRException("Não foi possível gerar as perguntas.");
		}
	}

	public void changeStatus(Project project, String status) throws BRException {
		project.setStatus(status);

		this.save(project);

	}

	public void delete(Project project) {
		this.projectDAO.delete(project);
	}

	public List<Project> listAll() {
		return this.projectDAO.listAll();
	}

	public Project findById(Integer idProject) {
		return this.projectDAO.findById(idProject);
	}
	
	public Project findProjectActiveByStudent(Student student){
		List<Project> projects = this.projectDAO.findProjectByStudent(student);
		
		for (Project project : projects) {
			if (project.getStatus() != "encerrado" || project.getStatus() != "inativo") {
				return project;
			}
		}
		return null;
	}

}
