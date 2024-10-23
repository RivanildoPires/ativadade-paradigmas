package Exceptions;

public class ExportacaoFalhouException extends Excecoes {
    public ExportacaoFalhouException(String mensagem) {
        super("Falha na exportacao: " + mensagem);
    }
}
