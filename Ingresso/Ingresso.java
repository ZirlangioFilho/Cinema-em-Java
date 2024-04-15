import java.util.ArrayList;

public class Ingresso {
    private String nome;
    private String data;
    private String hora;
    private String filme;
    private String tipoIngresso;
    private float precoIngresso;
    
    ArrayList<String> list = new ArrayList<>();

    // Integer[] list = {3,4,5};
    
  
    public Ingresso(String nome, String data, String hora, String filme, String tipoIngresso, float precoIngresso) {
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
                       "| CLiente:  " +   nome
                         + "\n---------------------------------------|\n"
                      + "| Tipo de Ingreso:  " +   tipoIngresso
                         + "\n---------------------------------------|\n"
                     + "| Data e Hora:  " + data + "  |   " + hora + "\n\n");
    }
 
    public void listarIngresso(){
        for(int i = 1 ; i <= list.length; i++){
            System.out.println("\n\n| Filme:  " + filme         
            + "\n---------------------------------------|\n" +
          "| CLiente:  " +   nome
            + "\n---------------------------------------|\n"
         + "| Tipo de Ingreso:  " +   tipoIngresso
            + "\n---------------------------------------|\n"
        + "| Data e Hora:  " + data + "  |   " + hora + "\n\n");
        }
    }
  
  }
  