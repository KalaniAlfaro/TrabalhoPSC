public class Jogador {
  String nome;
  int vida;
  int ouro;
  int experiencia;
  boolean danoDuplo;
  boolean ganhouTurnoExtra;

  Jogador(String nome) {
      this.nome = nome;
      this.vida = 100;
      this.ouro = 0;
      this.experiencia = 0;
      this.danoDuplo = false;
      this.ganhouTurnoExtra = false;
  }

  public void ajustarVida(int quantidade) {
    this.vida += quantidade;
  }
  
  public void ajustarOuro(int quantidade) {
    this.ouro += quantidade;
    if (this.ouro >= 10) {
      System.out.println("Próximo ataque com poder dobrado!!");
        this.danoDuplo = true;
        this.ouro = 0;
    }
  }

  public void ajustarExperiencia(int quantidade, Jogador adversario) {
    this.experiencia += quantidade;
    if (this.experiencia >= 10) {
      System.out.println("SUBIU DE NÍVEL!!");
        this.experiencia = 0;
        adversario.vida -= 10;
    }
  }
}