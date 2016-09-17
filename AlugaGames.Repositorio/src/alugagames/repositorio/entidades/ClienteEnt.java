package alugagames.repositorio.entidades;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import alugagames.core.clientes.Cliente;

@Entity(name="Cliente")
public class ClienteEnt extends Cliente {

	@Id
	@Column(length=16)
	@Override
	public UUID getId() {
		return super.getId();
	}

}
