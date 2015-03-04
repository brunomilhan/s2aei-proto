package devInt.s2aei.reviewerUI;

import devInt.s2aei.reviewer.Reviewer;

public class EditReviewerFrame extends IncludeReviewerFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6024577046235385895L;

	public EditReviewerFrame(ReviewerGUIFrame mainFrame) {
		super(mainFrame);
		setTitle("Editar Avaliadores");
		buttonDelete.setVisible(true);
	}
	
	protected Reviewer loadReviewerFromPanel() {
		Reviewer reviewer = super.loadReviewerFromPanel();
		reviewer.setIdReviewer(getIdReviewer());
		return reviewer;
	}
	
}
