public class Participante {
	private String nome;
	private String email;
	private String instituicao;
	private Endereco endereco;

	public Participante(String nome, String email, String instituicao, Endereco endereco) {
		this.nome = nome;
		this.email = email;
		this.instituicao = instituicao;
		this.endereco = endereco;
	}
	
	public Participante() {
		this("", "", "", new Endereco());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String toString() {
		return "\nPARTICIPANTE:\n nome: " + this.nome + ",\n email: " + this.email + ",\n instituicao: "
				+ this.instituicao + ",\n ENDERECO:\n " + this.endereco;
	}

	public String toStringGravador() {
		return this.nome + "\n" + this.email + "\n" + this.instituicao + "\n" + this.endereco.toStringGravador();
	}

}
