package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	
	double salarioBase = 2000.0;
	String [] candidatos = {"FELIPE", "MARCIA", "ANA", "PEDRO", "JOAO", "AUGUSTO", "JULIA", "JORGE"};
	
	
	public void AnalisarCandidato(double salarioPretendido) {
		if(salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato");
		}
		else if(salarioBase == salarioPretendido) {
			System.out.println("Ligar para o candidato com contra proposta.");
		}
		else {
			System.out.println("Aguardando resultado demais candidatos.");
		}
	}
	
	public double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	public void selecaoCandidatos() {
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("o candidato: " + candidato + " pretende um salário de R$ " + salarioPretendido);
			
			if(salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " FOI selecionado para a vaga.");
				candidatosSelecionados++;
			} else {
				System.out.println("O candidato " + candidato + " NÃO FOI selecionado para a vaga.");
			}
			candidatoAtual++;
		}
	}
	
	public void imprimirSelecionados () {
		System.out.println("Lista de candidatos selecionados pelo índice:");	
		
		for(int i = 0; i < candidatos.length; i++) {
			System.out.println("O candidato de nº " + (i + 1) + " é " + candidatos[i]);
		}
	}
	
	static public boolean atender() {
		return new Random().nextInt(3) == 1;
	}
	
	
	public void LigandoCandidato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando) {
				tentativasRealizadas++;
			}else {
				System.out.println("Contato realizado com sucesso!");
			}
		}while(continuarTentando && tentativasRealizadas < 3);
		
		if(atendeu) {
			System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + "ª tentativa.");
		} else {
			System.out.println("Não conseguimos contato com " + candidato + ", número máximo tentativas " + tentativasRealizadas + " realizada.");
		}
	}
	
	public void imprimirResultadoLigações() {
		for(String candidato : candidatos) {
			LigandoCandidato(candidato);
		}
	}
	
}
