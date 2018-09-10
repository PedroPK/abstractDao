package br.psc.model.entity.oneToOne;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import br.psc.model.entity.EntityInterface;

@Entity
public class DadosBasicos implements EntityInterface {
	
	/**
	 * - Serial Version UID 
	 */
	private static final long serialVersionUID = -162646629816141702L;
	
	@Id
	private String cpf;
	
	private String	nome;
	
	@Column(name="DT_NASCIMENTO")
	private Date	dtNascimento;
	
	//private Aluno aluno;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDtNascimento() {
		return dtNascimento;
	}
	
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	/*public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf 			== null)	? 0 : cpf			.hashCode());
		result = prime * result + ((dtNascimento	== null)	? 0 : dtNascimento	.hashCode());
		result = prime * result + ((nome			== null)	? 0 : nome			.hashCode());
		//result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
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
		DadosBasicos other = (DadosBasicos) obj;
		
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		
		if (dtNascimento == null) {
			if (other.dtNascimento != null)
				return false;
		} else if (!dtNascimento.equals(other.dtNascimento))
			return false;
		
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		
		/*if (aluno == null) {
			if (other.aluno!= null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;*/
		
		return true;
	}

	
	@Override
	public Object getPrimaryKey() {
		return getCpf();
	}
	
}