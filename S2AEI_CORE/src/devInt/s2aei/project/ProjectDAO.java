package devInt.s2aei.project;

import java.util.List;

import devInt.s2aei.student.Student;

public interface ProjectDAO {
	
	public void save(Project project);
	public void update(Project project);
	public void delete(Project project);
	
	public List<Project> findProjectByStudent(Student student);
	
	
	public List<Project> listAll();
	public Project findById(Integer idProject);

}
