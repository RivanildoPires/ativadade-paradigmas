public class Produto {

    private String codigo;
    private String descricao;
    private double acrescimo;
    private double desconto;
    private double total;


    public Produto() {
    }

    public Produto(String codigo, String descricao, double total) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.total = total;
        this.acrescimo = 0;
        this.desconto = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getAcrescimo() {
        return acrescimo;
    }


    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void adicionarAcresimo(double acrescimo){
        this.acrescimo += acrescimo;
        this.total += acrescimo;
    }
    public void adicionarDesconto(double desconto){
        this.desconto += desconto;
        this.total -= desconto;;
    }

}