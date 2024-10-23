package interfaces;

import Exceptions.ExportacaoFalhouException;

import java.util.List;

public interface IBalanca<T> {
    void exportar(List<T> produtos, String pastaArquivoTxt) throws ExportacaoFalhouException;
}