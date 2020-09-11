import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeParticipantes {

	public void gravaParticipantes(List<Participante> participantes, String nomeArquivo) throws IOException {
		BufferedWriter gravador = null;

		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Participante p : participantes) {
				gravador.write(p.toStringGravador() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (gravador != null) {
				gravador.close();
			}
		}

	}

	public List<Participante> recuperaParticipantes(String nomeArquivo) throws IOException {

		BufferedReader leitor = null;
		List<Participante> participantes = new ArrayList<Participante>();

		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));

			String nome = null;
			String email = "";
			String instituicao = "";
			String logradouro = "";
			String numero = "";
			String cidade = "";
			String estado = "";
			do {
				nome = leitor.readLine();
				if (nome != null) {
					email = leitor.readLine();
					instituicao = leitor.readLine();
					logradouro = leitor.readLine();
					numero = leitor.readLine();
					cidade = leitor.readLine();
					estado = leitor.readLine();
					Endereco endereço = new Endereco(logradouro, numero, cidade, estado);
					Participante p = new Participante(nome, email, instituicao, endereço);
					participantes.add(p);
				}
			} while (nome != null);

		} finally {
			if (leitor != null) {
				leitor.close();
			}
		}
		return participantes;
	}
}