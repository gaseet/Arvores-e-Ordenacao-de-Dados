package AVL;

class AVLNode<T extends Comparable<T>> {
    private AVLNode<T> left;
    private T info;
    private AVLNode<T> right;
    private int fatBal;

    AVLNode(T value) {
        this.info = value;
    }
    

    
    T getInfo() {
        return this.info;
    }
    void setInfo(T value) {
        this.info = value;
    }

    AVLNode<T> getLeft() {
        return this.left;
    }
    void setLeft(AVLNode<T> newLeft) {
        this.left = newLeft;
    }

    AVLNode<T> getRight() {
        return this.right;
    }
    void setRight(AVLNode<T> newRight) {
        this.right = newRight;
    }

    int getFatBal() {
        return this.fatBal;
    }
    void setFatBal(int newFatBal) {
        this.fatBal = newFatBal;
    }
}
