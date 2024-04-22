import java.util.ArrayList;
import java.util.Scanner;

public class Sala {
    private int numSala;
    private int capacidade;
    private int acessibilidade;

    public Sala(int numSala, int capacidade, int acessibilidade) {
        this.numSala = numSala;
        this.capacidade = capacidade;
        this.acessibilidade = acessibilidade;
    }

    public void criarSala(Scanner sc) {

        System.out.println("Numero da sala: ");
        numSala = sc.nextInt();
        sc.nextLine();

        System.out.println("Capacidade: ");
        capacidade = sc.nextInt();
        sc.nextLine();

        System.out.println("Acessibilidade: ");
        acessibilidade = sc.nextInt();
        sc.nextLine();
    }

    public void excluirSala(Scanner sc) {
        ArrayList<Sala> salas = new ArrayList<>();
        Sala[] salasArray = {
                new Sala(101, 50, 1),
                new Sala(102, 35, 0),
                new Sala(201, 70, 1),
        };

        for (Sala sala : salasArray) {
            salas.add(sala);
        }

        for (int i = 0; i < salas.size(); i++) {
            Sala sala = salas.get(i);
            if (sala.getNumSala() == numSala) {
                salas.remove(i);
                System.out.println("Sala com o número " + numSala + " excluída.");
                break;
            }
        }
    }

    public void editarSala(Scanner sc) {
        ArrayList<Sala> salas = new ArrayList<>();

        System.out.println("número da sala que deseja editar: ");
        int num = sc.nextInt();

        Sala salaEditar = null;
        for (Sala sala : salas) {
            if (sala.getNumSala() == num) {
                salaEditar = sala;
                break;
            }
        }

        if (salaEditar == null) {
            System.out.println("Sala com número " + num + " não encontrada.");
            return;
        } else {
            System.out.println("O que deseja editar?");
            System.out.println("1. Capacidade");
            System.out.println("2. Acessibilidade");

            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Nova capacidade: ");
                    int novaCapacidade = sc.nextInt();
                    salaEditar.setCapacidade(novaCapacidade);
                    break;
                case 2:
                    System.out.println("Nova acessibilidade (0 ou 1): ");
                    int novaAcessibilidade = sc.nextInt();
                    salaEditar.setAcessibilidade(novaAcessibilidade);
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }
            System.out.println("Informações da sala " + num + " atualizadas.");
        }
    }

    public void visualizarSala() {
        System.out.println("Detalhes da Sala " + numSala + ":");
        System.out.println(" - Capacidade: " + capacidade);
        System.out.println(" - Acessibilidade: " + acessibilidade);
    }

    public void listarSala(Scanner sc) {
        ArrayList<Sala> salas = new ArrayList<>();
        Sala[] salasArray = {
                new Sala(101, 50, 1),
                new Sala(102, 35, 0),
                new Sala(201, 70, 1),
        };

        for (Sala sala : salasArray) {
            salas.add(sala);
        }

        if (salas.isEmpty()) {
            System.out.println("Não há salas cadastradas.");
            return;
        } else {
            System.out.println("Lista de Salas:");
            for (Sala sala : salas) {
                System.out.println(" - Número: " + sala.getNumSala());
                System.out.println(" - Capacidade: " + sala.getCapacidade());
                System.out.println(" - Acessibilidade: " + sala.getAcessibilidade());
            }
        }
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(int acessibilidade) {
        this.acessibilidade = acessibilidade;
    }
}