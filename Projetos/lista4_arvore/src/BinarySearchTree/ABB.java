package BinarySearchTree;

import TADQueue.Queue;
import java.util.Stack;

public class ABB<T extends Comparable<T>> {
    private ABBNode<T> root;

    public boolean isEmpty() {
        if (this.root == null) {
            return true;
        } else {
            return false;
        }
    }

    // IMPLEMENTAR OS MÉTODOS:

    public void insert (T value) {
        ABBNode<T> novo, aux;
        int result;
        novo = new ABBNode<T>(value);

        if (this.isEmpty() == true) {
            this.root = novo;
            System.out.println("Inserção efetuada.");
        } else {
            aux = this.root;
            while (true) {
                result = value.compareTo(aux.getInfo());
                if (result < 0) {
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

    private ABBNode<T> buscar (T value) {

        ABBNode<T> aux;
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

    public T buscarObjeto (T value) {
        ABBNode<T> aux = buscar(value);
        if (aux == null) {
            return null;
        } else {
            return aux.getInfo();
        }
    }

    public void emOrdem() {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia.");
        } else {
            this.percorrerEmOrdem(root);
        }
    }

    private void percorrerEmOrdem(ABBNode<T> r) {
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

    private void percorrerPreOrdem(ABBNode<T> r) {
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

    private void percorrerPosOrdem(ABBNode<T> r) {
        if (r != null) {
            percorrerPosOrdem(r.getLeft());
            percorrerPosOrdem(r.getRight());
            System.out.println(r.getInfo());
        }
    }

    public void passeioPorNivel() {
        Queue<ABBNode<T>> fila;
        ABBNode<T> aux;
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia.");
        } else {
            fila = new Queue<ABBNode<T>>();
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

    public void remover(T value) {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia.");
        } else {
            this.root = this.removeNode(this.root, value);
        }
    }

    private ABBNode<T> removeNode (ABBNode<T> r, T value) {
        if (r != null) {
            int result = value.compareTo(r.getInfo());
            if (result == 0) {
                if (r.getLeft() == null && r.getRight() == null) {
                    r = null;
                } 
                else if (r.getLeft() == null) {
                    r = r.getRight();
                } 
                else if (r.getRight() == null) {
                    r = r.getLeft();
                } 
                else {
                    ABBNode<T> pai, filho;
                    pai = r;
                    filho = pai.getLeft();
                    if (filho.getRight() != null) {
                        while(filho.getRight() != null) {
                            pai = filho;
                            filho = filho.getRight();
                        }
                        pai.setRight(filho.getLeft());                        
                    }
                    else {
                        pai.setLeft(filho.getLeft());
                    }
                    r.setInfo(filho.getInfo());
                }
            } 
            else if (result < 0) {
                r.setLeft(removeNode(r.getLeft(), value));
            } 
            else {
                r.setRight(removeNode(r.getRight(), value));
            }
        }
        return r;
    }

    public int encontrarAltura() {
        if (this.isEmpty() == true) {
            return -1;
        } else {
            ABBNode<T> aux = this.root;
            return this.findHeight(aux);
        }
    }

    private int findHeight(ABBNode<T> r) {
        if (r == null) {
            return -1;
        }
        int left = findHeight(r.getLeft());
        int right = findHeight(r.getRight());
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    public void removerNaoRecursivo(T value) {
        ABBNode<T> temp1 = this.root;
        ABBNode<T> temp2 = null;
        int result;
        
        if (this.isEmpty()) {
            System.out.println("Árvore vazia.");
            return;
        }
    
        while (temp1 != null) {
            result = value.compareTo(temp1.getInfo());
            
            if (result == 0) {
                // Caso 1: O nó a ser removido não tem filhos
                if (temp1.getLeft() == null && temp1.getRight() == null) {
                    if (temp2 == null) {
                        this.root = null; // Nó raiz sendo removido
                    } else if (temp2.getLeft() == temp1) {
                        temp2.setLeft(null);
                    } else {
                        temp2.setRight(null);
                    }
                }
                // Caso 2: O nó a ser removido tem apenas um filho
                else if (temp1.getLeft() == null) {
                    if (temp2 == null) {
                        this.root = temp1.getRight(); // Nó raiz sendo removido
                    } else if (temp2.getLeft() == temp1) {
                        temp2.setLeft(temp1.getRight());
                    } else {
                        temp2.setRight(temp1.getRight());
                    }
                } else if (temp1.getRight() == null) {
                    if (temp2 == null) {
                        this.root = temp1.getLeft(); // Nó raiz sendo removido
                    } else if (temp2.getLeft() == temp1) {
                        temp2.setLeft(temp1.getLeft());
                    } else {
                        temp2.setRight(temp1.getLeft());
                    }
                }
                // Caso 3: O nó a ser removido tem dois filhos
                else {
                    ABBNode<T> pai = temp1;
                    ABBNode<T> filho = pai.getLeft();
    
                    if (filho.getRight() != null) {
                        while (filho.getRight() != null) {
                            pai = filho;
                            filho = filho.getRight();
                        }
                        pai.setRight(filho.getLeft());
                    } else {
                        pai.setLeft(filho.getLeft());
                    }
                    temp1.setInfo(filho.getInfo());
                }
                System.out.println("Remoção efetuada.");
                return;
            } else if (result < 0) {
                temp2 = temp1;
                temp1 = temp1.getLeft();
            } else {
                temp2 = temp1;
                temp1 = temp1.getRight();
            }
        }
    
        System.out.println("Valor não encontrado.");
    }

    public int frequencia(T value) {
        Stack<ABBNode<T>> pilha;
        ABBNode<T> aux, primeiraOcorrencia;
        int cont = 0;
        if (this.isEmpty() == true) {
            return 0;
        } else {
            pilha = new Stack<ABBNode<T>>();
            primeiraOcorrencia = buscar(value); // Encontra a primeira ocorrência do valor
            aux = primeiraOcorrencia;
            if (aux == null) {
                return 0;
            }
            while(pilha.isEmpty() == false || aux != null) {
                while(aux != null) {
                    pilha.push(aux);
                    aux = aux.getRight(); // Percorre apenas a subárvore direita
                }
                aux = pilha.pop();
                if (aux.getInfo().compareTo(value) == 0) {
                    cont++;
                }
                if (aux == primeiraOcorrencia) { 
                    // Se chegar na primeira ocorrência, para
                    // Pois não precisa percorrer a subárvore esquerda
                    // Repetidos estão apenas na subárvore DIREITA
                    break;
                }
                aux = aux.getLeft();
            }
            return cont;
        }
    }



}
