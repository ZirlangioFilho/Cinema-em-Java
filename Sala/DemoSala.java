import java.util.Scanner;

public class DemoSala {
    public static void main(String[] args) {
        Sala sala = new Sala(1, 1, 1);

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Sala");
            System.out.println("2. Editar Sala");
            System.out.println("3. Excluir Sala");
            System.out.println("4. Listar Salas");
            System.out.println("5. Visualizar Sala");
            System.out.println("0. Sair");

            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    criarSala();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;

                case 0:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        sc.close();
        System.out.println("Programa encerrado.");
    }
}
