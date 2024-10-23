package services;

import Exceptions.DiretorioException;
import Exceptions.ExportacaoFalhouException;
import interfaces.IBalanca;
import models.Produto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ToledoMGV6 implements IBalanca<Produto> {

    @Override
    public void exportar(List<Produto> produtos, String pastaArquivoTxt)throws ExportacaoFalhouException {
        File directory = new File(pastaArquivoTxt);
        if(directory == null){
            try {
                throw new DiretorioException(pastaArquivoTxt);
            } catch (DiretorioException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pastaArquivoTxt + "/ITENSMGV.TXT"))) {
            for (Produto produto : produtos) {
                String linha = formatarProduto(produto);
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new ExportacaoFalhouException(e.getMessage());
        }
    }

    private String formatarProduto(Produto produto) {
        String dept = "01";
        String tipo = "0";
        String codigo = String.format("%06d", produto.getCodigo());
        String preco = String.format("%06d", (int) (produto.getValor() * 100));
        String descricao = String.format("%-50s", produto.getDescricao());

        String linha = dept + tipo + codigo + preco + "000" + descricao +
                "0000000000|01|                                                                      0000000000000000000000000|0000|0||";

        return linha;
    }
}