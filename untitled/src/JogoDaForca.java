import java.util.Scanner;
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
        Scanner scanner = new Scanner(System.in);
        JogoDaForca jogo = new JogoDaForca("java");

        System.out.println("=== JOGO DA FORCA ===\n");

        while (!jogo.isJogoGanho() && !jogo.isJogoPerdido()) {
            jogo.exibirStatus();
            System.out.print("\nDigite uma letra: ");
            char letra = scanner.next().charAt(0);

            if (jogo.tentarLetra(letra)) {
                System.out.println("Acertou!");
            } else {
                System.out.println("Errou!");
            }
            System.out.println();
        }

        if (jogo.isJogoGanho()) {
            System.out.println("Parabéns! Você ganhou!");
        } else {
            System.out.println("Game Over! A palavra era: " + jogo.palavraSecreta);
        }

        scanner.close();
    }

    public boolean tentarLetra(char letra) {
        letra = Character.toLowerCase(letra);
        boolean acertou = false;

        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                palavraOculta.setCharAt(i * 2, letra);
                acertou = true;
            }
        }

        if (!acertou) {
            tentativasRestantes--;
        }

        return acertou;
    }

    public boolean isJogoGanho() {
        return !palavraOculta.toString().contains("_");
    }

    public boolean isJogoPerdido() {
        return tentativasRestantes <= 0;
    }
}