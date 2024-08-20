package BinarySearchTree;

class ABBNode {
    private ABBNode left;
    private Integer info;
    private ABBNode right;

    ABBNode(Integer value) {
        this.info = value;
    }
    

    
    Integer getInfo() {
        return this.info;
    }
    void setInfo(Integer value) {
        this.info = value;
    }

    ABBNode getLeft() {
        return this.left;
    }
    void setLeft(ABBNode newLeft) {
        this.left = newLeft;
    }

    ABBNode getRight() {
        return this.right;
    }
    void setRight(ABBNode newRight) {
        this.right = newRight;
    }
}
