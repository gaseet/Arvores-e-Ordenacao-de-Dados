package BinarySearchTree;

import TADQueue.Queue;
import TADStack.Stack;

public class ABB {
    private ABBNode root;

    public boolean isEmpty() {
        if (this.root == null) {
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
            this.root = novo;
        } else {
            aux = this.root;
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
            this.root = novo;
        } else {
            temp1 = this.root;
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
            aux = this.root;
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
        aux = this.root;

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
        aux = this.root;

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
            this.percorrerEmOrdem(root);
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
            this.percorrerPreOrdem(root);
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
            this.percorrerPosOrdem(root);
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
            System.out.println("Árvore vazia.");
        } else {
            fila = new Queue<ABBNode>();
            fila.enqueue(root);
            while(fila.isEmpty() == false) {
                aux = fila.dequeue();
                if (aux.getLeft() != null) {
                    fila.enqueue(aux.getLeft());
                }
                if (aux.getRight() != null) {
                    fila.enqueue(aux.getRight());
                }
                System.out.println(aux.getInfo());
            }
        }
    }

    public void emOrdemNaoRecursivo() {
        Stack<ABBNode> pilha;
        ABBNode aux;
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia.");
        } else {
            pilha = new Stack<ABBNode>();
            aux = this.root;
            while(pilha.isEmpty() == false || aux != null) {
                while(aux != null) {
                    pilha.push(aux);
                    aux = aux.getLeft();
                }
                aux = pilha.pop();
                System.out.println(aux.getInfo());
                aux = aux.getRight();
            }
        }
    }

    public void preOrdemNaoRecursivo() {
        Stack<ABBNode> pilha;
        ABBNode aux;
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia.");
        } else {
            pilha = new Stack<ABBNode>();
            aux = this.root;
            while(pilha.isEmpty() == false || aux != null) {
                while(aux != null) {
                    System.out.println(aux.getInfo());
                    pilha.push(aux);
                    aux = aux.getLeft();
                }
                aux = pilha.pop();
                aux = aux.getRight();
            }
        }
    }

    public int contarNaoRecursiva() {
        Stack<ABBNode> pilha;
        ABBNode aux;
        int cont = 0;
        if (this.isEmpty() == true) {
            return 0;
        } else {
            pilha = new Stack<ABBNode>();
            aux = this.root;
            while(pilha.isEmpty() == false || aux != null) {
                while(aux != null) {
                    cont++;
                    pilha.push(aux);
                    aux = aux.getLeft();
                }
                aux = pilha.pop();
                aux = aux.getRight();
            }
            return cont;
        }
    }

    public int contarRecursiva() {
        if (this.isEmpty() == true) {
            return 0;
        } else {
            int cont = 0;
            cont = this.percorrerContando(root);
            return cont;
        }
    }

    private int percorrerContando(ABBNode r) {
        if (r == null) {
            return 0;
        }
        // Conta o nó atual + nós à esquerda + nós à direita
        return 1 + percorrerContando(r.getLeft()) + percorrerContando(r.getRight());
    }

    public int contarFolhasNaoRecursiva() {
        Stack<ABBNode> pilha;
        ABBNode aux;
        int cont = 0;
        if (this.isEmpty() == true) {
            return 0;
        } else {
            pilha = new Stack<ABBNode>();
            aux = this.root;
            while(pilha.isEmpty() == false || aux != null) {
                while(aux != null) {
                    if (aux.getLeft() == null && aux.getRight() == null) {
                        cont++;
                    }
                    pilha.push(aux);
                    aux = aux.getLeft();
                }
                aux = pilha.pop();
                aux = aux.getRight();
            }
            return cont;
        }
    }

    public int contarFolhasRecursiva() {
        if (this.isEmpty() == true) {
            return 0;
        } else {
            int cont = 0;
            cont = this.percorrerContandoFolhas(root);
            return cont;
        }
    }

    private int percorrerContandoFolhas(ABBNode r) {
        if (r == null) {
            return 0;
        }
        if (r.getLeft() == null && r.getRight() == null) {
            return 1;
        }
        int folhasEsquerda = percorrerContandoFolhas(r.getLeft());
        int folhasDireita = percorrerContandoFolhas(r.getRight());

        return folhasEsquerda + folhasDireita;
    }

    public int contarNaoTerminaisNaoRecursiva() {
        Stack<ABBNode> pilha;
        ABBNode aux;
        int cont = 0;
        if (this.isEmpty() == true) {
            return 0;
        } else {
            pilha = new Stack<ABBNode>();
            aux = this.root;
            while(pilha.isEmpty() == false || aux != null) {
                while(aux != null) {
                    if (aux.getLeft() != null || aux.getRight() != null) {
                        cont++;
                    }
                    pilha.push(aux);
                    aux = aux.getLeft();
                }
                aux = pilha.pop();
                aux = aux.getRight();
            }
            return cont;
        }
    }

    public int contarNaoTerminaisRecursiva() {
        if (this.isEmpty() == true) {
            return 0;
        } else {
            int cont = 0;
            cont = this.percorrerContandoNaoTerminais(root);
            return cont;
        }
    }

    private int percorrerContandoNaoTerminais(ABBNode r) {
        if (r == null) {
            return 0;
        }
        int aux = percorrerContandoNaoTerminais(r.getLeft()) + percorrerContandoNaoTerminais(r.getRight());

        if (r.getLeft() != null || r.getRight() != null) {
            return 1 + aux;
        } else {
            return 0;
        }
    }
}
