import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
        ArrayList<String> perfis = new ArrayList<String>(20);
        int recebeConfirm;

        System.out.println("\nCriacao do Perfil\n");
        System.out.println("Qual seu nome?\n");
        nomeCliente = scan.nextLine();
        System.out.println("Qual seu email?\n");
        email = scan.nextLine();
        System.out.println("Qual seu user para acesso?\n");
        user = scan.nextLine();
        System.out.println("Qual a senha de acesso?\n");
        senha = scan.nextLine();
        System.out.println("Voce eh Gerente?\n 0 para 'nao' | 1 para 'sim'");

        recebeConfirm = scan.nextInt();
        switch (recebeConfirm) {
            case 0:
                ehGerente = false;
                break;
            case 1:
                ehGerente = true;
                break;

            default:
                break;
        }

        // id gerado aleatório
        id = nomeCliente.substring(2) + user.substring(2) + senha.substring(2);
        System.out.println(id);

        System.out.println("Criando Perfil\n");

        String separa = ";";

        perfis.add(nomeCliente + separa + email + separa + user + separa + senha + separa + id + separa + ehGerente);

        // enviar perfil do usuario para um arquivo txt

        FileWriter arq = new FileWriter(
                "usuarios.txt", true);

        try {

            BufferedWriter Arq = new BufferedWriter(arq);

            Arq.write(nomeCliente + separa + email + separa + user +
                    separa + senha + separa + id + separa + ehGerente);

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
                System.out.println("\nSeu novo nome eh " + nomeCliente);

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
        int confirm;

        System.out.println("Tem certeza que deseja excluir?\n");
        System.out.println("Digite '1' para confirmar ou '0' para cancelar\n");
        confirm = scan.nextInt();

        switch (confirm) {
            case 1:
                System.out.println("Excluindo Perfil... ");

                break;
            case 0:
                System.out.println("Cancelando exclusao ");

                break;

            default:
                System.out.println("comando errado");
                break;
        }
        // acessar arquivo para apagar
    }

    // listar Perfil
    public void listarPerfis() throws IOException {

    }

    // visualizar Perfil
    public void visualizarPerfil() {
        // ArrayList<String> perfis = new ArrayList<String>(20);

        try {
            File lista = new File("usuarios.txt");

            Scanner scann = new Scanner(lista);

            while (scann.hasNextLine()) {
                System.out.println(scann.nextLine());
            }

            scann.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
