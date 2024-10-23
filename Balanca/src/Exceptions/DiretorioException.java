package Exceptions;

public class DiretorioException extends Excecoes {
    public DiretorioException(String pastaArquivoTxt) {
        super("O diretório " + pastaArquivoTxt + " nao foi encontrado/existe.");
    }
}
