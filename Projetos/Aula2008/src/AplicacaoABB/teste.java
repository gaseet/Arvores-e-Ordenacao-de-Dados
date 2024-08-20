package AplicacaoABB;
import BinarySearchTree.ABB;

// Fazer switch case pra inserir, remover, exibir etc

public class teste {
    public static void main(String[] args) throws Exception {
        ABB arvore = new ABB();
        arvore.insert2temp(2);
        arvore.insert2temp(10);
        arvore.insert2temp(5);
        arvore.insert2temp(15);
        arvore.insert2temp(1);
        arvore.insert2temp(0);
        arvore.insert2temp(-1);

        arvore.exibirMaiorValor();
        arvore.exibirMenorValor();

        System.out.println("-");
        arvore.emOrdem();
        System.out.println("-");
        arvore.preOrdem();
        System.out.println("-");
        arvore.posOrdem();
        System.out.println("-");
        arvore.passeioPorNivel();
    }
}
