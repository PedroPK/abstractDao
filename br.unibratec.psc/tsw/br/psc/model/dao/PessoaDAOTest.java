package br.psc.model.dao;

import static org.junit.Assert.assertNull;

import javax.persistence.RollbackException;

import org.junit.Test;

import br.psc.model.entity.dao.DadosBasicosDAO;
import br.psc.model.entity.oneToOne.DadosBasicos;
import br.psc.model.entity.oneToOne.Pessoa;

public class PessoaDAOTest {
	
	@Test
	public void testIncluirAluno_SemDadosBasicos() {
		Pessoa aluno = new Pessoa();
		PessoaDAO dao = new PessoaDAO();
		
		dao.insert(aluno);
	}
	
	@Test(expected=RollbackException.class)
	public void testIncluirApenasAluno_ComDadosBasicos() {
		DadosBasicos dados = new DadosBasicos();
		dados.setCpf("123.456.789-01");
		
		Pessoa aluno = new Pessoa();
		aluno.setDadosBasicos(dados);
		
		PessoaDAO dao = new PessoaDAO();
		
		dao.insert(aluno);
	}
	
	@Test
	public void testIncluirApenasDadosBasicos_AlunoComDadosBasicos() {
		DadosBasicos dados = new DadosBasicos();
		dados.setCpf("123.456.789-02");
		
		Pessoa aluno = new Pessoa();
		aluno.setDadosBasicos(dados);
		
		PessoaDAO aDao = new PessoaDAO();
		DadosBasicosDAO dbDao = new DadosBasicosDAO();
		
		dbDao.insert(dados);
		Pessoa selectedAluno = (Pessoa) aDao.selectByEntity(aluno.getClass(), aluno);
		
		assertNull(selectedAluno);
		/*assertNotSame(aluno, selectedAluno);
		assertEquals(aluno, selectedAluno);*/
	}
	
}