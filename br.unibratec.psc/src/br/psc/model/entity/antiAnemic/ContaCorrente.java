package br.psc.model.entity.antiAnemic;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.psc.model.entity.EntityInterface;

@Entity
public class ContaCorrente implements EntityInterface {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -602377075516987816L;
	
	private short agencia;
	
	@Id
	private String numeroConta;
	
	private BigDecimal saldo;
	
	public ContaCorrente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ContaCorrente(short agencia, String numeroConta, BigDecimal saldo) {
		super();
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	
	
	public short getAgencia() {
		return agencia;
	}

	public void setAgencia(short agencia) {
		this.agencia = agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public void transferir(ContaCorrente pConta, BigDecimal pValor) {
		if ( pConta.saldo.compareTo(pValor) >= 0 ) {
			pConta.saldo = pConta.saldo.subtract(pValor);
			
			this.saldo = this.saldo.add(pValor);
		}
	}
	
	@Override
	public Object getPrimaryKey() {
		return this.getNumeroConta();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agencia;
		result = prime * result + ((numeroConta == null) ? 0 : numeroConta.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCorrente other = (ContaCorrente) obj;
		if (agencia != other.agencia)
			return false;
		if (numeroConta == null) {
			if (other.numeroConta != null)
				return false;
		} else if (!numeroConta.equals(other.numeroConta))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (saldo.compareTo(other.saldo) != 0)
			return false;
		return true;
	}
	
}