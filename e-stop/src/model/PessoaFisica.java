package model;

public class PessoaFisica extends Cliente
{
    private String cpf , nome;
    private Cliente cliente;
    
    public PessoaFisica()
    {
        super();
    }
    
    public PessoaFisica(String cpf , String nome , Cliente cliente)
    {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.cliente = cliente;
    }
    
    public PessoaFisica(String cpf , String nome , int idCliente , int numero , String logradouro , String complemento ,
                    String bairro , String cidade , String uf , String cep , String telefone1 , String telefone2 ,
                    String email)
    {
        super(idCliente , numero , logradouro , complemento , bairro , cidade , uf , cep , telefone1 , telefone2 ,
                        email);
        this.cpf = cpf;
        this.nome = nome;

    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }    
}