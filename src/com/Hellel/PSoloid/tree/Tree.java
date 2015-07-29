package com.Hellel.PSoloid.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Tree implements Iterable<Object> {
    private Node root;

    public void add(Object object){
        Node node = new Node(object);
        add(node);
    }


    private void add(Node newNode){
        if(root==null){
            root = newNode;
        } else {
            add(root, newNode);
        }
    }

    private void add(Node addTo, Node newNode){
        Object addToObj = addTo.getData();
        Object newNodeObj = newNode.getData();
        Comparable addToComparable = (Comparable)addToObj;
        Comparable newNodeComparable = (Comparable)newNodeObj;
        if(addToComparable.compareTo(newNodeComparable)>0){
            if(addTo.getRight()==null){
                addTo.setLeft(newNode);
            }else {
                add(addTo.getRight(), newNode);
            }
        } else if(addToComparable.compareTo(newNodeComparable)<0){
            if(addTo.getRight()==null){
                addTo.setRight(newNode);
            }
            else {
                add(addTo.getRight(), newNode);
            }
        }

    }

    public Object getFirst (){
        Node getFirst=root;
            if( getFirst != null ) {
                while (getFirst.getLeft() != null) {
                    getFirst = getFirst.getLeft();
                }
            }
     return getFirst.getData();
        }



    public Object getLast (){
        Node getLast=root;
            if( getLast != null ) {
                while (getLast.getRight() != null) {
                    getLast = getLast.getRight();
                }
            }
     return getLast.getData();
        }

    @Override
    public Iterator<Object> iterator() {
        return new TreeIterator(root);
    }

    @Override
    public String toString() {
       String result = "";
        TreeIterator itr = new TreeIterator(root);


        while (itr.hasNext()) {
            result += itr.next() +", ";
        }
        return result;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
//        Node node = new Node(1);
        tree.add(5);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(9);
        tree.add(1);
        tree.add(6);
        tree.add(2);
        tree.add(7);

        System.out.println(tree.getFirst());
        System.out.println(tree.getLast());
        System.out.println(tree);
    }


    private static class Node {
        private Object data;
        private Node left;
        private Node right;

        public Node(Object data) {
            this.data = data;
        }

        public Node getLeft () {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Object getData() {
            return data;
        }
    }



    private class TreeIterator implements Iterator {

        Stack<Node> stack;

        public TreeIterator(Node root) {
            stack = new Stack<Node>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Object next() {
            Node node = stack.pop();
            Object result = node.getData();
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return result;
        }











//        private Node currentNode;
////        private Queue<Node> queue= new LinkedList<Node>();
//
//
//        public TreeIterator(Node root){
//            this.currentNode = root;
////            queue.add(currentNode);
//
//        }
//
//        public boolean hasNext(){
//            return currentNode != null;
//        }
//
//        public Object next() {
//            return next(currentNode);
//        }
//
//
//        public Object next(Node currentNode){
//
//            if (currentNode== null){
//                return null;
//            }
//            Object rez = currentNode.getData();
//            next(currentNode.getLeft());
//            next(currentNode.getRight());
//
//            return rez;
//        }



//            System.out.println();
////            sou
//            boolean hN = hasNext();
//
//            if(!hN) return null;
//            System.out.println();
//            if (!queue.isEmpty()) {
//                currentNode = queue.remove();
//
//                if (currentNode.getLeft() != null) {
//                    queue.add(currentNode.getLeft());
//                }
//                if (currentNode.getRight() != null) {
//                    queue.add(currentNode.getRight());
//                }
//
//                return currentNode;
//            }
//            return null;
        }
    }

