package controllers;

import entities.Aluno;
import helpers.AlunoHelper;
import repositories.AlunoRepository;

public class AlunoController {

	//Cadastrar aluno
	public void cadastrar() {

		try {

			System.out.println("\n*** CADASTRO DE ALUNO ***\n");

			Aluno aluno = new Aluno();

			aluno.setNome(AlunoHelper.lerNome());
			aluno.setMatricula(AlunoHelper.lerMatricula());
			aluno.setCpf(AlunoHelper.lerCpf());

			AlunoRepository alunoRepository = new AlunoRepository();
			alunoRepository.create(aluno);

			System.out.println("\nAluno cadastrado com sucesso!");

		} catch (Exception e) {
			System.out.println("\nOcorreu um erro: " + e.getMessage());
		}
	}

	//Atualizar aluno
	public void atualizar() {

		try {

			System.out.println("\n*** ATUALIZAÇÃO DE ALUNO ***\n");

			Integer idAluno = AlunoHelper.lerIdAluno();

			// consultando o aluno no banco de dados atraves do id
			AlunoRepository alunoRepository = new AlunoRepository();
			Aluno aluno = alunoRepository.findById(idAluno);

			// verificando se o aluno foi encontrado
			if (aluno != null) {

				aluno.setNome(AlunoHelper.lerNome());
				aluno.setMatricula(AlunoHelper.lerMatricula());
				aluno.setCpf(AlunoHelper.lerCpf());

				alunoRepository.update(aluno);
				System.out.println("Aluno atualizado com sucesso!");
				
			} else {
				System.out.println("Aluno não encontrado!");
			}

		} catch (Exception e) {
			System.out.println("\nOcorreu um erro: " + e.getMessage());
		}
	}

	//Deletar aluno
	public void deletar() {

		try {

			System.out.println("\n*** EXCLUIR DE ALUNO ***\n");

			Integer idAluno = AlunoHelper.lerIdAluno();

			// consultando o aluno no banco de dados atraves do id
			AlunoRepository alunoRepository = new AlunoRepository();
			Aluno aluno = alunoRepository.findById(idAluno);

			// verificando se o aluno foi encontrado
			if (aluno != null) {

				alunoRepository.delete(aluno);
				System.out.println("Aluno excluído com sucesso!");

			} else {
				System.out.println("Aluno não encontrado!");
			}

		} catch (Exception e) {
			System.out.println("\nOcorreu um erro: " + e.getMessage());
		}
	}
	
	//Consultar todos os alunos cadastrados
	public void consultar() {
		
		try {
			
			System.out.println("\n*** REGISTRO GERAL DE ALUNOS ***\n");
			
			AlunoRepository alunoRepository = new AlunoRepository();
			
			System.out.println("=================================================================================");
			for (Aluno aluno : alunoRepository.findAll()) {
				System.out.println(aluno.toString());
			}
			System.out.println("=================================================================================");
						
			
		} catch (Exception e) {
			System.out.println("\nOcorreu um erro: " + e.getMessage());
		}
	}
	
	//Consultar aluno por Id
	public void consultarAlunoPorId() {
		
		try {
			
			System.out.println("\n*** CONSULTA DE ALUNO POR ID ***\n");
			
			Integer idAluno = AlunoHelper.lerIdAluno();
			
			AlunoRepository alunoRepository =new AlunoRepository();
			Aluno aluno = alunoRepository.findById(idAluno);
			
			System.out.println("=================================================================================");
			if(aluno != null) {
				System.out.println(aluno.toString());
				System.out.println("=================================================================================");
			}else {
				System.out.println("Aluno não encontrado!");
			}
			
		} catch (Exception e) {
			System.out.println("\nOcorreu um erro: " + e.getMessage());
		}
	}
		

}
