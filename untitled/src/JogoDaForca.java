public class JogoDaForca {
    private String palavraSecreta;
    private StringBuilder palavraOculta;
    private int tentativasRestantes;

    public JogoDaForca(String palavra) {
        this.palavraSecreta = palavra.toLowerCase();
        this.tentativasRestantes = 6;
        inicializarPalavraOculta();
    }

    private void inicializarPalavraOculta() {
        palavraOculta = new StringBuilder();
        for (int i = 0; i < palavraSecreta.length(); i++) {
            palavraOculta.append("_ ");
        }
    }

    public void exibirStatus() {
        System.out.println("Palavra: " + palavraOculta);
        System.out.println("Tentativas restantes: " + tentativasRestantes);
    }

    public static void main(String[] args) {
        JogoDaForca jogo = new JogoDaForca("java");
        jogo.exibirStatus();
    }
}