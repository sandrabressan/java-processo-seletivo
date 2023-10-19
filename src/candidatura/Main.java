package candidatura;

public class Main {

	public static void main(String[] args) {
		
		ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();
		
		processoSeletivo.AnalisarCandidato(1900.0);
		processoSeletivo.AnalisarCandidato(2000.0);
		processoSeletivo.AnalisarCandidato(2100.0);
		
		processoSeletivo.selecaoCandidatos();
		processoSeletivo.imprimirSelecionados();
		processoSeletivo.imprimirResultadoLigações();
		
	}

}
