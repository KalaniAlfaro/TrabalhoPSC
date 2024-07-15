import java.util.Random;

public class Tabuleiro {
  private final int TAMANHO = 8;
  private Random random;
  private int[][] tab;
  private Terminal[][] tabVisual;
  int numComb = 0;

  private static final int CAVEIRA = 0;
  private static final int VERMELHA = 1;
  private static final int AZUL = 2;
  private static final int VERDE = 3;
  private static final int AMARELA = 4;
  private static final int OURO = 5;
  private static final int EXPERIENCIA = 6;

  // PREENCHE O TABULEIRO COM GEMAS ALEATORIAS
  public void reset() {
    for (int i = 0; i < TAMANHO; i++) {
      for (int j = 0; j < TAMANHO; j++) {
        this.tab[i][j] = Math.abs(random.nextInt() % 7);
        this.tabVisual[i][j] = new Terminal(this.tab[i][j]);
      }
    }
  }

  // CONSTROI O TABULEIRO
  public Tabuleiro() {
    this.tab = new int[TAMANHO][TAMANHO];
    this.tabVisual = new Terminal[TAMANHO][TAMANHO];
    this.random = new Random();
    verificaJogadas();
    while (derruba())
      reset();

  }

  public boolean derruba() {
    if (derruba5()) {
      substituirGemas();
      this.numComb = 5;
      return true;
    } else if (derruba4()) {
      substituirGemas();
      this.numComb = 4;
      return true;
    } else if (derruba3()) {
      substituirGemas();
      this.numComb = 3;
      return true;
    } else {
      return false;
    }
  }

  public boolean verificaJogadas() {
    // identificar trios de valores na horizontal
    for (int i = 0; i < TAMANHO; i++) {
      for (int j = 0; j < TAMANHO - 3; j++) {
        int gema1 = (tab[i][j]);
        int gema2 = tab[i][j + 1];
        int gema3 = tab[i][j + 3];
        if (gema1 == gema2 && gema2 == gema3 && gema1 != 8) {
          reset();
          while (derruba())
            reset();
          return true;
        }
      }
    }
    for (int j = 0; j < TAMANHO; j++) {
      for (int i = 0; i < TAMANHO - 3; i++) {
        int gema1 = tab[i][j];
        int gema2 = tab[i + 1][j];
        int gema3 = tab[i + 3][j];
        if (gema1 == gema2 && gema2 == gema3 && gema1 != 8) {
          reset();
          while (derruba())
            reset();
          return true;
        }
      }
    }
    return false;
  }

  public boolean derruba3() {
    for (int i = 0; i < TAMANHO; i++) {
      for (int j = 0; j < TAMANHO - 2; j++) {
        int gema1 = tab[i][j];
        int gema2 = tab[i][j + 1];
        int gema3 = tab[i][j + 2];
        if (gema1 == gema2 && gema2 == gema3 && gema1 != 8) {
          tab[i][j] = 8;
          tab[i][j + 1] = 8;
          tab[i][j + 2] = 8;
          return true;
        }
      }
    }
    for (int j = 0; j < TAMANHO; j++) {
      for (int i = 0; i < TAMANHO - 2; i++) {
        int gema1 = tab[i][j];
        int gema2 = tab[i + 1][j];
        int gema3 = tab[i + 2][j];
        if (gema1 == gema2 && gema2 == gema3 && gema1 != 8) {
          tab[i][j] = 8;
          tab[i + 1][j] = 8;
          tab[i + 2][j] = 8;
          return true;
        }
      }
    }
    return false;
  }

  public boolean derruba4() {
    for (int i = 0; i < TAMANHO; i++) {
      for (int j = 0; j < TAMANHO - 3; j++) {
        int gema1 = tab[i][j];
        int gema2 = tab[i][j + 1];
        int gema3 = tab[i][j + 2];
        int gema4 = tab[i][j + 3];
        if (gema1 == gema2 && gema2 == gema3 && gema3 == gema4 && gema1 != 8) {
          tab[i][j] = 8;
          tab[i][j + 1] = 8;
          tab[i][j + 2] = 8;
          tab[i][j + 3] = 8;
          return true;
        }
      }
    }
    for (int j = 0; j < TAMANHO; j++) {
      for (int i = 0; i < TAMANHO - 3; i++) {
        int gema1 = tab[i][j];
        int gema2 = tab[i + 1][j];
        int gema3 = tab[i + 2][j];
        int gema4 = tab[i + 3][j];
        if (gema1 == gema2 && gema2 == gema3 && gema3 == gema4 && gema1 != 8) {
          tab[i][j] = 8;
          tab[i + 1][j] = 8;
          tab[i + 2][j] = 8;
          tab[i + 3][j] = 8;
          return true;
        }
      }
    }
    return false;
  }

  public boolean derruba5() {
    for (int i = 0; i < TAMANHO; i++) {
      for (int j = 0; j < TAMANHO - 4; j++) {
        int gema1 = tab[i][j];
        int gema2 = tab[i][j + 1];
        int gema3 = tab[i][j + 2];
        int gema4 = tab[i][j + 3];
        int gema5 = tab[i][j + 4];
        if (gema1 == gema2 && gema2 == gema3 && gema3 == gema4 && gema4 == gema5 && gema1 != 8) {
          tab[i][j] = 8;
          tab[i][j + 1] = 8;
          tab[i][j + 2] = 8;
          tab[i][j + 3] = 8;
          tab[i][j + 4] = 8;
          return true;
        }
      }
    }
    for (int j = 0; j < TAMANHO; j++) {
      for (int i = 0; i < TAMANHO - 4; i++) {
        int gema1 = tab[i][j];
        int gema2 = tab[i + 1][j];
        int gema3 = tab[i + 2][j];
        int gema4 = tab[i + 3][j];
        int gema5 = tab[i + 4][j];
        if (gema1 == gema2 && gema2 == gema3 && gema3 == gema4 && gema4 == gema5 && gema1 != 8) {
          tab[i][j] = 8;
          tab[i + 1][j] = 8;
          tab[i + 2][j] = 8;
          tab[i + 3][j] = 8;
          tab[i + 4][j] = 8;
          return true;
        }
      }
    }
    return false;
  }

  public void substituirGemas() {
    for (int j = 0; j < TAMANHO; j++) {
      for (int i = TAMANHO - 1; i >= 0; i--) {
        if (tab[i][j] == 8) {
          // Move todas as gemas acima para baixo
          for (int k = i; k > 0; k--) {
            tab[k][j] = tab[k - 1][j];
          }
          // Gera uma nova gema no topo
          tab[0][j] = Math.abs(random.nextInt() % 7);
        }
      }
    }
  }

  // VERIFICA SE A JOGADO ESTA DENTRO DO TABULEIRO <8 e >0
  public boolean jogadaValida(int x, int y, int ox, int oy) {
    return (x >= 0 && x < TAMANHO && y >= 0 && y < TAMANHO &&
        ox >= 0 && ox < TAMANHO && oy >= 0 && oy < TAMANHO);
  }

  // TROCA AS GEMAS DE LUGAR
  public void trocar(int x, int y, int ox, int oy, Jogador jogadorAtual, Jogador adversario) {

    int gema = tab[x][y];

    if (!jogadaValida(x, y, ox, oy)) {
      System.out.println("Jogada inválida. Tente novamente.");
      return;
    } else {
      aplicarEfeitoGema(gema, jogadorAtual, adversario);
    }

    System.out.printf("Trocando gemas (%d, %d) [%d] com (%d, %d) [%d]%n",
        x, y, tab[x][y],
        ox, oy, tab[ox][oy]);

    int aux = this.tab[x][y];
    this.tab[x][y] = this.tab[ox][oy];
    this.tab[ox][oy] = aux;

    if (!derruba()) {
      System.out.println("Jogada inválida. Tente novamente.");
      aux = this.tab[x][y];
      this.tab[x][y] = this.tab[ox][oy];
      this.tab[ox][oy] = aux;
    }

    while (derruba())
      derruba();

  }

  public void aplicarEfeitoGema(int num, Jogador jogadorAtual, Jogador adversario) {
    int gema = num;
    switch (gema) {
      case CAVEIRA:
        int dano = this.numComb;
        dano = jogadorAtual.danoDuplo ? (this.numComb * 2) : (this.numComb);
        adversario.ajustarVida(-dano);
        jogadorAtual.danoDuplo = false;
        System.out.println("Jogador " + jogadorAtual.nome + " causou " + dano);
        break;
      case VERMELHA:
        jogadorAtual.ajustarVida(this.numComb);
        System.out.println("Ganhou vida!");
        break;
      case AZUL:
        transformarEsferas(VERMELHA, CAVEIRA);
        System.out.println(" VERMELHAS VIRAM CAVEIRAS!");
        break;
      case VERDE:
        transformarEsferas(CAVEIRA, VERMELHA);
        System.out.println(" CAVEIRAS VIRAM VERMELHAS!");
        break;
      case AMARELA:
        adversario.ajustarOuro(-adversario.ouro);
        System.out.println(adversario.nome + " PERDEU OURO!");
        break;
      case OURO:
        jogadorAtual.ajustarOuro(1);
        System.out.println(jogadorAtual.nome + " GANHOU OURO!");
        break;
      case EXPERIENCIA:
        jogadorAtual.ajustarExperiencia(1);
        System.out.println(jogadorAtual.nome + " GANHOU EXPERIENCIA!");
        break;
    }
  }

  public void transformarEsferas(int de, int para) {
    for (int i = 0; i < TAMANHO; i++) {
      for (int j = 0; j < TAMANHO; j++) {
        if (tab[i][j] == de) {
          tab[i][j] = para;
        }
      }
    }
  }

  public void TurnoExtra(Jogador jogadorAtual) {
    if (derruba4()) {
      System.out.println(jogadorAtual.nome + " ganhou um turno extra!");
      jogadorAtual.ganhouTurnoExtra = true;
      return;
    }
  }

  // imprime o tabuleiro
  public void imprimir() {
    for (int i = 0; i < TAMANHO; i++) {
      for (int j = 0; j < TAMANHO; j++) {
        System.out.print(this.tabVisual[i][j].getBase() + " ");
      }
      System.out.println();
    }
  }

  public int getTAMANHO() {
    return TAMANHO;
  }

  public Random getRandom() {
    return random;
  }

  public void setRandom(Random random) {
    this.random = random;
  }

  public int[][] getTab() {
    return tab;
  }

  public void setTab(int[][] tab) {
    this.tab = tab;
  }

  public Terminal[][] getTabVisual() {
    return tabVisual;
  }

  public void setTabVisual(Terminal[][] tabVisual) {
    this.tabVisual = tabVisual;
  }

  public int getNumComb() {
    return numComb;
  }

  public void setNumComb(int numComb) {
    this.numComb = numComb;
  }

}