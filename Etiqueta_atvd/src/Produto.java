public class Produto {

    private String descricao;
    private double precoLata;
    private double precoCaixa;
    private String codigoBarras;

    public Produto(String descricao, double precoLata, double precoCaixa, String codigoBarras) {
        this.descricao = descricao;
        this.precoLata = precoLata;
        this.precoCaixa = precoCaixa;
        this.codigoBarras = codigoBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoLata() {
        return precoLata;
    }

    public void setPrecoLata(double precoLata) {
        this.precoLata = precoLata;
    }

    public double getPrecoCaixa() {
        return precoCaixa;
    }

    public void setPrecoCaixa(double precoCaixa) {
        this.precoCaixa = precoCaixa;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
}
