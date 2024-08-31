package AplicacaoABB;
import BinarySearchTree.ABB;

// Fazer switch case pra inserir, remover, exibir etc

public class teste {
    public static void main(String[] args) throws Exception {
        ABB<Integer> arvore = new ABB<Integer>();
        arvore.insert(100);
        arvore.insert(50);
        arvore.insert(25);
        arvore.insert(55);
        arvore.insert(45);
        arvore.insert(30);

        arvore.passeioPorNivel();

        arvore.removerNaoRecursivo(50);
        System.out.println("Removendo 50");
        arvore.passeioPorNivel();
    }
}
