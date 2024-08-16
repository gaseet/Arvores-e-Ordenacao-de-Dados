package packageABB;

class ABBNode {
    private ABBNode esq;
    private Integer info;
    private ABBNode dir;

    ABBNode(Integer value) {
        this.info = value;
    }
    

    
    Integer getInfo() {
        return this.info;
    }
    void setInfo(Integer value) {
        this.info = value;
    }

    ABBNode getEsq() {
        return this.esq;
    }
    void setEsq(ABBNode novoEsq) {
        this.esq = novoEsq;
    }

    ABBNode getDir() {
        return this.dir;
    }
    void setDir(ABBNode novoDir) {
        this.dir = novoDir;
    }
}
