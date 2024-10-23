package Exceptions;

public class ProdutoException extends Excecoes {
    public ProdutoException(int codigo) {
        super("Produto com codigo " + codigo + " nao encontrado.");
    }
}
