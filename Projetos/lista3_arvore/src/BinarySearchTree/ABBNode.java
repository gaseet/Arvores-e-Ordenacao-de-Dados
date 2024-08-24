package BinarySearchTree;

class ABBNode<T> {
    private ABBNode<T> left;
    private T info;
    private ABBNode<T> right;

    ABBNode(T value) {
        this.info = value;
    }
    

    
    T getInfo() {
        return this.info;
    }
    void setInfo(T value) {
        this.info = value;
    }

    ABBNode<T> getLeft() {
        return this.left;
    }
    void setLeft(ABBNode<T> newLeft) {
        this.left = newLeft;
    }

    ABBNode<T> getRight() {
        return this.right;
    }
    void setRight(ABBNode<T> newRight) {
        this.right = newRight;
    }
}
