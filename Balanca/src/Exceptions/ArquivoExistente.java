package Exceptions;


public class ArquivoExistente extends Excecoes {
    public ArquivoExistente(String arquivo) {
        super("O arquivo " + arquivo + " já existe.");
    }
}
