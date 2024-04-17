import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;

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

    // criar Perfil
    public void criarPerfil(Scanner scan) throws IOException {
        System.out.println("\nCriacao do Perfil\n");
        System.out.println("Qual seu nome?\n");
        nomeCliente = scan.nextLine();
        System.out.println("Qual seu email?\n");
        email = scan.nextLine();
        System.out.println("Qual seu user para acesso?\n");
        user = scan.nextLine();
        System.out.println("Qual a senha de acesso?\n");
        senha = scan.nextLine();
        System.out.println("Voce eh Gerente?\n True | False");
        ehGerente = scan.nextBoolean();

        // id gerado aleatório
        id = nomeCliente.substring(2) + user.substring(2) + senha.substring(2);
        System.out.println(id);

        System.out.println("Criando Perfil\n");

        // enviar perfil do usuario para um arquivo txt

        FileWriter arq = new FileWriter(
                "usuarios.txt", true);

        try {
            BufferedWriter Arq = new BufferedWriter(arq);

            Arq.write("Usuario: " + nomeCliente);
            Arq.newLine();
            Arq.write("Email: " + email);
            Arq.newLine();
            Arq.write("User: " + user);
            Arq.newLine();
            Arq.write("Senha: " + senha);
            Arq.newLine();
            Arq.write("ID " + id);
            Arq.newLine();
            Arq.write("Gerente? " + ehGerente);
            System.out.println("\n");

            Arq.flush();
            Arq.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        arq.close();
    }

    // editar Perfil
    public void editarPerfil(Scanner scan) {
        int i = 6;

        while (i == 0) {
            System.out.println("1. Nome, 2. Email, 3. User, 4. Senha, 0. Sair");
            System.out.println("O que deseja editar do perfil?");
            i = scan.nextInt();

            if (i == 1) {
                System.out.println("\nSeu nome atual eh " + nomeCliente);
                nomeCliente = scan.nextLine();

                System.out.println("\nSeu novo nome eh " + email);

            } else if (i == 2) {
                System.out.println("\nSeu email atual eh " + email);
                email = scan.nextLine();

                System.out.println("\nSeu novo email eh " + email);
            } else if (i == 3) {
                System.out.println("\nSeu user atual eh " + user);
                user = scan.nextLine();

                System.out.println("\nSeu novo user eh " + user);
            } else if (i == 4) {
                System.out.println("\nSua senha atual eh " + senha);
                senha = scan.nextLine();

                System.out.println("\nSua nova senha eh " + senha);

            } else if (i == 0) {
                System.out.println("Saindo de editar perfil...");
            }
        }
    }

    // excluir Perfil
    public void excluirPerfil(Scanner scan) {
        String confirm;

        System.out.println("Tem certeza que deseja excluir?\n");
        System.out.println("Digite 'sim' para confirmar ou 'nao' para cancelar\n");
        confirm = scan.nextLine();

        switch (confirm) {
            case "sim":

                break;

            case "nao":

                break;

            default:
                System.out.println("comando errado");
                break;
        }
        // acessar arquivo para apagar
    }

    // listar Perfil
    public void listarPerfis() {
        // acessar arquivo
        BufferedReader read = new BufferedReader(arq);
    }

    // visualizar Perfil
    public void visualizarPerfil() {
        System.out.println("Nome: " + nomeCliente);
        System.out.println("Email: " + email);
        System.out.println("id: " + id);
        System.out.println("user: " + user);
        System.out.println("senha: " + senha);
    }

}
