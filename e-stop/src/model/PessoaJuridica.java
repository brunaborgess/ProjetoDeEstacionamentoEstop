package model;

public class PessoaJuridica extends Cliente{
	
	private String cnpj;
	private String razaoSocial;
	private Cliente cliente;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public PessoaJuridica(int idCliente, String logradouro, int numero, String complemento, String bairro,
			String cidade, String uf, String cep, String telefone1, String telefone2, String email,
			String cnpj, String razaoSocial) {
		super(idCliente , numero , telefone2 , email , logradouro , telefone1 ,
                        complemento , bairro , cidade , uf , cep);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}
	public PessoaJuridica(String cnpj, String razaoSocial, Cliente cliente) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.cliente = cliente;
	}
	public PessoaJuridica() {
		super();
	}
}