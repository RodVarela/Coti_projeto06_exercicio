package helpers;

import javax.swing.JOptionPane;

public class AlunoHelper {

	public static Integer lerIdAluno() throws Exception {
		
		String value = JOptionPane.showInputDialog("Informe o ID do aluno! ");
		return Integer.parseInt(value);
	}
	
	public static String lerNome() throws Exception {
		
		return JOptionPane.showInputDialog("Informe o Nome do aluno! ");
	}
	
	public static String lerMatricula() throws Exception {
		
		return JOptionPane.showInputDialog("Informe a Matrícula do aluno! ");
	}
	
	public static String lerCpf() throws Exception {
		
		return JOptionPane.showInputDialog("Informe o CPF do aluno! ");
	}
	
}
