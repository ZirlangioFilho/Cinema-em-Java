package cinema;
import java.util.ArrayList;
import java.util.Scanner;

public class Filmes {
    private String titulo;
    private String duracao;
    private int anoLancamento;
    private int classificacao;


    public Filmes(String titulo, String duracao, int anoLancamento, int classificacao) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.classificacao = classificacao;
    }

public void criarFilme(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Informe o nome do filme: ");
    titulo = sc.nextLine();
    System.out.println("Informe a duracao do filme: ");
    duracao = sc.nextLine();
    System.out.println("Informe a classificacao do filme: ");
    classificacao = sc.nextInt();
    System.out.println("Informe o ano de lançamento do filme: ");
    anoLancamento = sc.nextInt();
    System.out.println("Filme cadastrado com sucesso!");
    sc.close();
}

public void vizualizarFilme(){
    ArrayList listaFilme = new ArrayList<>();
    System.out.println("Lista de filmes cadastrados\n\n");
    for(int i=0; i<=listaFilme.size(); i++){
    System.out.println("Titulo: " + titulo);
    System.out.println("Duracao: " + duracao);
    System.out.println("Classificacao: " + classificacao);
    System.out.println("Ano de lancamento: " + anoLancamento);
    }
}
}