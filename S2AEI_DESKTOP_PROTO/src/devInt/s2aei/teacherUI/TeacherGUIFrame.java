package devInt.s2aei.teacherUI;

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

import devInt.s2aei.teacher.Teacher;
import devInt.s2aei.teacher.TeacherBR;
import devInt.s2aei.utils.DBController;

public class TeacherGUIFrame extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 3386662906919930428L;
	private TeacherTable teacherTable;
	private JScrollPane scrollPane;
	private JButton buttonNew;
//	private JButton buttonFindByName;
	private JButton buttonUpdateList;
	@SuppressWarnings("unused")
	private JMenuBar menubar;
	
	private IncludeTeacherFrame includeFrame;
	private EditTeacherFrame editFrame;
//	private FindTeacherFrame findFrame;
	
	@SuppressWarnings("unused")
	private DBController dbController;
	private TeacherBR teacherBR = new TeacherBR();
	
	public TeacherGUIFrame() {
		setTitle("Manter Professores");
		
		initComponent();
		addComponent();
		
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void initComponent() {
		teacherTable = new TeacherTable();
		teacherTable.addMouseListener(new EditTeacherListener());
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(teacherTable);

		buttonNew = new JButton();
		buttonNew.setText("Novo");
		buttonNew.setMnemonic(KeyEvent.VK_N);
		buttonNew.addActionListener(new IncludeTeacherListener());

//		buttonFindByName = new JButton();
//		buttonFindByName.setText("Buscar");
//		buttonFindByName.setMnemonic(KeyEvent.VK_B);
//		buttonFindByName.addActionListener(new FindTeacherListener());
		
		buttonUpdateList = new JButton();
		buttonUpdateList.setText("Atualizar");
		buttonUpdateList.setMnemonic(KeyEvent.VK_A);
		buttonUpdateList.addActionListener(new UpdateTeacherListener());
		
		menubar = new JMenuBar();
		
		includeFrame = new IncludeTeacherFrame(this);
		editFrame = new EditTeacherFrame(this);
//		findFrame = new FindTeacherFrame(this);
		
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
			SwingUtilities.invokeLater(newUpdateTeachersAction());
		} catch (Exception e) {
			System.exit(0);
		}
	}
	
	public Runnable newUpdateTeachersAction() {
		return new Runnable() {
			public void run() {
				try {					
					teacherTable.reload(teacherBR.listAll());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(TeacherGUIFrame.this,
							e.getMessage(), "Não foi possível carregar lista de professores", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}
	
	public void refreshTable(List<Teacher> teachers) {
		teacherTable.reload(teachers);
	}
	
	private class UpdateTeacherListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(newUpdateTeachersAction());
		}
	}
	
	private class IncludeTeacherListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			includeFrame.setVisible(true);
		}
	}
	
	private class EditTeacherListener extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (event.getClickCount() == 2) {
				Teacher teacher = teacherTable.getTeacherSelected();
				if (teacher != null) {
					editFrame.setTeacher(teacher);
					editFrame.setVisible(true);
				}
			}
		}
	}
	
//	private class FindTeacherListener implements ActionListener {
//		public void actionPerformed(ActionEvent event) {
//			findFrame.setVisible(true);
//		}
//	}

}
