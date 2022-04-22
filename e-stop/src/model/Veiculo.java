package model;

public class Veiculo {
	
	private int idVeiculo;
	private String descricao;
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Veiculo(int idVeiculo, String descricao) {
		super();
		this.idVeiculo = idVeiculo;
		this.descricao = descricao;
	}
	public Veiculo() {
		super();
	}
	@Override
	public String toString() {
		return "Veiculo [idVeiculo=" + idVeiculo + ", descricao=" + descricao + "]";
	}

	
}
