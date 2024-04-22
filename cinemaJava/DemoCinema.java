package cinema;
import java.util.Scanner;

public class DemoCinema {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("", "", "",
                "", "", true);
        Ingresso ingresso = new Ingresso("", "", "", "", "", 0);
        Sala sala = new Sala(1, 1, 1);

        System.out.println("Bem vindo ao Cinema\n\n Digite a opção do que quer fazer: ");
        Scanner respostaCliente = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Ingresso");
            System.out.println("3 - Sala");
            System.out.println("4 - Filme");
            System.out.println("5- Sessao ");
            System.out.println("6. Sair");

         opcao = respostaCliente.nextInt();

         if(opcao == 1){
            Scanner scan = new Scanner(System.in);
    
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

         }else if (opcao == 2){
            Scanner sc = new Scanner(System.in);
            boolean continuar = true;
    
            while (continuar) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Criar Ingresso");
                System.out.println("2. Editar Preco");
                System.out.println("3. Excluir Ingresso");
                System.out.println("4. Listar Ingresso");
                System.out.println("5. Visualizar Ingresso");
                System.out.println("0. Sair");
    
                int escolha = sc.nextInt();
                sc.nextLine();
    
                switch (escolha) {
                    case 1:
                        ingresso.criarIngresso(sc);
                        break;
                    case 2:
                        ingresso.editarPreco(sc);
                        break;
                    case 3:
                        ingresso.excluirIngresso(sc);
                        break;
                    case 4:
                        ingresso.listarIngresso(sc);
                        break;
                    case 5:
                        ingresso.vizualizarIngresso(sc);
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
        
        } else if(opcao == 2){
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
                    sala.criarSala(sc);
                    break;
                case 2:
                    sala.editarSala(sc);
                    break;
                case 3:
                    sala.excluirSala(sc);
                    break;
                case 4:
                    sala.listarSala(sc);
                    break;
                case 5:
                    sala.visualizarSala();
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
        } else if( opcao == 3){

        }



        }while(opcao != 9);
        
       
        
        respostaCliente.close();
    }
}
