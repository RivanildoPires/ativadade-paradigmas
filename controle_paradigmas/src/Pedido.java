import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }

    public void aplicarAcrescimo(String codigo,Double valor){
        for(Produto produto : produtos){
            if(produto.getCodigo().equals(codigo)){
                produto.adicionarAcresimo(valor);
            }
        }
    }

    public void distribuicaoAcresimo(Double valor){
        Double acrescimoProduto = valor/produtos.size();
        for(Produto produto: produtos){
            produto.adicionarAcresimo(acrescimoProduto);
        }
    }

    public void aplicarDesconto(String codigo,Double valor){
        for(Produto produto : produtos){
            if(produto.getCodigo().equals(codigo)){
                produto.adicionarDesconto(valor);
            }
        }
    }

    public void distruicaoDesconto(Double valor){
        Double descontoProduto = valor/produtos.size();
        for(Produto produto : produtos){
            produto.adicionarDesconto(descontoProduto);
        }
    }

    public void venda(){
        double totalAcrescimo = 0;
        double totalDesconto = 0;
        double valorTotal = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("Produtos no Carrinho: ");

        for(Produto produto : produtos){
            totalAcrescimo += produto.getAcrescimo();
            totalDesconto -= produto.getDesconto();
            valorTotal += produto.getTotal();
            sb.append(produto.getCodigo()).append("Codigo: ")
                    .append(produto.getDescricao()).append(" / ")
                    .append(" Total: ").append(produto.getTotal()).append(" / ")
                    .append(" Acrescimo: ").append(produto.getAcrescimo()).append(" / ")
                    .append(" Desconto: ").append(produto.getDesconto()).append("\n");
        }

        sb.append("Venda: ")
                .append("Acrescimo: ").append(totalAcrescimo).append(" / ")
                .append("Desconto: ").append(totalDesconto).append(" / ")
                .append("Valor: ").append(valorTotal).append("");

        System.out.println(sb.toString());
    }
}

