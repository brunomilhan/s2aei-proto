package devInt.s2aei.canvas;

import java.util.List;

import devInt.s2aei.project.Project;

public interface CanvasDAO {

	public void saveQuest(QuestionCanvas questionCanvas);
	public void updateQuest(QuestionCanvas questionCanvas);
	public void deleteQuest(QuestionCanvas questionCanvas);
	public List<QuestionCanvas> listAllQuests();
	
	public void saveFrame(FrameCanvas frameCanvas);
	public void updateFrame(FrameCanvas frameCanvas);
	public void deleteFrame(FrameCanvas frameCanvas);
	public List<FrameCanvas> listAllFrames();
	
	public List<QuestionCanvas> listByProject(Project project);
}
