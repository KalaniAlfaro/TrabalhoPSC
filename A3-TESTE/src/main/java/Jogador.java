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
        this.danoDuplo = true;
        this.ouro = 0;
    }
  }

  public void ajustarExperiencia(int quantidade) {
    this.experiencia += quantidade;
    if (this.experiencia >= 10) {
        this.experiencia = 0;
        this.vida -= 10;
    }
  }
}