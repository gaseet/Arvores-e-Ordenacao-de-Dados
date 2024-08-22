package Queue;

public class QueueNode<T> {
    private T info;
    private QueueNode<T> prox;

    

    public QueueNode(T info) {
        this.info = info;
        this.prox = null;
    }

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public QueueNode<T> getProx() {
        return prox;
    }
    public void setProx(QueueNode<T> prox) {
        this.prox = prox;
    }
}
