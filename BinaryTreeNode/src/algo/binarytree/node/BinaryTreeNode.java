package algo.binarytree.node;

import algo.binarytree.node.interfaces.IBinaryTreeNode;

public class BinaryTreeNode<V> implements IBinaryTreeNode<V> {


    private V value;
    private boolean changed;
    private IBinaryTreeNode<V> parent;
    private IBinaryTreeNode<V> left;
    private IBinaryTreeNode<V> right;

    public BinaryTreeNode(){
        this.value = null;
        this.changed = false;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public void setValue(V o) {
        this.value = o;
        this.changed = true;
    }

    @Override
    public boolean isValueChanged() {
        return this.changed;
    }

    @Override
    public IBinaryTreeNode<V> getParent() {
        return this.parent;
    }

    @Override
    public IBinaryTreeNode<V> getLeftChild() {
        return this.left;
    }

    @Override
    public IBinaryTreeNode<V> getRightChild() {
        return this.right;
    }

    @Override
    public IBinaryTreeNode<V> getGrandParent() {
        IBinaryTreeNode<V> res;
        if(this.parent == null)
            res = null;
        else
            res = this.parent.getParent();
        return res;
    }

    @Override
    public IBinaryTreeNode<V> getUncle() {
        IBinaryTreeNode<V> res = null;
        if(this.getGrandParent() != null){
            if(this.getGrandParent().getLeftChild() == this.getParent()){
                res = this.getGrandParent().getRightChild();
            }else {
                res = this.getGrandParent().getLeftChild();
            }
        }
        return res;
    }

    @Override
    public void setParent(IBinaryTreeNode<V> p) {
        this.parent = p;
    }

    @Override
    public void setRightChild(IBinaryTreeNode<V> r) {
        this.right = r;
         r.setParent(this);
    }

    @Override
    public void setLeftChild(IBinaryTreeNode<V> l) {
        this.left = l;
        l.setParent(this);
    }

    @Override
    public boolean isSimplePoint() {
        boolean res = false;
        if(this.isDoublePoint() == false || this.isLeaf() == false)
            res = true;
        return res;
    }

    @Override
    public boolean isDoublePoint() {
        boolean res = false;
        if(this.left != null && this.right != null)
            res = true;
        return res;
    }

    @Override
    public boolean isLeaf() {
        boolean res = false;
        if(this.left == null && this.right == null)
            res = true;
        return res;
    }

    @Override
    public boolean isLeftChild() {
        boolean res = false;
        if(this.getParent() != null){
            if(this.getParent().getLeftChild() == this){
                res = true;
            }
        }
        return res;
    }

    @Override
    public boolean isRightChild() {
        boolean res = false;
        if(this.getParent() != null){
            if(this.getParent().getRightChild() == this){
                res = true;
            }
        }
        return res;
    }

    @Override
    public void rotateLeft() {
        IBinaryTreeNode<V> save = this.getRightChild();
        this.right.setParent(this.getParent());
        this.setRightChild(this.getLeftChild());
        save.setLeftChild(this);
    }

    @Override
    public void rotateRight() {
        IBinaryTreeNode<V> save = this.getLeftChild();
        this.left.setParent(this.getParent());
        this.setLeftChild(this.getRightChild());
        save.setRightChild(this);
    }

    @Override
    public String getPath() {
        String res = new String();
        IBinaryTreeNode<V> current = this;
        IBinaryTreeNode<V> child;

        while (current.getParent() != null){
            child = current;
            current = current.getParent();

            if(current.getLeftChild() == child){
                res += '0';
            }else {
                res += '1';
            }
        }

        res = new StringBuilder(res).reverse().toString();

        return res;
    }

    @Override
    public int getLevel() {
        IBinaryTreeNode<V> current = this;
        int res = 0;
        while (current.getParent() != null){
            current = current.getParent();
            res++;
        }
        return res;
    }
}
