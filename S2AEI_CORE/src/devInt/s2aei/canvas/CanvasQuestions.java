package devInt.s2aei.canvas;

import devInt.s2aei.project.Project;
import devInt.s2aei.util.BRException;
import devInt.s2aei.util.Logger;

// ********************** PROTOTYPE CLASS *************************
public class CanvasQuestions {

	private CanvasDAO canvasDAO;
	
	private String frameClient = "Cliente";
	private String frameValor = "Valor";
	private String frameCom = "Comunicação Valor";
	private String frameReceita = "Receita";
	private String frameRecurso = "Recurso";
	
	private String q1FrameCliente = "Para quem vou vender meus produtos e/ou serviços?";
	private String q2FrameCliente = "Quem será meu cliente em potencial?";
	private String q3FrameCliente = "Esses clientes possuem necessidades em comum?";

	private String q1FrameValor = "Que valor será entregue para o cliente?";
	private String q2FrameValor = "Que tipo de problema seu produto/serviço vai resolver para o cliente?";

	private String q1FrameCom = "Como entregar valor para o cliente?";
	private String q2FrameCom = "Quais os diversos canais que se interagem ou se integram com clientes? ";

	private String q1FrameReceita = "Como você pretende ganhar dinheiro com este produto?";
	private String q2FrameReceita = "Qual valor os clientes estão dispostos a pagar?";
	private String q3FrameReceita = "Como seus clientes preferem pagar?";

	private String q1FrameRecurso = "Quais os recursos necessários para o canal de distribuição?";
	private String q2FrameRecurso = "Quais os recursos necessários para entregar as propostas de valor para os clientes?";
	private String q3FrameRecurso = "Quais os recursos necessários para o relacionamento com o cliente?";

	public CanvasQuestions(CanvasDAO canvasDAO) {
		this.canvasDAO = canvasDAO;
	}
	
	public void generateQuestions2Project(Project project)
			throws BRException {
		try {
			// description temp
			FrameCanvas frame;
			
			frame = this.generateFrame(frameClient);
			this.generateQuestion(project, frame, q1FrameCliente, q1FrameCliente);
			this.generateQuestion(project, frame, q2FrameCliente, q2FrameCliente);
			this.generateQuestion(project, frame, q3FrameCliente, q3FrameCliente);
			
			frame = this.generateFrame(frameValor);
			this.generateQuestion(project, frame, q1FrameValor, q1FrameValor);
			this.generateQuestion(project, frame, q2FrameValor, q2FrameValor);
			
			frame = this.generateFrame(frameCom);
			this.generateQuestion(project, frame, q1FrameCom, q1FrameCom);
			this.generateQuestion(project, frame, q2FrameCom, q2FrameCom);
			
			frame = this.generateFrame(frameReceita);
			this.generateQuestion(project, frame, q1FrameReceita, q1FrameReceita);
			this.generateQuestion(project, frame, q2FrameReceita, q2FrameReceita);
			this.generateQuestion(project, frame, q3FrameReceita, q3FrameReceita);
			
			frame = this.generateFrame(frameRecurso);
			this.generateQuestion(project, frame, q1FrameRecurso, q1FrameRecurso);
			this.generateQuestion(project, frame, q2FrameRecurso, q2FrameRecurso);
			this.generateQuestion(project, frame, q3FrameRecurso, q3FrameRecurso);
			
			Logger.log(Logger.CANVAS_QUESTION, Logger.DBG, "Perguntas geradas com sucesso. " );

		} catch (Exception e) {
			Logger.log(Logger.CANVAS_QUESTION, Logger.DBG, "Erro ao gerar perguntas canvas. " + e);
		}
	}

	private void generateQuestion(Project project, FrameCanvas frame, String question, String desc) {
		QuestionCanvas questionCanvas = new QuestionCanvas();
		questionCanvas.setQuestion(question);
		questionCanvas.setDescription(desc);
		questionCanvas.setFrameCanvas(frame);
		questionCanvas.setProject(project);
		
		try {
			canvasDAO.saveQuest(questionCanvas);
			Logger.log(Logger.CANVAS_QUESTION, Logger.DBG, "Pergunta gerada com sucesso." );
		} catch (Exception e) {
			Logger.log(Logger.CANVAS_QUESTION, Logger.DBG, "Não foi possível gerar pergunta Canvas. " + e);
		}
		
	}

	private FrameCanvas generateFrame(String description) {
		FrameCanvas frameCanvas = new FrameCanvas();
		frameCanvas.setDescription(description);
		frameCanvas.setStatus("");
		
		
		try {
			canvasDAO.saveFrame(frameCanvas);
			Logger.log(Logger.CANVAS_QUESTION, Logger.DBG, "Quadro canvas gerado com sucesso.");
			return frameCanvas;
		} catch (Exception e) {
			Logger.log(Logger.CANVAS_QUESTION, Logger.DBG, "Não foi possível gerar quadro Canvas. " + e);
			return null;
			
		}
		
	}

}
