package Exceptions;

public class ProdutoInvalidoException extends Excecoes {
    public ProdutoInvalidoException(String descricao) {
        super("Produto invalido: " + descricao);
    }
}
