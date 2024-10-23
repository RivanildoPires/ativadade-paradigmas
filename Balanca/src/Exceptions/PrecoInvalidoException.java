package Exceptions;

public class PrecoInvalidoException extends Excecoes {
    public PrecoInvalidoException(String messagem) {
        super("Preco invalido: " + messagem);
    }
}
