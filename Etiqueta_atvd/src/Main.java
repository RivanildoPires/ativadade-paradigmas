public class Main {
    public static void main(String[] args) {

        Produto produto = new Produto("Guarana", 2.0, 20.0, "75848574");
        String etiquetaZpl = GeradorEtiqueta.gerarEtiqueta(produto);

        System.out.println(etiquetaZpl);

    }
}