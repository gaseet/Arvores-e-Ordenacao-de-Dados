package Cadastro;

import BinarySearchTree.ABB;
import Dados.Produto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroProduto {
    private ABB<Produto> dados;
    private Scanner leitor;

    public CadastroProduto () {
        dados = new ABB<Produto>();
        leitor = new Scanner(System.in);
    }

    public void cadastrarProduto() {
        Produto produto = new Produto(null, null, null, 0, 0);
        Produto aux;

        String codigo;

        System.out.print("Digite o código do produto: ");

        codigo = leitor.next();

        aux = buscarProduto(codigo);

        if (aux != null) {
            System.out.println("Produto com esse código já existe!");
            return;
        }

        produto.setCodigo(codigo);

        System.out.print("Digite a descrição do produto: ");
        produto.setDescricao(leitor.next());

        System.out.print("Digite o fornecedor do produto: ");
        produto.setFornecedor(leitor.next());

        System.out.print("Digite o preço do produto: ");
        produto.setPreco(lerDoubleMaiorZero());

        System.out.print("Digite o estoque do produto: ");
        produto.setEstoque(lerIntMaiorIgualZero());

        dados.insert(produto);
    }

    public void exibirProdutos() {
        dados.emOrdem();
    }

    private Produto buscarProduto(String codigo) {
        return dados.buscarObjeto(new Produto(codigo));
    }

    public void alterarPrecoProduto(String codigo) {
        Produto produto = buscarProduto(codigo);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.print("Digite o novo preço: ");
            double novoPreco = lerDoubleMaiorZero();
            produto.setPreco(novoPreco);
        }
    }

    public void alterarEstoqueProduto(String codigo) {
        Produto produto = buscarProduto(codigo);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.print("Digite o novo estoque: ");
            int novoEstoque = lerIntMaiorIgualZero();
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
            System.out.println("Preço: R$ " + produto.getPreco());
            System.out.println("Estoque: " + produto.getEstoque());
        }
    }

    private int lerIntMaiorIgualZero() {
        int aux;
        while (true) {
            try {
                aux = leitor.nextInt();

                if (aux < 0) {
                    throw new IllegalArgumentException("Entrada inválida. Digite um número maior ou igual a 0.");
                }

                return aux;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número decimal.");
                leitor.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private double lerDoubleMaiorZero() {
        double aux;
        while (true) {
            try {
                aux = leitor.nextDouble();

                if (aux <= 0) {
                    throw new IllegalArgumentException("Entrada inválida. Digite um número maior que 0.");
                }

                return aux;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número decimal.");
                leitor.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
