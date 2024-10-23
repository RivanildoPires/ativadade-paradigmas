package Exceptions;

public class ProdutoException extends Excecoes {
    public ProdutoException(String messagem) {
        super("Digite um codigo para o produto" + messagem);
    }
}
