package com.Hellel.PSoloid.tree;


        import java.util.*;


public class Tree<T> implements Iterable<T> {
    private Node root;

    public void add(T object) {
        Node node = new Node(object);
        add(node);
    }


    private void add(Node newNode) {
        if (root == null) {
            root = newNode;
        }
        {
            add(root, newNode);
        }
    }

    private void add(Node addTo, Node newNode) {
        Object addToObj = addTo.getData();
        Object newNodeObj = newNode.getData();
        Comparable addToComparable = (Comparable) addToObj;
        Comparable newNodeComparable = (Comparable) newNodeObj;
        if (addToComparable.compareTo(newNodeComparable) > 0) {
            if (addTo.getRight() == null) {
                addTo.setLeft(newNode);
            } else {
                add(addTo.getRight(), newNode);
            }
        } else if (addToComparable.compareTo(newNodeComparable) < 0) {
            if (addTo.getRight() == null) {
                addTo.setRight(newNode);
            } else {
                add(addTo.getRight(), newNode);
            }
        }

    }

    public Node find(T data) {
        return find(root, data);
    }

    private Node find(Node current, T data){
        if (current == null)
           return null;


            if (current.getData().equals(data))
                return current;

            Object curToObj = current.getData();
            Comparable curComparable = (Comparable) curToObj;

            Object dataToObj = current.getData();
            Comparable dataComparable = (Comparable) dataToObj;

        return find(dataComparable.compareTo(curComparable) < 0 ? current.getLeft()
                : current.getRight(), data);
    }

    public void delete(T data) {
        root = delete(root, data);
    }

    private Node delete(Node startNode, T data) {
        Node element = find(startNode, data);
        if (element == null) return startNode;
        boolean hasParent = element.getParent() != null;

        try {
            Comparable parentComparable = (Comparable) element.getParent().getData();

            Comparable elementComparable = (Comparable) element.getData();

            boolean isLeft = hasParent && elementComparable.compareTo(parentComparable) < 0;
            if (element.getLeft() == null && element.getRight() == null) {
                if (hasParent) {
                    if (isLeft) {
                        element.getParent().setLeft(null);
                    } else {
                        element.getParent().setRight(null);
                    }
                }
            } else if (element.getLeft() != null && element.getRight() == null) {
                if (hasParent) {
                    if (isLeft) {
                        element.getParent().setLeft(element.getLeft());
                    } else {
                        element.getParent().setRight(element.getLeft());
                    }
                } else {
                    startNode = element.getLeft();
                }
            } else if (element.getLeft() == null && element.getRight() != null) {
                if (hasParent) {
                    if (isLeft) {
                        element.getParent().setLeft(element.getRight());
                    } else {
                        element.getParent().setRight(element.getRight());
                    }
                } else {
                    startNode = element.getRight();
                }
            } else {
                Node rightMin = getFirst(element.getRight());
                element.setData(rightMin.getData());
                return delete(rightMin, (T) rightMin.getData());
            }
            element = null;

        } catch (ClassCastException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();

        } catch (NullPointerException e) {
            System.err.println("Error 1 " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        return startNode;
    }

    public Node getFirst() {
        return getFirst(root);
    }


    public Node getFirst(Node getFirst) {
       try{
        if (getFirst != null) {
            while (getFirst.getLeft() != null) {
                getFirst = getFirst.getLeft();
            }
        }

       } catch (NullPointerException e) {
           System.err.println(e.getMessage());
           e.printStackTrace();
           return null;
       }
        return getFirst;
    }


    public Node getLast() {
        return getLast(root);
    }

    public Node getLast(Node getLast) {
        try {
        if (getLast != null) {
            while (getLast.getRight() != null) {
                getLast = getLast.getRight();
            }
        }
    } catch (NullPointerException e) {
        System.err.println("Error 1 " + e.getMessage());
        e.printStackTrace();
        return null;
    }
        return getLast;
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator(root);
    }


    @Override
    public String toString() {

        String result = "";
        TreeIterator itr = new TreeIterator(root);


        while (itr.hasNext()) {
            result += itr.next().getData() + ", ";
        }
        return result;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
//        Node node = new Node();
//        tree.add(5);
//        tree.add(4);
//        tree.add(8);
//        tree.add(3);
//        tree.add(9);
//        tree.add(1);
//        tree.add(6);
//        tree.add(2);
//        tree.add(7);

        tree.add("5");
        tree.add("4");
        tree.add("8");
        tree.add("3");
        tree.add("9");
        tree.add("1");
        tree.add("6");
        tree.add("2");
        tree.add("7");

        System.out.println(tree.getFirst());
        System.out.println(tree.getLast());
        System.out.println(tree);

        tree.delete("3");

        System.out.println(tree);
    }


    private static class Node<T> {
        private T data;
        private Node left;
        private Node right;
        private Node parent;

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node getLeft() {
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

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            return !(data != null ? !data.equals(node.data) : node.data != null);

        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
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

        public Node next() {
            Node node = stack.pop();
            Node result = node;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return result;
        }
    }
}