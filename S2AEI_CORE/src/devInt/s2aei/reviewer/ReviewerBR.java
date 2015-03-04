package devInt.s2aei.reviewer;

import java.util.Date;
import java.util.List;

import devInt.s2aei.user.UserBR;
import devInt.s2aei.util.DAOFactory;

public class ReviewerBR {
	
	private ReviewerDAO reviewerDAO;
	
	public ReviewerBR(){
		this.reviewerDAO = DAOFactory.createInspectorDAO();
	}

	public void save(Reviewer reviewer){
		Integer idAdmin = reviewer.getIdReviewer();
		reviewer.setStatus("ativo");
		reviewer.setLastModDate(new Date(System.currentTimeMillis()));
		
		if(idAdmin == null || idAdmin == 0){
			this.reviewerDAO.save(reviewer);
			
			reviewer.setCadDate(new Date(System.currentTimeMillis()));
			UserBR userBR = new UserBR(reviewer.getEmail(), reviewer.getPassword(), "ROLE_REVIEWER");
			userBR.save();
		}else{
			this.reviewerDAO.update(reviewer);
		}
	}

	public void delete(Reviewer reviewer){
		this.reviewerDAO.delete(reviewer);
	}

	public List<Reviewer> listAll(){
		return this.reviewerDAO.listAll();
	}

}
