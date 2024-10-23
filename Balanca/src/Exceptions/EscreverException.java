package Exceptions;

public class EscreverException extends Excecoes {
    public EscreverException(String mensagem) {
        super("Erro ao escrever descricao, digite algo: " + mensagem);
    }
}
