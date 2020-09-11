import java.util.List;

import com.projetolp.excecoes.MinicursoJaExisteException;
import com.projetolp.excecoes.MinicursoNaoExisteException;
import com.projetolp.excecoes.ParticipanteJaExisteException;
import com.projetolp.excecoes.ParticipanteNaoExisteException;

public interface SistemaInscricoes {
	public void cadastraParticipante(Participante pessoa) throws ParticipanteJaExisteException;

	public void removeParticipante(String nomeParticipante) throws ParticipanteNaoExisteException;

	public List<Participante> pesquisaParticipantesDaInstituicao(String nomeInstituicao)
			throws ParticipanteNaoExisteException;

	public List<Participante> pesquisaParticipantesDoEstado(String estado);

	public Participante pesquisaParticipanteDoEmail(String email) throws ParticipanteNaoExisteException;

	public void inscreveParticipanteEmMinicurso(String emailParticipante, String tituloMinicurso)
			throws ParticipanteNaoExisteException, MinicursoNaoExisteException;

	public List<Participante> getListaTotalDeParticipantes();

	public List<Participante> getParticipantesDoMinicurso(String tituloMinicurso) throws MinicursoNaoExisteException;

	public void cadastraMinicurso(Minicurso m) throws MinicursoJaExisteException;

	public Minicurso pesquisaMinicurso(String titulo) throws MinicursoNaoExisteException;
	// mudar todos os nomes pesquisaParticipanteDoEmail para
	// pesquisaParticipante
}