package cse214homework3;

/**
 *
 * @author Jack Smith ID: 110366081
 * @param <T>
 *
 */
public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {

    private BinaryTreeNode<T> root;

    @Override
    public void add(T data) {

        BinaryTreeNode<T> temp = new BinaryTreeNode(data);
        root = addItem(root, temp);

    }

    private BinaryTreeNode<T> addItem(BinaryTreeNode<T> parent, BinaryTreeNode<T> child) {
        
        if (parent == null) {
            child.setParent(null);
            return child;
        }else if(parent.getData() == null){
            parent.setData(child.getData());
        } else if (child.getData().compareTo(parent.getData()) > 0) {
            parent.setRight(addItem(parent.getRight(), child));
        } else if (child.getData().compareTo(parent.getData()) < 0) {
            parent.setLeft(addItem(parent.getLeft(), child));
        }
        
        child.setParent(parent);
        return parent;
    }

    @Override
    public void remove(T data) {
        BinaryTreeNode<T> node;
        if(find(data) != null)
            node = find(data); //the reference of the node to be deleted
        else{
            System.out.println(data.toString() + " was not found in the tree.");
            return;
        }
        
        if(node.getParent() == null){
            if(node.getRight() == null)
                node.setData(null);
            else{
                node.setData(node.getRight().getData());
                node.setRight(null);
            }
        }else if(node.getLeft() == null && node.getRight() == null){ //CASE 1: node has no children
            if(node.getData().compareTo(node.getParent().getData()) > 0)
                node.getParent().setRight(null);
            else
                node.getParent().setLeft(null);
            node.setParent(null);
        }else if(node.getLeft() != null && node.getRight() == null){ // CASE 2: node has a left child but no right
            if(node.getData().compareTo(node.getParent().getData()) > 0)
                node.getParent().setRight(node.getLeft());
            else
                node.getParent().setLeft(node.getLeft());
            node.setParent(null);
        }else if(node.getLeft() == null && node.getRight() != null){ // CASE 3: node has a right child but no left
            if(node.getData().compareTo(node.getParent().getData()) > 0)
                node.getParent().setRight(node.getRight());
            else
                node.getParent().setLeft(node.getRight());
            node.setParent(null);
        }else if(node.getLeft() != null && node.getRight() != null){  //CASE 4: node has two children
            BinaryTreeNode<T> successor = findSuccessor(node.getRight());
            node.setData(successor.getData());
            successor.getParent().setRight(null);
        }
    }
    
    public BinaryTreeNode<T> findSuccessor(BinaryTreeNode<T> node){
        if(node == null)
            return node;
        else if(node.getRight() == null && node.getLeft() == null)
            return node;
        else
            return findSuccessor(node.getLeft());  
    }

    @Override
    public BinaryTreeNode<T> find(T data) {
        return findItem(data, root);
    }

    public BinaryTreeNode<T> findItem(T data, BinaryTreeNode<T> node) {
        if(data.compareTo(node.getData()) == 0)
            return node;
        else if (data.compareTo(node.getData()) < 0 && node.getLeft() != null)
            return findItem(data, node.getLeft());
        else if(data.compareTo(node.getData()) > 0 && node.getRight() != null)
            return findItem(data, node.getRight());
        else
            return null;
    }

    @Override
    public void print() {
        if(root.getData() == null)
            System.out.println("There is nothing to print.");
        else
            root.print();
    }

}
