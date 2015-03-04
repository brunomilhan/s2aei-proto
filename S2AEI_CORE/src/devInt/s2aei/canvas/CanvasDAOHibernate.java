package devInt.s2aei.canvas;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import devInt.s2aei.project.Project;

public class CanvasDAOHibernate implements CanvasDAO {
	
	private Session session;

	@Override
	public void saveQuest(QuestionCanvas questionCanvas) {
		this.session.save(questionCanvas);		
	}

	@Override
	public void updateQuest(QuestionCanvas questionCanvas) {
		this.session.flush();
		this.session.clear();
		this.session.update(questionCanvas);
		
	}

	@Override
	public void deleteQuest(QuestionCanvas questionCanvas) {
		this.session.delete(questionCanvas);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionCanvas> listAllQuests() {		
		return this.session.createCriteria(QuestionCanvas.class).list();
	}

	@Override
	public void saveFrame(FrameCanvas frameCanvas) {
		this.session.save(frameCanvas);
		
	}

	@Override
	public void updateFrame(FrameCanvas frameCanvas) {
		this.session.clear();
		this.session.flush();
		this.session.update(frameCanvas);
	}

	@Override
	public void deleteFrame(FrameCanvas frameCanvas) {
		this.session.delete(frameCanvas);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FrameCanvas> listAllFrames() {
		return this.session.createCriteria(FrameCanvas.class).list();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionCanvas> listByProject(Project project) {
		return this.session.createCriteria(QuestionCanvas.class).add(Restrictions.eq("project", project)).list();
	}
}
