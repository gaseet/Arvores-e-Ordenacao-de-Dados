package AplicacaoABB;

import Cadastro.CadastroProduto;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        CadastroProduto cadastro = new CadastroProduto();
        
        int choice = 0;

        String codigoAux;
        
        do {
            codigoAux = null;
            exibirOpcoes();
            choice = lerInt(leitor);
            switch (choice) {
                case 1:
                    cadastro.cadastrarProduto();
                    break;
                case 2:
                    cadastro.exibirProdutos();
                    break;
                case 3:
                    System.out.print("Digite o código do produto: ");
                    codigoAux = leitor.next();
                    cadastro.alterarPrecoProduto(codigoAux);
                    break;
                case 4:
                    System.out.print("Digite o código do produto: ");
                    codigoAux = leitor.next();
                    cadastro.alterarEstoqueProduto(codigoAux);
                    break;
                case 5:
                    System.out.print("Digite o código do produto: ");
                    codigoAux = leitor.next();
                    cadastro.exibirInformacoesProduto(codigoAux);
                    break;
                case 0:
                    System.out.println("Byeeee");
                    break;
                default:
                    System.out.println("0 - Sair");
                    break;
            }
        } while (choice != 0);
    }

    public static void exibirOpcoes() {
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Exibir produtos");
        System.out.println("3 - Alterar preço de um produto");
        System.out.println("4 - Alterar estoque de um produto");
        System.out.println("5 - Exibir informações de um produto");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção: ");
    }

    private static int lerInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        }
    }
}
