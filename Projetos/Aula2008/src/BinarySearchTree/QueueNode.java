package BinarySearchTree;

public class QueueNode {
    private ABBNode info;
    private QueueNode prox;

    

    public QueueNode(ABBNode info) {
        this.info = info;
        this.prox = null;
    }

    public ABBNode getInfo() {
        return info;
    }
    public void setInfo(ABBNode info) {
        this.info = info;
    }
    public QueueNode getProx() {
        return prox;
    }
    public void setProx(QueueNode prox) {
        this.prox = prox;
    }
}
