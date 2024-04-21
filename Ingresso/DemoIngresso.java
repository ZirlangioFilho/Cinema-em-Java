import java.util.Scanner;

public class DemoIngresso {
    public static void main(String[] args) {
        Ingresso ingresso = new Ingresso("", "", "", "", "", 0);

        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Ingresso");
            System.out.println("2. Editar Preco");
            System.out.println("3. Excluir Ingresso");
            System.out.println("4. Listar Ingresso");
            System.out.println("5. Visualizar Ingresso");
            System.out.println("0. Sair");

            int escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    ingresso.criarIngresso();
                    break;
                case 2:
                    ingresso.editarPreco();
                    break;
                case 3:
                    ingresso.excluirIngresso();
                    break;
                case 4:
                    ingresso.listarIngresso();
                    break;
                case 5:
                    ingresso.vizualizarIngresso();
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scan.close();
        System.out.println("Programa encerrado.");
    }
}
