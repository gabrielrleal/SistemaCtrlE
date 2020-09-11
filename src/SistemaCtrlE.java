
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

import com.projetolp.excecoes.MinicursoJaExisteException;
import com.projetolp.excecoes.MinicursoNaoExisteException;
import com.projetolp.excecoes.ParticipanteJaExisteException;
import com.projetolp.excecoes.ParticipanteNaoExisteException;

public class SistemaCtrlE {

	private static SistemaInscricoesList sis = new SistemaInscricoesList();
	private static GravadorDeParticipantes gravador;
	public static void main(String[] args) {
		
		gravador = new GravadorDeParticipantes();
		
		
		String nomeArquivo =JOptionPane.showInputDialog("digite o nome do arquivo para recuperar:");
		try {
			List<Participante> recuperado = gravador.recuperaParticipantes(nomeArquivo);
			sis.getListaTotalDeParticipantes().addAll(recuperado);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		boolean acabou = false;
		while (!acabou) {
			int op = Integer.parseInt(JOptionPane.showInputDialog(null,
					"1-Grava Participantes\n2-Cadastra Participante \n3-Remove Participante\n4- Pesquisa Participantes Da Instituicao \n5-Pesquisa Participante Do Estado "
							+ "\n6-Pesquisa Participante Pelo Email \n7-Inscreve Participante Em Minicurso	\n8-Obter Lista Total De Participantes\n"
							+ "9-Obter Participantes Do Minicurso \n10-Cadastra Minicurso\n11-Pesquisa Minicurso\n12-Sair"));
			switch (op) {
			
			case 1:
				gravaParticipantes();
				break;
			case 2:
				cadastrarParticipante();
				break;
			case 3:
				removeParticipante();
				break;
			case 4:
				pesquisaParticipantesDaInstituicao();
				break;
			case 5:
				pesquisaParticipanteDoEstado();
				break;
			case 6:
				pesquisaParticipanteDoEmail();
				break;
			case 7:
				InscreveParticipanteEmMinicurso();
				break;
			case 8:
				getListaTotalDeParticipantes();
				break;
			case 9:
				getListaParticipantesDoMinicurso();
				break;
			case 10:
				cadastraMiniCurso();
				break;
			case 11:
				pesquisaMinicurso();
				break;
			case 12:
				sairDoPrograma();
				break;
			}
		}
	}



	public static void gravaParticipantes() {
		try {
			String nomeArquivo = JOptionPane.showInputDialog("Digite nome do arquivo");
			gravador.gravaParticipantes(sis.getListaTotalDeParticipantes(), nomeArquivo);
			JOptionPane.showMessageDialog(null, "Gravação efetuada com sucesso");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static void cadastrarParticipante() {
		try {
			Participante p = criarParticipante();
			sis.cadastraParticipante(p);
		} catch (ParticipanteJaExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void pesquisaMinicurso() {
		String miniCurso = JOptionPane.showInputDialog("Digite o Minicurso");
		try {
			JOptionPane.showMessageDialog(null, sis.pesquisaMinicurso(miniCurso));
		} catch (MinicursoNaoExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void cadastraMiniCurso() {
		String tituloMinicurso = JOptionPane.showInputDialog("Digite o titulo do curso");
		int maxParticipantes = Integer
				.parseInt(JOptionPane.showInputDialog("Digite o numero maximo de participantes:"));
		Minicurso m = new Minicurso(tituloMinicurso, maxParticipantes);
		try {
			sis.cadastraMinicurso(m);
		} catch (MinicursoJaExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void sairDoPrograma() {
		int op2 = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", null, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (op2 == JOptionPane.YES_OPTION) {
			System.exit(0);
		} else if (op2 == JOptionPane.CANCEL_OPTION) {
			return;
		}
	}

	private static void getListaParticipantesDoMinicurso() {
		String tituloMinicurso = JOptionPane.showInputDialog("Digite o titulo do curso");
		try {
			JOptionPane.showMessageDialog(null, sis.getParticipantesDoMinicurso(tituloMinicurso).toString());
		} catch (MinicursoNaoExisteException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void getListaTotalDeParticipantes() {
		JOptionPane.showMessageDialog(null, sis.getListaTotalDeParticipantes());
	}

	private static void InscreveParticipanteEmMinicurso() {
		String email = JOptionPane.showInputDialog("Digite o email do participante:");
		String tituloMinicurso = JOptionPane.showInputDialog("Digite o titulo do curso");
		try {
			sis.inscreveParticipanteEmMinicurso(email, tituloMinicurso);
		} catch (ParticipanteNaoExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (MinicursoNaoExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void pesquisaParticipanteDoEmail() {
		String email = JOptionPane.showInputDialog("Digite o email do participante:");
		try {
			JOptionPane.showMessageDialog(null, sis.pesquisaParticipanteDoEmail(email));
		} catch (ParticipanteNaoExisteException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void pesquisaParticipanteDoEstado() {
		String estado = JOptionPane.showInputDialog("Digite o estado");
		JOptionPane.showMessageDialog(null, sis.pesquisaParticipantesDoEstado(estado));
	}

	private static void pesquisaParticipantesDaInstituicao() {
		String instituicao = JOptionPane.showInputDialog("Digite o nome da instituicao:");
		try {
			JOptionPane.showMessageDialog(null, sis.pesquisaParticipantesDaInstituicao(instituicao));
		} catch (ParticipanteNaoExisteException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void removeParticipante() {
		String email = JOptionPane.showInputDialog("Digite o email do participante:");
		try {
			sis.removeParticipante(email);
		} catch (ParticipanteNaoExisteException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static Participante criarParticipante() {
		String nome = JOptionPane.showInputDialog("Digite o nome do participante:");
		String email = JOptionPane.showInputDialog("Digite o email do participante:");
		String instituicao = JOptionPane.showInputDialog("Digite o nome da instituicao:");

		String logradouro = JOptionPane.showInputDialog("Digite o logradouro");
		String numero = JOptionPane.showInputDialog("Digite o numero");
		String cidade = JOptionPane.showInputDialog("Digite o cidade");
		String estado = JOptionPane.showInputDialog("Digite o estado");
		Endereco end = new Endereco(logradouro, numero, cidade, estado);

		Participante part = new Participante(nome, email, instituicao, end);

		return part;
	}
}
