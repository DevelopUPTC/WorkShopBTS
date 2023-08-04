package logic;

import org.w3c.dom.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTree <T>{
    private Comparator<T> comparator;

    private List<T> list;

    private TreeNode<T> root;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }

    public boolean isEmpty(){

        return root == null;
    }

    public void addNode( T info ){
        if( isEmpty()){
            root = new TreeNode<>(info);
        }else{
            TreeNode<T> aux = root;
            TreeNode<T> ant = null;
            while ( aux != null ){
                ant = aux;
                aux = comparator.compare(info,aux.getInfo()) < 0 ? aux.getLeft() : aux.getRigth();
            }
            if( comparator.compare( info, ant.getInfo() ) < 0 ){
                ant.setLeft( new TreeNode<>( info ) );
            }else{
                ant.setRigth( new TreeNode<>( info ) );
            }
        }
    }

    public List<T> listPresort(){
        list = new ArrayList<>();

        presort(root);

        return list;
    }

    private void presort(TreeNode<T> node) {
        if( node != null ){
            list.add( node.getInfo( ) );
            presort( node.getLeft());
            presort( node.getRigth());
        }
    }

    public List<T> lisAmplitudeDown( ){
        list = new ArrayList<>();
        ArrayDeque<TreeNode<T>> tail = new ArrayDeque<>();
        tail.add( root );
        while( !tail.isEmpty( ) ){
            TreeNode<T> aux = tail.poll();
            if( aux.getLeft() != null ){
                tail.add( aux.getLeft( ) );
            }
            if( aux.getRigth() != null ){
                tail.add( aux.getRigth());
            }

            list.add( aux.getInfo( ) );
        }

        return list;
    }

    public TreeNode<T> findNode(T node){

        return null;
    }

    public int heightTree(){

        return 0;
    }

    public int heightNode( TreeNode<T> node){

        return 0;
    }

    private int height ( TreeNode<T> node ){

        return 0;
    }

    public int weightTree(){

        return 0;
    }

    private int weight( TreeNode<T> node){

        return 0;
    }
    public int levelNode( TreeNode<T> node){

        return 0;
    }

    public boolean isLeaf( TreeNode<T> node){

        return false;
    }

    public int gradeNode( TreeNode<T> node ){

        return 0;
    }

    public TreeNode<T> findFather( TreeNode<T> node ){

        return null;
    }

    public T deleteNode( TreeNode<T> node ){

        return null;
    }

    private T deleteLeaf( TreeNode<T> node ){

        return node.getInfo();
    }

    private T deleteWithSon(TreeNode<T> node){

        return node.getInfo();
    }

    private T deleteWithSons(TreeNode<T> node){

        return node.getInfo();
    }

}
