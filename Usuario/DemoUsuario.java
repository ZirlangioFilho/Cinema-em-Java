import java.util.Scanner;
import java.io.IOException;

public class DemoUsuario {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        Usuario usuario = new Usuario("Rodrigo", "joserodrigo2@gmail.com", "79931",
                "gamerzin", "bobo123", true);

        usuario.criarPerfil(scan);

        usuario.editarPerfil(scan);

        usuario.excluirPerfil(scan);

        usuario.listarPerfis();

        usuario.visualizarPerfil();

        scan.close();

    }
}