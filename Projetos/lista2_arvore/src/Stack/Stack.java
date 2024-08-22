package Stack;

public class Stack<T> {
    private StackNode<T> first;


    public Stack() {
        this.first = null;
    }

    public boolean isEmpty() {
        if (this.first == null) {
            return true;
        } else {
            return false;
        }
    }

    public void push(T item) {
        StackNode<T> newNode = new StackNode<T>(item);

        if (this.isEmpty() == true) {
            this.first = newNode;
        } else {
            newNode.setProx(this.first);
            this.first = newNode;
        }
    }

    public T pop() {
        StackNode<T> aux;
        if(this.isEmpty() == true) {
            return null;
        } else {
            aux = this.first;
            this.first = this.first.getProx();
            return aux.getInfo();
        }
    }
}
