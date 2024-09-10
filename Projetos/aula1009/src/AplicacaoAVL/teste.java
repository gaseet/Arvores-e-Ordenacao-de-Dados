package AplicacaoAVL;
import AVL.AVL;

// Fazer switch case pra inserir, remover, exibir etc

public class teste {
    public static void main(String[] args) throws Exception {
        AVL<Integer> arvore = new AVL<Integer>();
        arvore.insert(1);
        arvore.insert(2);
        arvore.passeioPorNivel();

        System.out.println("-");
        arvore.insert(3);
        arvore.passeioPorNivel();

    }
}
