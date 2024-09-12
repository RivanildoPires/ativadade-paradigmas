def criar_produto(codigo, descricao, total):
    return {
        'codigo': codigo,
        'descricao': descricao,
        'total': total,
        'acrescimo': 0.0,
        'desconto': 0.0
    }

def adicionar_acrescimo(produto, acrescimo):
    produto['acrescimo'] += acrescimo
    produto['total'] += acrescimo

def adicionar_desconto(produto, desconto):
    produto['desconto'] += desconto
    produto['total'] -= desconto

def encontrar_produto(produtos, codigo):
    for produto in produtos:
        if produto['codigo'] == codigo:
            return produto
    return None

def adicionar_produto(produtos, produto):
    produtos.append(produto)

def aplicar_acrescimo(produtos, codigo, valor):
    produto = encontrar_produto(produtos, codigo)
    if produto:
        adicionar_acrescimo(produto, valor)

def distribuicao_acrescimo(produtos, valor):
    if produtos:
        acrescimo_por_produto = valor / len(produtos)
        for produto in produtos:
            adicionar_acrescimo(produto, acrescimo_por_produto)

def aplicar_desconto(produtos, codigo, valor):
    produto = encontrar_produto(produtos, codigo)
    if produto:
        adicionar_desconto(produto, valor)

def distribuicao_desconto(produtos, valor):
    if produtos:
        desconto_por_produto = valor / len(produtos)
        for produto in produtos:
            adicionar_desconto(produto, desconto_por_produto)

def realizar_venda(produtos):
    total_acrescimo = sum(p['acrescimo'] for p in produtos)
    total_desconto = sum(p['desconto'] for p in produtos)
    valor_total = sum(p['total'] for p in produtos)

    sb = ["Produtos no Carrinho:\n"]
    for produto in produtos:
        sb.append(f"{produto['codigo']} Codigo: {produto['descricao']} / Total: {produto['total']} / Acrescimo: {produto['acrescimo']} / Desconto: {produto['desconto']}\n")

    sb.append(f"Venda: Acrescimo: {total_acrescimo} / Desconto: {total_desconto} / Valor: {valor_total}")
    print("".join(sb))

def obter_opcao():
    print("1. Colocar produto no carrinho")
    print("2. Acrescimo de produto")
    print("3. Desconto de produto")
    print("4. Acrescimo total")
    print("5. Desconto total")
    print("9. Fechar venda")
    return int(input("Escolha uma opcao: "))

def processar_opcao(opc, produtos):
    if opc == 1:
        codigo = input("Digite o código do produto: ")
        descricao = input("Digite uma descrição: ")
        total = float(input("Digite o total: "))
        adicionar_produto(produtos, criar_produto(codigo, descricao, total))
    elif opc == 2:
        codigo = input("Digite o código do item que deseja aplicar acrescimo: ")
        acrescimo = float(input("Valor de acréscimo: "))
        aplicar_acrescimo(produtos, codigo, acrescimo)
    elif opc == 3:
        codigo = input("Digite o código do item que deseja aplicar desconto: ")
        desconto = float(input("Valor de desconto: "))
        aplicar_desconto(produtos, codigo, desconto)
    elif opc == 4:
        acrescimo = float(input("Valor total do acrescimo: "))
        distribuicao_acrescimo(produtos, acrescimo)
    elif opc == 5:
        desconto = float(input("Valor total do desconto: "))
        distribuicao_desconto(produtos, desconto)
    elif opc == 9:
        realizar_venda(produtos)
        return True
    return False

def main():
    produtos = []
    while True:
        opc = obter_opcao()
        if processar_opcao(opc, produtos):
            break

if __name__ == "__main__":
    main()