package devInt.s2aei.reviewerUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import devInt.s2aei.reviewer.Reviewer;
import devInt.s2aei.reviewer.ReviewerBR;
import devInt.s2aei.utils.DBController;

public class ReviewerGUIFrame extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 3386662906919930428L;
	private ReviewerTable reviewerTable;
	private JScrollPane scrollPane;
	private JButton buttonNew;
//	private JButton buttonFindByName;
	private JButton buttonUpdateList;
	@SuppressWarnings("unused")
	private JMenuBar menubar;
	
	private IncludeReviewerFrame includeFrame;
	private EditReviewerFrame editFrame;
//	private FindReviewerFrame findFrame;
	
	@SuppressWarnings("unused")
	private DBController dbController;
	private ReviewerBR reviewerBR = new ReviewerBR();
	
	public ReviewerGUIFrame() {
		setTitle("Manter Avaliadores");
		
		initComponent();
		addComponent();
		
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void initComponent() {
		reviewerTable = new ReviewerTable();
		reviewerTable.addMouseListener(new EditReviewerListener());
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(reviewerTable);

		buttonNew = new JButton();
		buttonNew.setText("Novo");
		buttonNew.setMnemonic(KeyEvent.VK_N);
		buttonNew.addActionListener(new IncludeReviewerListener());

//		buttonFindByName = new JButton();
//		buttonFindByName.setText("Buscar");
//		buttonFindByName.setMnemonic(KeyEvent.VK_B);
//		buttonFindByName.addActionListener(new FindReviewerListener());
		
		buttonUpdateList = new JButton();
		buttonUpdateList.setText("Atualizar");
		buttonUpdateList.setMnemonic(KeyEvent.VK_A);
		buttonUpdateList.addActionListener(new UpdateReviewerListener());
		
		menubar = new JMenuBar();
		
		includeFrame = new IncludeReviewerFrame(this);
		editFrame = new EditReviewerFrame(this);
//		findFrame = new FindReviewerFrame(this);
		
		initDBController();
	}
	
	private void addComponent(){
		add(scrollPane);
		JPanel panel = new JPanel();
		panel.add(buttonNew);
//		panel.add(buttonFindByName);
		panel.add(buttonUpdateList);
		add(panel, BorderLayout.SOUTH);
	}
	
	private void initDBController() {
		try {
			this.dbController = new DBController();
			SwingUtilities.invokeLater(newUpdateReviewersAction());
		} catch (Exception e) {
			System.exit(0);
		}
	}
	
	public Runnable newUpdateReviewersAction() {
		return new Runnable() {
			public void run() {
				try {					
					reviewerTable.reload(reviewerBR.listAll());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(ReviewerGUIFrame.this,
							e.getMessage(), "Não foi possível carregar lista de avaliadores", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}
	
	public void refreshTable(List<Reviewer> reviewers) {
		reviewerTable.reload(reviewers);
	}
	
	private class UpdateReviewerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(newUpdateReviewersAction());
		}
	}
	
	private class IncludeReviewerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			includeFrame.setVisible(true);
		}
	}
	
	private class EditReviewerListener extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (event.getClickCount() == 2) {
				Reviewer reviewer = reviewerTable.getReviewerSelected();
				if (reviewer != null) {
					editFrame.setReviewer(reviewer);
					editFrame.setVisible(true);
				}
			}
		}
	}
	
//	private class FindReviewerListener implements ActionListener {
//		public void actionPerformed(ActionEvent event) {
//			findFrame.setVisible(true);
//		}
//	}

}
