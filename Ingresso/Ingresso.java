import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        "| Cliente:  " + nome
        + "\n---------------------------------------|\n"
        + "| Tipo de Ingreso:  " + tipoIngresso
        + "\n---------------------------------------|\n"
        + "| Data e Hora:  " + data + "  |   " + hora + "\n\n");
  }

  public void listarIngresso() {
    ArrayList<String> lista = new ArrayList<>();
    String arquivoIng = "ingresso.txt";

    try (FileReader arquivo = new FileReader(arquivoIng);
        BufferedReader leitor = new BufferedReader(arquivo)) {
      String linha;
      while ((linha = leitor.readLine()) != null) {
        lista.add(linha);
      }
    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());
      return;
    }

    for (String item : lista) {
      String[] campos = item.split(",");

      if (campos.length >= 6) {
        String filme = campos[0];
        String cliente = campos[1];
        String tipoIngresso = campos[2];
        String data = campos[3];
        String hora = campos[4];
        double precoIngresso = Double.parseDouble(campos[5]);

        System.out.println(
            "\n\n---------------------------------------|\n" +
                "| Filme:  " + filme +
                "\n---------------------------------------|\n" +
                "| Cliente:  " + cliente +
                "\n---------------------------------------|\n" +
                "| Tipo de Ingresso:  " + tipoIngresso +
                "\n---------------------------------------|\n" +
                "| Data e Hora: " + data + "  |   " + hora +
                "\n---------------------------------------|\n" +
                "| Preço do Ingresso: " + precoIngresso +
                "\n---------------------------------------|\n");
      } else {
        System.out.println("Linha incompleta: " + item);
      }
    }
  }

  public void excluirIngresso() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o nome do Cliente do Ingresso que deseja excluir: ");
    String idStr = sc.nextLine();

    ArrayList<String> ingressos = new ArrayList<>();
    boolean encontrado = false;

    try {
      FileReader arquivo = new FileReader("ingressos.txt");
      Scanner leitor = new Scanner(arquivo);

      while (leitor.hasNextLine()) {
        String linha = leitor.nextLine();
        String[] campos = linha.split(",");

        if (campos.length >= 6 && campos[2].equals(idStr)) {
          encontrado = true;
        } else {
          ingressos.add(linha);
        }
      }
      leitor.close();
      sc.close();

      if (!encontrado) {
        System.out.println("Nome " + idStr + " não encontrado");
      } else {
        try (FileWriter ingressoNovo = new FileWriter("ingressos.txt", false);
            BufferedWriter escritor = new BufferedWriter(ingressoNovo)) {
          for (String linha : ingressos) {
            escritor.write(linha);
            escritor.newLine();
          }
          System.out.println("O Ingresso de " + idStr + " foi excluído");
        } catch (IOException e) {
          System.out.println("Erro ao excluir: ");
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado: ");
    }
  }

  public void criarIngresso() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o nome do filme:");
    filme = sc.nextLine();

    System.out.println("Digite o nome do cliente:");
    nome = sc.nextLine();

    System.out.println("Digite o tipo de ingresso:");
    tipoIngresso = sc.nextLine();

    System.out.println("Digite a data do ingresso (ex: 19/04/2024):");
    data = sc.nextLine();

    System.out.println("Digite a hora do ingresso (ex: 21:44):");
    hora = sc.nextLine();

    try {
      System.out.println("Digite o preço do ingresso:");
      precoIngresso = sc.nextDouble();
    } catch (InputMismatchException e) {
      System.out.println("Por favor, insira um número para o preço.");
    }

    String separa = ",";
    String ingressos = (filme + separa + nome + separa + tipoIngresso + separa
        + data + separa + hora + separa + precoIngresso);

    try (FileWriter arquivo = new FileWriter("ingressos.txt", true);
        BufferedWriter escreve = new BufferedWriter(arquivo)) {
      escreve.write(ingressos);
      escreve.newLine();
      System.out.println("Novo ingresso criado com sucesso.");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Arquivo nao encontrado");
    }
    sc.close();
  }

  public void editarPreco() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o nome do dono do Ingresso que deseja editar: ");
    String idStr = sc.nextLine();

    ArrayList<String> ingressos = new ArrayList<>();
    boolean encontrado = false;

    try {
      FileReader arquivo = new FileReader("ingressos.txt");
      Scanner leitor = new Scanner(arquivo);

      while (leitor.hasNextLine()) {
        String linha = leitor.nextLine();
        String[] campos = linha.split(",");

        if (campos.length >= 6 && campos[1].equals(idStr)) {
          encontrado = true;
          System.out.println("1. Filme, 2. Nome, 3. Tipo de Ingresso, 4. Data, 5. Hora, 6. Preco, 0. Sair");
          System.out.println("O que deseja editar do perfil?");
          int escolha = sc.nextInt();
          sc.nextLine();

          switch (escolha) {
            case 1:
              System.out.println("Qual é o Filme?");
              campos[0] = sc.nextLine();
              break;
            case 2:
              System.out.println("Qual o novo nome?");
              campos[1] = sc.nextLine();
              break;
            case 3:
              System.out.println("Qual é o Tipo de Ingresso?");
              campos[2] = sc.nextLine();
              break;
            case 4:
              System.out.println("Qual a data?");
              campos[3] = sc.nextLine();
              break;
            case 5:
              System.out.println("Qual a hora?");
              campos[4] = sc.nextLine();
              break;
            case 6:
              System.out.println("Qual o Preco?");
              campos[5] = sc.nextLine();
              break;
            case 0:
              break;
            default:
              System.out.println("Opção inválida");
              break;
          }

          linha = String.join(",", campos); // Recriar a linha com os valores atualizados
        }
        ingressos.add(linha); // Adicionar a linha (original ou modificada)
      }
      leitor.close();

      if (!encontrado) {
        System.out.println("Nome " + idStr + " não existe.");
      } else {
        // Reescreve o arquivo com as mudanças
        try (FileWriter arquivoNovo = new FileWriter("ingressos.txt", false); // 'false' para sobrescrever
            BufferedWriter escritor = new BufferedWriter(arquivoNovo)) {
          for (String linha : ingressos) {
            escritor.write(linha); // Gravar cada linha no arquivo
            escritor.newLine();
          }
        } catch (IOException e) {
          System.out.println("Erro ao fazer mudanca ");
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado: ");
    }
    sc.close();
  }
}
