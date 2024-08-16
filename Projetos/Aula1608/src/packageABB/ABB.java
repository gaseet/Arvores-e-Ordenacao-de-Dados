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

    /*public ABBNode buscar (Integer value) {

    }*/
}
