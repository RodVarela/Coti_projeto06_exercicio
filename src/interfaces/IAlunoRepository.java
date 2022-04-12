package interfaces;

import java.util.List;

import entities.Aluno;

public interface IAlunoRepository {

	void create(Aluno aluno) throws Exception;
	
	void update(Aluno aluno) throws Exception;
	
	void delete(Aluno aluno) throws Exception;
	
	List<Aluno> findAll() throws Exception;
	
	Aluno findById(Integer idAluno) throws Exception;
	
}
