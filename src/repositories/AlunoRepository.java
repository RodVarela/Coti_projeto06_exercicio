package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import factories.ConnectionFactory;
import interfaces.IAlunoRepository;

public class AlunoRepository implements IAlunoRepository{

	@Override
	public void create(Aluno aluno) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("insert into aluno(nome, matricula, cpf) values(?, ?, ?)");
		statement.setString(1, aluno.getNome());
		statement.setString(2, aluno.getMatricula());
		statement.setString(3, aluno.getCpf());
		statement.execute();		
		
		connection.close();
	}

	@Override
	public void update(Aluno aluno) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("update aluno set nome = ?, matricula = ?, cpf = ? where idaluno = ?");
		statement.setString(1, aluno.getNome());
		statement.setString(2, aluno.getMatricula());
		statement.setString(3, aluno.getCpf());
		statement.setInt(4, aluno.getIdAluno());
		statement.execute();
		
		connection.close();
	}

	@Override
	public void delete(Aluno aluno) throws Exception {

		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("delete from aluno where idaluno = ?");
		statement.setInt(1, aluno.getIdAluno());
		statement.execute();
		
		connection.close();
	}

	@Override
	public List<Aluno> findAll() throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select * from aluno");
		ResultSet resultSet = statement.executeQuery();
		
		List<Aluno> lista = new ArrayList<Aluno>();
		
		while(resultSet.next()) {
			
			Aluno aluno = new Aluno(resultSet.getInt("idaluno"), resultSet.getString("nome"), resultSet.getString("matricula"), resultSet.getString("cpf"));
			lista.add(aluno);
			
		}
		
		connection.close();
		return lista;
	}

	@Override
	public Aluno findById(Integer idAluno) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select * from aluno where idaluno = ?");
		statement.setInt(1, idAluno);
		ResultSet resultSet = statement.executeQuery();
		
		Aluno aluno = null;
		
		if(resultSet.next()) {
			aluno = new Aluno(resultSet.getInt("idaluno"), resultSet.getString("nome"), resultSet.getString("matricula"), resultSet.getString("cpf"));
		}
				
		connection.close();
		return aluno;
	}

}
