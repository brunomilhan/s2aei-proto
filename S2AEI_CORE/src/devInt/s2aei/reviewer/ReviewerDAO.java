package devInt.s2aei.reviewer;

import java.util.List;

public interface ReviewerDAO {

	public void save(Reviewer inspector);
	public void update(Reviewer inspector);
	public void delete(Reviewer inspector);
	public List<Reviewer> listAll();
	
}
