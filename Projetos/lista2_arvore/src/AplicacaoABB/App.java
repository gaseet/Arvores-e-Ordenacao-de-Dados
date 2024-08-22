package AplicacaoABB;
import java.util.Scanner;

import BinarySearchTree.ABB;

public class App {
    public static void main (String[] args) {

        ABB arvore = new ABB();
        int num, op;
        Scanner input = new Scanner(System.in);
    
        do {
            exibirOpcoes();
            op = input.nextInt();
            switch(op) {
                case 1: System.out.print("Informe um número inteiro: ");
                    num = input.nextInt();
                    arvore.insert(num);
                    break;
                case 2: // em desenvolvimento
                    break;
                case 0:
                    System.out.println("Bye bye!");
                    break;                    
            }
        } while (op != 0);
        input.close();
    }
    public static void exibirOpcoes () {
        System.out.println("Opções");
        System.out.println("1 - Inserir valor");
        System.out.println("2 - Procurar valor");
        System.out.println("0 - Encerrar programa");
        System.out.print("Informe a opção: ");
    }
}