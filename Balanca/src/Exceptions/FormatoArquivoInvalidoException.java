package Exceptions;

public class FormatoArquivoInvalidoException extends Excecoes {
    public FormatoArquivoInvalidoException(String formato) {
        super("Formato de arquivo invalido: " + formato);
    }
}
