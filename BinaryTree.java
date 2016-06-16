package cse214homework3;
/**
 *
 * @author Jack Smith
 * ID: 110366081;
 * 
 */
public interface BinaryTree<T> {
    
    public void add(T data);
    
    public void remove(T data);
    
    public BinaryTreeNode<T> find(T data);
    
    public void print();
    
}
