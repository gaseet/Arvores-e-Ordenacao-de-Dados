package Queue;

public class Queue<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;


    public Queue() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        if (this.first == null && this.last == null) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(T item) {
        QueueNode<T> newNode = new QueueNode<T>(item);

        if (this.isEmpty() == true) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.setProx(newNode);
            this.last = newNode;
        }
    }

    public T dequeue() {
        QueueNode<T> aux;
        if(this.isEmpty() == true) {
            return null;
        } else {
            aux = this.first;
            this.first = this.first.getProx();
            if (this.first == null) {
                this.last = null;
            }
            return aux.getInfo();
        }
    }
}
