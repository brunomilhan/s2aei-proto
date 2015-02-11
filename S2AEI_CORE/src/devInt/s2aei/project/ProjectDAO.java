package devInt.s2aei.project;

import java.util.List;

public interface ProjectDAO {
	
	public void save(Project project);
	public void update(Project project);
	public void delete(Project project);
	
	public List<Project> listAll();

}
