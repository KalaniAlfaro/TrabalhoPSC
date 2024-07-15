import java.util.Scanner;
import java.io.File;

public class Partida {
  Jogador jogador1, jogador2;
  Tabuleiro tabuleiro;
  Jogador jogadorAtual;
  Jogador adversario;
  Scanner scanner;

  public Partida() {

    jogador1 = new Jogador("Jogador 1");
    jogador2 = new Jogador("Jogador 2");
    tabuleiro = new Tabuleiro();
    jogadorAtual = jogador1;
    adversario = jogador2;
    scanner = new Scanner(System.in);

  }

  public void jogar() {

    while (jogador1.vida > 0 && jogador2.vida > 0) {

      exibirInfoJogadores();

      tabuleiro.imprimir();

      System.out.println("Turno do " + jogadorAtual.nome);

      System.out.print("X: ");
      int x = Integer.valueOf(scanner.nextLine());

      System.out.print("Y: ");
      int y = Integer.valueOf(scanner.nextLine());

      System.out.print("Direção (0=cima, 1=esquerda, 2=baixo, 3=direita): ");
      int dir = Integer.valueOf(scanner.nextLine());

      int ox, oy;

      switch (dir) {
        case 0: // cima
          ox = x - 1;
          oy = y;
          break;
        case 1: // esquerda
          ox = x;
          oy = y - 1;
          break;
        case 2: // baixo
          ox = x + 1;
          oy = y;
          break;
        case 3: // direita
          ox = x;
          oy = y + 1;
          break;
        default:
          System.out.println("Direção inválida. Tente novamente.");
          System.out.println();
          continue;
      }

      if (!tabuleiro.jogadaValida(x, y, ox, oy)){
        alternarTurno();
      }


      tabuleiro.trocar(x, y, ox, oy, jogadorAtual, jogadorAtual == jogador1 ? jogador2 : jogador1);


      if (!jogadorAtual.ganhouTurnoExtra) {
        alternarTurno();
      } else {
        jogadorAtual.ganhouTurnoExtra = false;
      }


      if (jogador1.vida <= 0) {
        System.out.println("Jogador 2 venceu!");
      } else if (jogador2.vida <= 0) {
        System.out.println("Jogador 1 venceu!");
      }

    }
  }

  public void exibirInfoJogadores() {
      System.out.println();
      System.out.println("Informações dos Jogadores:");
      System.out.println();
      System.out.println("Jogador 1:");
      System.out.println("Vida: " + jogador1.vida);
      System.out.println("Ouro: " + jogador1.ouro);
      System.out.println("Experiência: " + jogador1.experiencia);
      System.out.println();
      System.out.println("Jogador 2:");
      System.out.println("Vida: " + jogador2.vida);
      System.out.println("Ouro: " + jogador2.ouro);
      System.out.println("Experiência: " + jogador2.experiencia);
      System.out.println();
  }
  public void alternarTurno() {
      jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
      adversario = (jogadorAtual == jogador1) ? jogador2 : jogador1;
  }
}