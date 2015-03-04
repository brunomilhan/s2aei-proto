package devInt.s2aei.reviewerUI;

import java.util.List;

import javax.swing.JTable;

import devInt.s2aei.reviewer.Reviewer;

public class ReviewerTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 834285452360487161L;
	private ReviewerTableModel model;
	
	public ReviewerTable() {
		model = new ReviewerTableModel();
		setModel(model);
	}
	
	public Reviewer getReviewerSelected() {
		int i = getSelectedRow();
		if (i < 0) {
			return null;
		}
		return model.getReviewerAt(i);
	}
	
	public void reload(List<Reviewer> reviewers) {
		model.reload(reviewers);
	}
}
