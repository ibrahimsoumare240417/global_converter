import java.util.Scanner;

public class ConversionBase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("chaîne de caractères : ");
        String str = scanner.nextLine();

        System.out.print("Entrez la base actuelle : ");
        int baseActuelle = scanner.nextInt();

        System.out.print("Entrez la base souhaitée : ");
        int baseSouhaitee = scanner.nextInt();

        String resultat = convertirBase(str, baseActuelle, baseSouhaitee);
        System.out.println("Le résultat de la conversion est : " + resultat);
    }

    public static String convertirBase(String str, int baseActuelle, int baseSouhaitee) {
        int nombreDecimal = convertirEnDecimal(str, baseActuelle);
        return convertirEnBase(nombreDecimal, baseSouhaitee);
    }

    public static int convertirEnDecimal(String str, int base) {
        int nombreDecimal = 0;
        int puissance = 1;

        for (int i = str.length() - 1; i >= 0; i--) {
            int chiffre = charVersChiffre(str.charAt(i));
            nombreDecimal += chiffre * puissance;
            puissance *= base;
        }

        return nombreDecimal;
    }

    public static String convertirEnBase(int nombreDecimal, int base) {
        StringBuilder resultat = new StringBuilder();

        while (nombreDecimal > 0) {
            int reste = nombreDecimal % base;
            char chiffre = chiffreVersChar(reste);
            resultat.insert(0, chiffre);
            nombreDecimal /= base;
        }

        return resultat.toString();
    }

    public static int charVersChiffre(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        } else {
            throw new IllegalArgumentException("Caractère invalide : " + c);
        }
    }

    public static char chiffreVersChar(int chiffre) {
        if (chiffre >= 0 && chiffre <= 9) {
            return (char) (chiffre + '0');
        } else if (chiffre >= 10 && chiffre <= 35) {
            return (char) (chiffre - 10 + 'A');
        } else {
            throw new IllegalArgumentException("Chiffre invalide : " + chiffre);
        }
    }
}