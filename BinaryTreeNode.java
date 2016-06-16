package cse214homework3;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ritwik Banerjee
 */
public class BinaryTreeNode<T> {

    private T data;
    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> right;
    private BinaryTreeNode<T> left;

    public BinaryTreeNode(T data, BinaryTreeNode<T> parent,
            BinaryTreeNode<T> right, BinaryTreeNode<T> left) {
        this.data = data;
        this.parent = parent;
        this.right = right;
        this.left = left;
    }

    public BinaryTreeNode(T data) {
        this(data, null, null, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BinaryTreeNode)) {
            return false;
        }
        BinaryTreeNode<?> that = (BinaryTreeNode<?>) o;
        if (!data.equals(that.data)) {
            return false;
        }
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) {
            return false;
        }
        //noinspection SimplifiableIfStatement
        if (right != null ? !right.equals(that.right) : that.right != null) {
            return false;
        }
        return left != null ? left.equals(that.left) : that.left == null;
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "'-- " : "|-- ") + data.toString());
        List<BinaryTreeNode<T>> children = Arrays.asList(left, right);
        for (int i = 0; i < children.size() - 1; i++) {
            if (children.get(i) != null) {
                children.get(i).print(prefix + (isTail ? " " : "| "), false);
            }
        }
        if (children.size() > 0 && children.get(children.size() - 1) != null) {
            children.get(children.size() - 1).print(prefix + (isTail ? " " : "| "), true);
        }
    }

    public void print() {
        print("", true);
    }
}
