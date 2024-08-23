package TADStack;

public class Stack<T> {
    private StackNode<T> topo;


    public Stack() {
        this.topo = null;
    }

    public boolean isEmpty() {
        if (this.topo == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return false;
    }

    public T top() {
        return this.topo.getInfo();
    }

    public void push(T item) {
        StackNode<T> newNode = new StackNode<T>(item);
        newNode.setProx(this.topo);
        this.topo = newNode;
    }

    public T pop() {
        StackNode<T> aux = this.topo;
        this.topo = aux.getProx();
        return aux.getInfo();
    }
}
