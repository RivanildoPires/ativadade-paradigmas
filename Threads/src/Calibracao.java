public class Calibracao {
    public static int valorCalibracao(String linha) {
        Character primeiroCaractere = null;
        Character ultimoCaractere = null;


        for (char c : linha.toCharArray()) {
            if (Character.isDigit(c)) {
                if (primeiroCaractere == null) {
                    primeiroCaractere = c;
                }
                ultimoCaractere = c;
            }
        }

        if (primeiroCaractere != null) {
            return Integer.parseInt(primeiroCaractere.toString() + ultimoCaractere.toString());
        } else {
            return 0;
        }
    }
}