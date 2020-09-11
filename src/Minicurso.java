import java.util.LinkedList;
import java.util.List;

public class Minicurso {
	private List<Participante> participantes;
	private int maxParticipantes;
	private String tituloMinicurso;

	public Minicurso() {
		this.maxParticipantes = 0;
		this.tituloMinicurso = null;
		this.participantes = new LinkedList<>();

	}

	public Minicurso(String tituloMinicurso, int maxParticipantes) {
		this.maxParticipantes = maxParticipantes;
		this.tituloMinicurso = tituloMinicurso;
		this.participantes = new LinkedList<>();
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public int getMaxParticipantes() {
		return maxParticipantes;
	}

	public String getTituloMinicurso() {
		return tituloMinicurso;
	}

	public void adicionaParticipante(Participante part) {
		participantes.add(part);

	}

}
