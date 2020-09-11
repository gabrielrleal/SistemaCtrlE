
public class Endereco {
	private String logradouro;
	private String numero;
	private String cidade;
	private String estado;

	public Endereco() {
		this("", "", "", "");

	}

	public Endereco(String logradouro, String numero, String cidade, String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String toString() {
		return "logradouro: " + this.logradouro + ",\n numero: " + this.numero + ",\n cidade: " + this.cidade
				+ ",\nestado: " + this.estado;
	}

	public String toStringGravador() {
		return this.logradouro + "\n" + this.numero + "\n" + this.cidade + "\n" + this.estado;
	}

}
