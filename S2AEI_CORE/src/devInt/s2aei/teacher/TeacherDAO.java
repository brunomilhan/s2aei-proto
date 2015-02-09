package devInt.s2aei.teacher;

import java.util.List;

public interface TeacherDAO {
	public void save(Teacher teacher);
	public void update(Teacher teacher);
	public void delete(Teacher teacher);
	public List<Teacher> listAll();

}
