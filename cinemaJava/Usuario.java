package cinema;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        // id gerado aleatório
        id = nomeCliente.substring(2) + user.substring(2) + senha.substring(2);
        System.out.println("Seu id é: " + id);

        // gerente sim ou nao
        int recebeConfirm;
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

        // criacao do perfil
        System.out.println("Criando Perfil");

        // perfil para string com string separando por sessoes
        String separa = ";";

        String perfilStr = nomeCliente + separa + email + separa + user + separa + senha + separa + id + separa
                + ehGerente;
        // enviando perfil do usuario para um arquivo txt
        try (FileWriter arq = new FileWriter("usuarios.txt", true);
                BufferedWriter escreve = new BufferedWriter(arq)) {
            escreve.write(perfilStr);
            escreve.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // editar Perfil
    public void editarPerfil(Scanner scan) {
        System.out.println("Digite o ID do perfil que deseja editar: ");
        String idStr = scan.nextLine();

        ArrayList<String> perfis = new ArrayList<>();

        boolean encontrado = false;

        try {
            FileReader arquivo = new FileReader("usuarios.txt");
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] campos = linha.split(";");

                if (campos.length >= 6 && campos[4].equals(idStr)) {
                    encontrado = true;
                    System.out.println("1. Nome, 2. Email, 3. User, 4. Senha, 0. Sair");
                    System.out.println("O que deseja editar do perfil?");
                    int escolha = scan.nextInt();
                    scan.nextLine();

                    switch (escolha) {
                        case 1:
                            System.out.println("Qual é seu novo nome?");
                            campos[0] = scan.nextLine();
                            break;
                        case 2:
                            System.out.println("Qual é seu novo email?");
                            campos[1] = scan.nextLine();
                            break;
                        case 3:
                            System.out.println("Qual é seu novo usuário?");
                            campos[2] = scan.nextLine();
                            break;
                        case 4:
                            System.out.println("Qual é sua nova senha?");
                            campos[3] = scan.nextLine();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }

                    linha = String.join(";", campos); // Recriar a linha com os valores atualizados
                }
                perfis.add(linha); // Adicionar a linha (original ou modificada)
            }
            leitor.close();

            if (!encontrado) {
                System.out.println("ID " + idStr + " não existe.");
            } else {
                // Reescreve o arquivo com as mudanças
                try (FileWriter arquivoNovo = new FileWriter("usuarios.txt", false); // 'false' para sobrescrever
                        BufferedWriter escritor = new BufferedWriter(arquivoNovo)) {
                    for (String linha : perfis) {
                        escritor.write(linha); // Gravar cada linha no arquivo
                        escritor.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: ");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: ");
        }
    }

    // excluir Perfil
    public void excluirPerfil(Scanner scan) {
        System.out.println("Digite o ID do perfil que deseja excluir: ");
        String idStr = scan.nextLine();

        ArrayList<String> perfis = new ArrayList<>(); // Para armazenar todas as linhas
        boolean encontrado = false;

        try {
            FileReader arquivo = new FileReader("usuarios.txt");
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] campos = linha.split(";");

                if (campos.length >= 6 && campos[4].equals(idStr)) {
                    encontrado = true;
                } else {
                    perfis.add(linha);
                }
            }
            leitor.close();

            if (!encontrado) {
                System.out.println("ID " + idStr + " não existe.");
            } else {
                // Reescreve o arquivo com o perfil excluído
                try (FileWriter arquivoNovo = new FileWriter("usuarios.txt", false); // 'false' para sobrescrever
                        BufferedWriter escritor = new BufferedWriter(arquivoNovo)) {
                    for (String linha : perfis) {
                        escritor.write(linha);
                        escritor.newLine();
                    }
                    System.out.println("Seu Perfil " + idStr + " foi excluído");
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: ");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: ");
        }
    }

    // listar Perfil
    public void listarPerfis() {
        try (FileReader arq = new FileReader("usuarios.txt");
                BufferedReader ler = new BufferedReader(arq)) {
            String linha;
            while ((linha = ler.readLine()) != null) {
                String[] campos = linha.split(";");

                if (campos.length >= 6) {
                    String nomeCliente = campos[0];
                    String email = campos[1];
                    String user = campos[2];
                    String senha = campos[3];
                    String id = campos[4];
                    Boolean ehGerente = Boolean.parseBoolean(campos[5]);

                    System.out.println("Perfil:");
                    System.out.println("  Nome: " + nomeCliente);
                    System.out.println("  Email: " + email);
                    System.out.println("  Usuário: " + user);
                    System.out.println("  Senha: " + senha); // Apenas para demonstração; evitar em produção
                    System.out.println("  ID: " + id);
                    System.out.println("  Gerente: " + (ehGerente ? "Sim" : "Não"));
                    System.out.println("------------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    // visualizar Perfil
    public void visualizarPerfil(Scanner scan) {

        System.out.println("Digite o ID do perfil que deseja visualizar: ");
        String idStr = scan.nextLine();

        boolean encontrado = false;

        try {
            FileReader arquivo = new FileReader("usuarios.txt");

            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] campos = linha.split(";");

                // checando campos do arquivo
                if (campos.length >= 6) {
                    String id = campos[4];

                    if (id.equals(idStr)) {
                        encontrado = true;
                        System.out.println("Perfil:");
                        System.out.println("  Nome: " + campos[0]);
                        System.out.println("  Email: " + campos[1]);
                        System.out.println("  Usuário: " + campos[2]);
                        System.out.println("  Senha: " + campos[3]);
                        System.out.println("  ID: " + id);
                        System.out.println("  Gerente: " + (Boolean.parseBoolean(campos[5]) ? "Sim" : "Não"));
                        break;
                    }
                    if (!encontrado) {
                        System.out.println("Perfil com ID " + idStr + " não existente.");
                    }
                    leitor.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }

    public Boolean getEhGerente() {
        return ehGerente;
    }
}