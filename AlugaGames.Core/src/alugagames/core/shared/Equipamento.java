package alugagames.core.shared;

public abstract class Equipamento {
	
	private StatusEquipamento status;
	private boolean ativo;
	
	public StatusEquipamento getStatus() {
		return status;
	}
	public void setStatus(StatusEquipamento status) {
		this.status = status;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
