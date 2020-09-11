import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.projetolp.excecoes.MinicursoJaExisteException;
import com.projetolp.excecoes.MinicursoNaoExisteException;
import com.projetolp.excecoes.ParticipanteJaExisteException;
import com.projetolp.excecoes.ParticipanteNaoExisteException;

public class SistemaInscricoesList implements SistemaInscricoes {
	private List<Participante> participantes;
	private List<Minicurso> minicursos;

	public SistemaInscricoesList() {
		this.participantes = new ArrayList<Participante>();
		this.minicursos = new ArrayList<Minicurso>();
	}

	@Override
	public void cadastraParticipante(Participante p) throws ParticipanteJaExisteException {
		for (Participante i : this.participantes) {
			if (i.getEmail().equals(p.getEmail())) {
				throw new ParticipanteJaExisteException("já existe Participante cadastrado com esse e-mail ");
			}

		}
		this.participantes.add(p);

	}

	@Override
	public void removeParticipante(String emailParticipante) throws ParticipanteNaoExisteException {

		for (Participante p : this.participantes) {
			if (p.getEmail().equals(emailParticipante)) {
				this.participantes.remove(p);
				return;

			}
		}
		throw new ParticipanteNaoExisteException(" Participante não existe");

	}

	@Override
	public List<Participante> pesquisaParticipantesDaInstituicao(String nomeInstituicao)
			throws ParticipanteNaoExisteException {
		List<Participante> participantesInstituicao = new ArrayList<Participante>();
		for (Participante p : this.participantes) {
			if (p.getInstituicao().equals(nomeInstituicao)) {
				participantesInstituicao.add(p);
			} else
				throw new ParticipanteNaoExisteException("Não existem Participantes");
		}
		return participantesInstituicao;
	}

	@Override
	public List<Participante> pesquisaParticipantesDoEstado(String estado) {

		List<Participante> participantesEstado = new ArrayList<Participante>();

		for (Participante p : this.participantes) {
			if (p.getEndereco().getEstado().equals(estado)) {
				participantesEstado.add(p);
			}
		}
		return participantesEstado;
	}
	
	@Override
	public Participante pesquisaParticipanteDoEmail(String emailParticipante) throws ParticipanteNaoExisteException {
		for (Participante p : this.participantes) {
			if (p.getEmail().equals(emailParticipante)) {
				return p;
			}
		}
		throw new ParticipanteNaoExisteException(" Participante não existe");
	}

	@Override
	public void inscreveParticipanteEmMinicurso(String emailParticipante, String tituloMinicurso)
			throws ParticipanteNaoExisteException, MinicursoNaoExisteException {
		Minicurso mini = null;
		for (Minicurso p : this.minicursos) {
			if (p.getTituloMinicurso().equals(tituloMinicurso)) {
				mini = p;
			}
		}
		if (mini == null) {
			throw new MinicursoNaoExisteException("Minicurso Não Existe");
		} else {
			Participante parti = null;
			for (Participante i : this.participantes) {
				if (i.getEmail().equals(emailParticipante)) {
					parti = i;
				}
			}
			if (parti == null) {
				throw new ParticipanteNaoExisteException("Participante Não Existe");
			} else if (mini.getMaxParticipantes() > mini.getParticipantes().size()) {
				mini.adicionaParticipante(parti);
			} else {
				JOptionPane.showMessageDialog(null, "Minicurso está cheio.");
			}
		}
	}

	@Override
	public List<Participante> getListaTotalDeParticipantes() {
		return this.participantes;
	}

	@Override
	public List<Participante> getParticipantesDoMinicurso(String tituloMinicurso) throws MinicursoNaoExisteException { // FALTA
		for (Minicurso m : this.minicursos) {
			if (m.getTituloMinicurso().equals(tituloMinicurso)) {
				return m.getParticipantes();
			}
		}
		throw new MinicursoNaoExisteException("Minicurso não existe");
	}

	@Override
	public void cadastraMinicurso(Minicurso m) throws MinicursoJaExisteException {
		if (minicursos.contains(m)) {
			throw new MinicursoJaExisteException("Minicurso Ja Existe");
		} else {
			minicursos.add(m);
		}
	}

	@Override
	public Minicurso pesquisaMinicurso(String titulo) throws MinicursoNaoExisteException {
		for (Minicurso m : this.minicursos) {
			if (m.getTituloMinicurso().equals(titulo)) {
				return m;
			}
		}
		throw new MinicursoNaoExisteException("Minicurso nao existe!");
	}
}
