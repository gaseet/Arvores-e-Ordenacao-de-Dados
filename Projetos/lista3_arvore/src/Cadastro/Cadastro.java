package Cadastro;

import Produto.Produto;
import BinarySearchTree.ABB;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cadastro {
    private ABB<Produto> arvore = new ABB<Produto>();
    private Scanner leitor = new Scanner(System.in);

    public void cadastrarProduto() {
        Produto produto = new Produto(null, null, null, 0, 0);

        System.out.print("Digite o código do produto: ");
        produto.setCodigo(leitor.next());

        System.out.print("Digite a descrição do produto: ");
        produto.setDescricao(leitor.next());

        System.out.print("Digite o fornecedor do produto: ");
        produto.setFornecedor(leitor.next());

        System.out.print("Digite o preço do produto: ");
        produto.setPreco(lerDouble());

        System.out.print("Digite o estoque do produto: ");
        produto.setEstoque(lerInt());

        arvore.insert(produto);
    }

    public void exibirProdutos() {
        arvore.emOrdem();
    }

    private Produto buscarProduto(String codigo) {
        return arvore.buscarObjeto(new Produto(codigo, null, null, 0, 0));
    }

    public void alterarPrecoProduto(String codigo) {
        Produto produto = buscarProduto(codigo);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.print("Digite o novo preço: ");
            double novoPreco = lerDouble();
            produto.setPreco(novoPreco);
        }
    }

    public void alterarEstoqueProduto(String codigo) {
        Produto produto = buscarProduto(codigo);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.print("Digite o novo estoque: ");
            int novoEstoque = lerInt();
            produto.setEstoque(novoEstoque);
        }
    }

    public void exibirInformacoesProduto(String codigo) {
        Produto produto = buscarProduto(codigo);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Fornecedor: " + produto.getFornecedor());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Estoque: " + produto.getEstoque());
        }
    }

    private double lerDouble() {
        while (true) {
            try {
                return leitor.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número decimal.");
                leitor.next();
            }
        }
    }

    private int lerInt() {
        while (true) {
            try {
                return leitor.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                leitor.next();
            }
        }
    }
}
