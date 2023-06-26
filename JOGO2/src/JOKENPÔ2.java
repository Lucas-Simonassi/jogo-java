import java.util.Scanner;

import java.util.Scanner;

// JOGO

public class JOKENPÔ2 {

	// Placar

	private static int placarJogador = 0;
	private static int placarComputador = 0;
	private static int reiniciar = 1;

	// Escolhas
	// 1 = Pedra, 2 = Papel, 3 = Tesoura

	private static int escolhaJogador;
	private static int escolhaComputador;

	// Metodo Principal
	public static void main(String[] args) {
		// Quantidade de rodadas / jogadas
		int rodadas = 0;
		// Input de dados
		Scanner input = new Scanner(System.in);

		// Perguntar para o jogador a quantidade de rodadas
		System.out.println("::: JOKENPÔ :::");
		System.out.println("Insira a quantidade de rodadas: ");
		rodadas = input.nextInt();

		// while para reiniciar quando acabar as partidas!
		while (reiniciar == 1) {
			for (int i = 1; i <= rodadas; ++i) {
				rotuloEscolhaJogador();
				escolhaJogador = input.nextInt();
				escolhaComputador = (int) (Math.random() * 3) + 1;

				System.out.println("");
				verificaResultado();

				// adiciona +1 rodada caso haja empate.

				if (escolhaJogador == escolhaComputador){
					rodadas = rodadas + 1;
					System.out.println("Deu empate! Reiniciando a vez...");
					System.out.println("");
				}
			} // for
			exibePlacar();
			System.out.println("Deseja jogar novamente?");
			System.out.println("(1) SIM (0) NãO");
			reiniciar = input.nextInt();
		} // while

	} // main

	// Verifica condição de vitória e derrota
	private static void verificaResultado() {

		// comparativo caso haja empate.
		if (escolhaJogador == escolhaComputador) {
			System.out.println("Jogador jogou: " + escolhaJogador + "\n"
					           + "Computador jogou: " + escolhaComputador);
			System.out.println("EMPATE!!!");
			System.out.println("");
		} else {
			// comparativos de vitória do jogador
			if ((escolhaJogador == 1 && escolhaComputador == 3) || (escolhaJogador == 2 && escolhaComputador == 1)
					|| (escolhaJogador == 3 && escolhaComputador == 2)) {
				placarJogador = placarJogador + 1;
				System.out.println("Jogador jogou: " + escolhaJogador + "\n"
						+ "Computador jogou: " + escolhaComputador);
				System.out.println("Jogador venceu!!");
				System.out.println("");
				// caso não ocorra aqueles casos, a máquina vence;
			} else {
				placarComputador = placarComputador + 1;
				System.out.println("Jogador jogou: " + escolhaJogador + "\n"
						+ "Computador jogou: " + escolhaComputador);
				System.out.println("Computador Venceu!!");
				System.out.println("");
			}
		}

	}

	// Exibe o resultado do placar
	// placarJogador E placarComputador
	private static void exibePlacar() {

		if (placarJogador == placarComputador) {
			System.out.println(
					"Houve empate! \n" + "Jogador: " + placarJogador + "\n" + "Computador: " + placarComputador);
		} else {
			if (placarJogador > placarComputador) {
				System.out.println("O jogador ganhou! \n" + "Jogador: " + placarJogador + "\n" + "Computador: "
						+ placarComputador);
			} else {
				System.out.println("A máquina ganhou! \n" + "Jogador: " + placarJogador + "\n" + "Computador: "
						+ placarComputador);
			}

		}
	}

	// Menuzinho para digitar se é pedra, papel ou tesoura.
	private static void rotuloEscolhaJogador() {
		System.out.println("::: JOGADOR, DIGITE:");
		System.out.println("::: 1 - Pedra");
		System.out.println("::: 2 - Papel");
		System.out.println("::: 3 - Tesoura");
		System.out.println("::: Escolha sua opção: ");
	}
}
