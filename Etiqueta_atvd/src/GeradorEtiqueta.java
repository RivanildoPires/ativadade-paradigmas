public class GeradorEtiqueta {

    public static String gerarEtiqueta(Produto produto){
        StringBuilder sb = new StringBuilder();
        sb.append("^XA\n");
        sb.append("^CF0,60\n");
        sb.append("^FO50,50^FD").append(produto.getDescricao()).append("^FS\n");
        sb.append("^CFA,50\n");
        sb.append("^FO50,200^FDLata ").append("R$").append(produto.getPrecoLata()).append("^FS\n");
        sb.append("^FO50,280^FDCaixa ").append("R$").append(produto.getPrecoCaixa()).append("^FS\n");
        sb.append("^BY5,2,270\n");
        sb.append("^FO100,450^BC^FD").append(produto.getCodigoBarras()).append("^FS\n");
        sb.append("^XZ");

        return sb.toString();

    }
}
