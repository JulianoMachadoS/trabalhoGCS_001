public class Validador {

    public static boolean isLetraValida(char letra) {
        return Character.isLetter(letra);
    }

    public static boolean isLetraJaUsada(char letra, String letrasUsadas) {
        return letrasUsadas.indexOf(Character.toLowerCase(letra)) != -1;
    }

    public static String adicionarLetraUsada(char letra, String letrasUsadas) {
        return letrasUsadas + Character.toLowerCase(letra);
    }
}