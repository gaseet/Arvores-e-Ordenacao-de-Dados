package packageABB;

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
                    if (aux.getEsq() == null) {
                        aux.setEsq(novo);
                        System.out.println("Inserção efetuada.");
                        return;
                    } else {
                        aux = aux.getEsq();
                    }
                } else {
                    if (aux.getDir() == null) {
                        aux.setDir(novo);
                        System.out.println("Inserção efetuada.");
                        return;
                    } else {
                        aux = aux.getDir();
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
                    temp1 = temp1.getEsq();
                } else {
                    temp2 = temp1;
                    temp1 = temp1.getDir();
                }
            } while (temp1 != null);

            if (result < 0) {
                temp2.setEsq(novo);
            } else {
                temp2.setDir(novo);
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
                    if (aux.getEsq() == null) {
                        return null;
                    } else {
                        aux = aux.getEsq();
                    }
                } else {
                    if (aux.getDir() == null) {
                        return null;
                    } else {
                        aux = aux.getDir();
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
            while (aux.getEsq() != null) {
                aux = aux.getEsq();
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
            while (aux.getDir() != null) {
                aux = aux.getDir();
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
}
