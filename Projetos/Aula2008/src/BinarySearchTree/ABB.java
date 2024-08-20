package BinarySearchTree;

import java.util.Queue;
import java.util.LinkedList;

public class ABB {
    private ABBNode raiz;

    public boolean isEmpty() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    // IMPLEMENTAR OS MÉTODOS:

    public void insert (Integer value) {
        ABBNode novo;
        novo = new ABBNode(value);

        ABBNode aux;
        int result;

        if (this.isEmpty() == true) {
            this.raiz = novo;
        } else {
            aux = this.raiz;
            while (true) {
                result = value.compareTo(aux.getInfo());
                if (result == 0) {
                    System.out.println("Valor já presente.");
                    return;
                } else if (result < 0) {
                    if (aux.getLeft() == null) {
                        aux.setLeft(novo);
                        System.out.println("Inserção efetuada.");
                        return;
                    } else {
                        aux = aux.getLeft();
                    }
                } else {
                    if (aux.getRight() == null) {
                        aux.setRight(novo);
                        System.out.println("Inserção efetuada.");
                        return;
                    } else {
                        aux = aux.getRight();
                    }
                }
            }
        }
    }

    public void insert2temp (Integer value) {
        ABBNode novo;
        novo = new ABBNode(value);

        ABBNode temp1, temp2;
        int result;

        if (this.isEmpty() == true) {
            this.raiz = novo;
        } else {
            temp1 = this.raiz;
            do {
                result = value.compareTo(temp1.getInfo());
                if (result == 0) {
                    System.out.println("Valor já presente.");
                    return;
                } else if (result < 0) {
                    temp2 = temp1;
                    temp1 = temp1.getLeft();
                } else {
                    temp2 = temp1;
                    temp1 = temp1.getRight();
                }
            } while (temp1 != null);

            if (result < 0) {
                temp2.setLeft(novo);
            } else {
                temp2.setRight(novo);
            }
        }
    }

    private ABBNode buscar (Integer value) {

        ABBNode aux;
        int result;

        if (this.isEmpty() == true) {
            return null;
        } else {
            aux = this.raiz;
            while (true) {
                result = value.compareTo(aux.getInfo());
                if (result == 0) {
                    return aux;
                } else if (result < 0) {
                    if (aux.getLeft() == null) {
                        return null;
                    } else {
                        aux = aux.getLeft();
                    }
                } else {
                    if (aux.getRight() == null) {
                        return null;
                    } else {
                        aux = aux.getRight();
                    }
                }
            }
        }
    }

    public void valorEstaPresente (Integer value) {
        if (this.buscar(value) == null) {
            System.out.printf("Valor %d não encontrado na árvore.\n", value);
        } else {
            System.out.printf("Valor %d encontrado na árvore.\n", value);
        }
    }

    private ABBNode menorValorEndereco() {
        ABBNode aux;
        aux = this.raiz;

        if (this.isEmpty() == true) {
            return null;
        } else {
            while (aux.getLeft() != null) {
                aux = aux.getLeft();
            }
            return aux;
        }
    }

    private ABBNode maiorValorEndereco() {
        ABBNode aux;
        aux = this.raiz;

        if (this.isEmpty() == true) {
            return null;
        } else {
            while (aux.getRight() != null) {
                aux = aux.getRight();
            }
            return aux;
        }
    }

    public void exibirMenorValor() {
        ABBNode aux;
        aux = this.menorValorEndereco();

        if (aux == null) {
            System.out.println("Árvore vazia.");
        } else {
            System.out.printf("Menor valor: %d\n", aux.getInfo());
        }
    }

    public void exibirMaiorValor() {
        ABBNode aux;
        aux = this.maiorValorEndereco();

        if (aux == null) {
            System.out.println("Árvore vazia.");
        } else {
            System.out.printf("Maior valor: %d\n", aux.getInfo());
        }
    }

    public void emOrdem() {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia.");
        } else {
            this.percorrerEmOrdem(raiz);
        }
    }

    private void percorrerEmOrdem(ABBNode r) {
        if (r != null) {
            percorrerEmOrdem(r.getLeft());
            System.out.println(r.getInfo());
            percorrerEmOrdem(r.getRight());
        }
    }

    public void preOrdem() {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia.");
        } else {
            this.percorrerPreOrdem(raiz);
        }
    }

    private void percorrerPreOrdem(ABBNode r) {
        if (r != null) {
            System.out.println(r.getInfo());
            percorrerPreOrdem(r.getLeft());
            percorrerPreOrdem(r.getRight());
        }
    }

    public void posOrdem() {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia.");
        } else {
            this.percorrerPosOrdem(raiz);
        }
    }

    private void percorrerPosOrdem(ABBNode r) {
        if (r != null) {
            percorrerPosOrdem(r.getLeft());
            percorrerPosOrdem(r.getRight());
            System.out.println(r.getInfo());
        }
    }

    public void passeioPorNivel() {
        Queue<ABBNode> fila;
        ABBNode aux;
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia");
        } else {
            fila = new LinkedList<>();
            fila.add(raiz);
            while(fila.isEmpty() == false) {
                aux = fila.remove();
                if (aux.getLeft() != null) {
                    fila.add(aux.getLeft());
                }
                if (aux.getRight() != null) {
                    fila.add(aux.getRight());
                }
                System.out.println(aux.getInfo());
            }
        }
    }
}
