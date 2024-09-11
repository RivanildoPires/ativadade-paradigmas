import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido();
        Scanner sc = new Scanner(System.in);
        int opc = 0;


        //Coloquei a opc 9 para caso tenha algo a mais nessa atvd
        while(opc != 9){
            System.out.println("1. Colocar produto no carrinho");
            System.out.println("2. Acréscimo de produto");
            System.out.println("3. Desconto de produto");
            System.out.println("4. Acréscimo total");
            System.out.println("5. Desconto total");
            System.out.println("9. Fechar venda");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();

            if(opc == 1){
                System.out.println("Digite o codigo do produto");
                sc.nextLine();
                String codigo = sc.next();
                System.out.println("Digite uma descrição");
                String descricao = sc.next();
                sc.nextLine();
                System.out.println("Digite o total");
                double total = sc.nextDouble();
                pedido.adicionarProduto(new Produto(codigo,descricao,total));
            }
            if(opc == 2){
                System.out.println("Digite o codigo do item que deseja aplicar acrescimo");
                String codigo = sc.next();
                System.out.println("Valor de acrescimo");
                double acrescimo = sc.nextDouble();
                pedido.aplicarAcrescimo(codigo,acrescimo);
            }
            if(opc == 3){
                System.out.println("Digite o codigo do item que deseja aplicar desconto");
                String codigo = sc.next();
                System.out.println("Valor de desconto");
                double desconto = sc.nextDouble();
                pedido.aplicarDesconto(codigo,desconto);
            }
            if(opc == 4){
                System.out.println("Valor total do acrescimo");
                double acrescimo = sc.nextDouble();
                pedido.distribuicaoAcresimo(acrescimo);
            }
            if(opc == 5){
                System.out.println("Valor total do desconto");
                double desconto = sc.nextDouble();
                pedido.distruicaoDesconto(desconto);
            }
            if(opc == 9){
                pedido.venda();
            }

        }
        sc.close();
    }
}