import java.util.Scanner;

public class Usuario {
    private String nomeCliente;
    private String email;
    private String id;
    private String user;
    private String senha;
    private Boolean ehGerente;

    public Usuario(String nomeCliente, String email, String id, String user, String senha, Boolean ehGerente) {
        this.nomeCliente = nomeCliente;
        this.email = email;
        this.id = id;
        this.user = user;
        this.senha = senha;
        this.ehGerente = ehGerente;
    }

    public void criarPerfil() {
        System.out.println("\nCriacao do Perfil\n");
        System.out.println("Qual seu nome?\n");
        Scanner scan = new Scanner(System.in);
        nomeCliente = scan.nextLine();
        System.out.println("Qual seu email?\n");
        email = scan.nextLine();
        System.out.println("Qual seu user para acesso?\n");
        user = scan.nextLine();
        System.out.println("Qual a senha de acesso?\n");
        senha = scan.nextLine();
        System.out.println("Voce eh Gerente?\n 1. Sim | 0. Nao");
        ehGerente = scan.nextBoolean();
        System.out.println(ehGerente);

        scan.close();

        id = nomeCliente + user + senha;

        System.out.println("Criando Perfil\n");
    }

    public void editarPerfil() {
        int i;
        System.out.println("1. Nome, 2. Email, 3. ID, 4. User, 5. Senha");
        System.out.println("O que deseja editar do perfil?");
        Scanner scan = new Scanner(System.in);
        i = scan.nextInt();
        scan.close();

        if (i == 1) {
            System.out.println("Seu nome eh " + nomeCliente);
            Scanner sc = new Scanner(System.in);
            nomeCliente = sc.nextLine();
            System.out.println("Seu novo nome eh " + sc);
            sc.close();

        } else if (i == 2) {

        } else if (i == 3) {

        } else if (i == 4) {

        } else if (i == 5) {

        }

    }

    public void excluirPerfil() {

    }

    public void listarPerfis() {

    }

    public void visualizarPerfil() {
        System.out.println("Nome: " + nomeCliente);
        System.out.println("Email: " + email);
        System.out.println("id: " + id);
        System.out.println("user: " + user);
        System.out.println("senha: " + senha);
    }

}
