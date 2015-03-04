package devInt.s2aei.canvas;

import java.util.List;

import devInt.s2aei.project.Project;
import devInt.s2aei.util.BRException;
import devInt.s2aei.util.DAOFactory;
import devInt.s2aei.util.Logger;

public class CanvasBR {

	private CanvasDAO canvasDAO;

	public CanvasBR() {
		this.canvasDAO = DAOFactory.createCanvasDAO();
	}

	public void generateQuestions2Project(Project project) throws BRException {
		try {
			CanvasQuestions canvasQuestions = new CanvasQuestions(canvasDAO);
			canvasQuestions.generateQuestions2Project(project);
		} catch (Exception e) {
			Logger.log(Logger.CANVAS_BR, Logger.DBG, "Erro ao gerar as perguntas Canvas. " + e);
			
		}
	}

	public List<QuestionCanvas> listAll() {		
		return this.canvasDAO.listAllQuests();
	}
	
	public List<QuestionCanvas> listByProject(Project project){
		return this.canvasDAO.listByProject(project);
	}
}
