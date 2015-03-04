package devInt.s2aei.studentProject;

import java.util.List;

public interface StudentProjectDAO {
	
	public void save(StudentProject studentProject);
	public void update(StudentProject studentProject);
	public void delete(StudentProject studentProject);
	
	public List<StudentProject> listAll();

}
