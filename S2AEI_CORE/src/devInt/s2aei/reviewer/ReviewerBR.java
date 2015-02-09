package devInt.s2aei.reviewer;

import java.util.List;

import devInt.s2aei.util.DAOFactory;

public class ReviewerBR {
	
	private ReviewerDAO inspectorDAO;
	
	public ReviewerBR(){
		this.inspectorDAO = DAOFactory.createInspectorDAO();
	}

	public void save(Reviewer inspector){
		Integer idAdmin = inspector.getIdInspector();
		
		if(idAdmin == null || idAdmin == 0){
			this.inspectorDAO.save(inspector);
		}else{
			this.inspectorDAO.update(inspector);
		}
	}

	public void delete(Reviewer inspector){
		this.inspectorDAO.delete(inspector);
	}

	public List<Reviewer> listAll(){
		return this.inspectorDAO.listAll();
	}

}
