import java.util.ArrayList;
import java.util.Scanner;

public class Ingresso {
    
    private String nome;
    private String data;
    private String hora;
    private String filme;
    private String tipoIngresso;
    private double precoIngresso;
    
   
  
    public Ingresso(String nome, String data, String hora, String filme, String tipoIngresso, double precoIngresso) {
      this.nome = nome;
      this.data = data;
      this.hora = hora;
      this.filme = filme;
      this.tipoIngresso = tipoIngresso;
      this.precoIngresso = precoIngresso;
    }
  
    public void vizualizarIngresso() {
    System.out.println("\n\n| Filme:  " + filme         
                         + "\n---------------------------------------|\n" +
                       "| Cliente:  " +   nome
                         + "\n---------------------------------------|\n"
                      + "| Tipo de Ingreso:  " +   tipoIngresso
                         + "\n---------------------------------------|\n"
                     + "| Data e Hora:  " + data + "  |   " + hora + "\n\n");
    }
 
    public void listarIngresso(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("ingresso");
        lista.add("ingresso");
        for(int i = 1 ; i <= lista.size(); i++){
          System.out.println("\n\n---------------------------------------|\n" +"| Filme:  " + filme         
          + "\n---------------------------------------|\n" +
        "| Cliente:  " +   nome
          + "\n---------------------------------------|\n"
       + "| Tipo de Ingreso:  " +   tipoIngresso
          + "\n---------------------------------------|\n"
      + "| Data e Hora:  " + data + "  |   " + hora
        + "\n---------------------------------------|\n" +
      "| Preco do ingresso: " + precoIngresso 
       + "\n---------------------------------------|\n");
    }
  }

    public void excluirIngresso(){
        System.out.println("Ingresso excluido com sucesso");
    }
  
    public void criarIngresso(){

    }

    public void editarPreco(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o novo valor do ingresso");
        precoIngresso = sc.nextDouble();
        System.out.println("novo valor é: " + precoIngresso);
        sc.close();
    }


  }
  