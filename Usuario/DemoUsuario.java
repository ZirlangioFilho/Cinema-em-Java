import java.util.Scanner;
import java.io.IOException;

public class DemoUsuario {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        Usuario usuario = new Usuario("", "", "",
                "", "", true);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Perfil");
            System.out.println("2. Editar Perfil");
            System.out.println("3. Excluir Perfil");
            System.out.println("4. Listar Perfis");
            System.out.println("5. Visualizar Perfil");
            System.out.println("0. Sair");

            int escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 1:
                    usuario.criarPerfil(scan);
                    System.out.println("Perfil criado com sucesso!");
                    break;
                case 2:
                    usuario.editarPerfil(scan);
                    break;

                case 3:
                    usuario.excluirPerfil(scan);
                    break;

                case 4:
                    usuario.listarPerfis();
                    break;

                case 5:
                    usuario.visualizarPerfil(scan);
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