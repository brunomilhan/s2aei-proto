package devInt.s2aei.reviewerUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import devInt.s2aei.reviewer.Reviewer;


public class ReviewerTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5529636602851394745L;

	private List<Reviewer> reviewers;
	
	private String[] colNames = { "Nome", "Email", "Status" };
	private Class<?>[] colTypes = { String.class, String.class, String.class };
	
	public ReviewerTableModel(){
	}
	
	public void reload(List<Reviewer> reviewers) {
		this.reviewers = reviewers;
		fireTableDataChanged();
	}

	@Override
	public Class<?> getColumnClass(int column) {
		return colTypes[column];
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	@Override
	public int getRowCount() {
		if (reviewers == null){
			return 0;
		}
		return reviewers.size();
	}

	@Override
	public Object getValueAt(int line, int column) {
		Reviewer reviewer = reviewers.get(line);
		switch (column) {
		case 0:
			return reviewer.getName();
		case 1:
			return reviewer.getEmail();
		case 2:
			return reviewer.getStatus();
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Reviewer getReviewerAt(int index) {
		return reviewers.get(index);
	}
}
