package principal;

import java.util.Scanner;

import controllers.AlunoController;

public class Program {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean running = true;
		
		while (running) {
			System.out.println("\n *** SISTEMA DE GERENCIAMENTO DE ALUNOS ***\n");
			System.out.println("(1) Cadastrar");
			System.out.println("(2) Atualizar");
			System.out.println("(3) Deletar");
			System.out.println("(4) Consultar Registro Geral");
			System.out.println("(5) Consultar Aluno");
			System.out.println("(0) Sair");
			Integer opcao = Integer.parseInt(scanner.nextLine());
			AlunoController alunoController = new AlunoController();
			switch (opcao) {
			case 1:
				alunoController.cadastrar();
				break;
			case 2:
				alunoController.atualizar();
				break;
			case 3:
				alunoController.deletar();
				break;
			case 4:
				alunoController.consultar();
				break;
			case 5:
				alunoController.consultarAlunoPorId();
				break;
			case 0:
				running = false;
				System.out.println("Sistema encerrado! Obrigado!");
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		}
		
		scanner.close();
	}
}
