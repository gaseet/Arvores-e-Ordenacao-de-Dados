package AplicacaoABB;
import BinarySearchTree.ABB;

// Fazer switch case pra inserir, remover, exibir etc

public class teste {
    public static void main(String[] args) throws Exception {
        ABB arvore = new ABB();
        arvore.insert2temp(6);
        arvore.insert2temp(2);
        arvore.insert2temp(1);
        arvore.insert2temp(7);
        arvore.insert2temp(4);
        arvore.insert2temp(9);
        arvore.insert2temp(5);
        arvore.insert2temp(8);
        arvore.insert2temp(3);

        System.out.println("-");
        System.out.println(arvore.contarNaoTerminaisNaoRecursiva());
        System.out.println("-");
        System.out.println(arvore.contarNaoTerminaisRecursiva());
    }
}
