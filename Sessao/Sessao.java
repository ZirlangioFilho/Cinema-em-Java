package arquivo;

public class Sessao {

    private int ingressosDisponiveis;
    private int data;
    private String hora;
    private String filme;
    private float precoIngresso;

    public Sessao(int ingressosDisponiveis, int data, String hora, String filme, float precoIngresso) {
        this.ingressosDisponiveis = ingressosDisponiveis;
        this.hora = hora;
        this.filme = filme;
        this.data = data;
        this.precoIngresso = precoIngresso;
    }

    public void visualizarSessao() {
        System.out.println("Ingressos Disponiveis:  " + ingressosDisponiveis);
        System.out.println("Data: " + data);
        System.out.println("Hora: " + hora);
        System.out.println("Filme: " + filme);
        System.out.println("Preco Ingresso: R$ " + precoIngresso);
    }

    public static Sessao criarSessao(int ingressosDisponiveis, int data, String hora, String filme,
            float precoIngresso) {
        return new Sessao(ingressosDisponiveis, data, hora, filme, precoIngresso);
    }

    public void editarSessao(int ingressosDisponiveis, int data, String hora) {
        this.ingressosDisponiveis = ingressosDisponiveis;
        this.data = data;
        this.hora = hora;
    }

    public void excluirSessao() {
        this.ingressosDisponiveis = 0;
        this.data = 0;
        this.hora = "";
        this.filme = "";
        this.precoIngresso = 0.0f;
        System.out.println("Sessão excluida com sucesso!");
    }

    public static void listarSessoes(Sessao[] sessoes) {
        for (Sessao sessao : sessoes) {
            sessao.visualizarSessao();
            System.out.println("--------------------");
        }
    }

    public boolean verificarDisponibilidade(int quantidadeIngressos) {
        return this.ingressosDisponiveis >= quantidadeIngressos;
    }

    public void reservarIngressos(int quantidadeIngressos) {
        if (verificarDisponibilidade(quantidadeIngressos)) {
            this.ingressosDisponiveis -= quantidadeIngressos;
            System.out.println("Reserva realizada com sucesso! Ingressos disponiveis:  " + this.ingressosDisponiveis);
        } else {
            System.out.println("Erro: Não há ingressos suficientes disponiveis.");
        }
    }

    public int getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }

    public void setIngressosDisponiveis(int ingressosDisponiveis) {
        this.ingressosDisponiveis = ingressosDisponiveis;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public float getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(float precoIngresso) {
        this.precoIngresso = precoIngresso;
    }
}