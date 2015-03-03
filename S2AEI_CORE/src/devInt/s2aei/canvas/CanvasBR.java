package devInt.s2aei.canvas;

import devInt.s2aei.util.DAOFactory;

public class CanvasBR {
	
	private CanvasDAO canvasDAO;
	
	public CanvasBR() {
		this.canvasDAO = DAOFactory.createCanvasDAO();
	}
	
}
