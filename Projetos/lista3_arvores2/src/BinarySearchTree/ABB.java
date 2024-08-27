package BinarySearchTree;

import TADQueue.Queue;

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
                if (result == 0) {
                    System.out.println("Inserção não permitida. Valor já presente.");
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
}
