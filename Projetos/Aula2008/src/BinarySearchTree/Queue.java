package BinarySearchTree;

public class Queue {
    private QueueNode first;
    private QueueNode last;


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

    public void enqueue(ABBNode treeNode) {
        QueueNode newNode = new QueueNode(treeNode);

        if (this.isEmpty() == true) {
            newNode.setProx(null);
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.setProx(newNode);
            this.last = newNode;
        }
    }

    public ABBNode dequeue() {
        QueueNode aux;
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
