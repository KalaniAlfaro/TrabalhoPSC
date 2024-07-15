import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Salvamento {

   private Terminal[][] tab;
  private int num_colunas;
   private int num_linhas;

   public static void main(String[] args) {
       Salvamento leitor = new Salvamento();
      try {
          leitor.carrega("tab.txt");
       } catch (Exception e) {
          e.printStackTrace();
      }
  }

   public void carrega(String nomeArquivo) throws Exception {

       try {
           File arquivo = new File(nomeArquivo);
           Scanner leitor = new Scanner(arquivo);
           Estado estado = Estado.LENDO_NUM_COLUNAS;
           int contador_linhas = 0;
            // lê todas as linhas do arquivo
           while (leitor.hasNextLine()) {
               String linha = leitor.nextLine();
                // filtra linhas em branco e linhas de comentário
               if (linha.trim().length() > 0 && !linha.startsWith("#")) {

                   switch (estado) {
                     case LENDO_NUM_COLUNAS :
                           System.out.println("Lendo número de colunas...");
                           num_colunas = Integer.parseInt(linha);
                            break;

                     case LENDO_NUM_LINHAS  :
                          System.out.println("Lendo número de linhas...");
                            num_linhas = Integer.parseInt(linha);
                            this.tab = new Terminal[num_colunas][num_linhas];
                            estado = Estado.LENDO_NUM_LINHAS;
                            break;

                       case LENDO_TABULEIRO:
                           System.out.println("Lendo tabuleiro...");
                            String[] temp = linha.split(" ");
                            for (int i = 0; i < num_colunas; i++) {
                                char c = temp[i].charAt(0);
                                tab[i][contador_linhas] = new Terminal(c);
                                estado = Estado.LENDO_TABULEIRO;
                            }
                            contador_linhas++;
                            break;
                      default:
                          throw new Exception("Estado inválido.");
                    }
                }
            }

            leitor.close();
            System.out.printf("num_linhas=%d num_colunas=%d\n",
                    num_linhas, num_colunas);
            imprimir();
        } catch (NullPointerException e) {
            System.out.println("Não foi possível carregar o arquivo.");
        } catch (FileNotFoundException e) {
            System.out.println("O arquivo solicitado não existe.");
        }
    }

  public void imprimir() {
    for (int i = 0; i < tab.length; i++) {
      for (int j = 0; j < tab.length; j++) {
        System.out.print(this.tab[i][j].getBase() + " ");
      }
      System.out.println();
    }
  }

}
