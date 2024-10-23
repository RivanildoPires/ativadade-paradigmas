package services;

import Exceptions.*;
import interfaces.IBalanca;
import models.Produto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UranoIntegra implements IBalanca<Produto> {

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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pastaArquivoTxt + "/PRODUTOS.TXT"))) {
            for (Produto produto : produtos) {
                String linha = formatarProduto(produto);
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException | ProdutoException | EscreverException | PrecoInvalidoException e) {
            throw new ExportacaoFalhouException(e.getMessage());
        }
    }

    private String formatarProduto(Produto produto) throws ProdutoException, EscreverException, PrecoInvalidoException {
        String codigo = String.format("%06d", produto.getCodigo());
        if(codigo.isBlank()){
            throw new ProdutoException(codigo);
        }
        String flag = "*";
        String tipo = "9".equals(produto.getTipo()) ? "0" : "6"; // 9 coloquei como se fosse para o peso
        String descricao = String.format("%-20s", produto.getDescricao());
        if(descricao.isBlank()){
            throw new EscreverException(descricao);
        }

        String preco = String.format("%09.2f", produto.getValor()).replace(".", ",");
        if(preco.isEmpty()){
            throw new PrecoInvalidoException(preco);
        }

        return codigo + flag + tipo + descricao + preco + "00000D";
    }
}
