package Exceptions;

public class LeituraException extends Excecoes {
    public LeituraException(String mensagem) {
        super("Erro de leitura: " + mensagem);
    }
}
