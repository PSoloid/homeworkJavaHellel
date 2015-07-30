package com.Hellel.PSoloid.tree;


        import java.util.*;


public class Tree implements Iterable<Object> {
    private Node root;

    public void add(Object object) {
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




    public void remove(Object rem) {

//        TREE* Remove(TREE *root, int x)
//         TREE *t;
        TreeIterator itr = new TreeIterator(root);
            if (root == null) {
                System.out.println("Tree is empty");
                return;
            }
            Node currentNode = itr.next();
            if (rem.equals(currentNode.getData())) {
                if (currentNode.getLeft() == null) {
                   currentNode = currentNode.getRight();
                }
                currentNode = currentNode.getLeft();
                while(t->right) t = t->right;
                t->right = root->right;
                return root->left;
            }
            if (x <= root->inf)
                root->left = Remove(root->left, x);
            else
                root->right = Remove(root->right, x);
            return root;



    }
//        Node<T> curr, replacement;
//        Node<T> newItem = new Node<T>(t);
//
//        lock.lock();
//        curr = tree;
//
//        try {
//
//            if (curr.item != null) {
//
//                while (curr.compareTo(newItem) != 0) {
//                    if (curr.compareTo(newItem) == 1) {
//                        curr = curr.next;
//                    }
//                    else {
//                        curr = curr.prev;
//                    }
//                }
//
//                if (curr.next == null && curr.prev == null) {
//                    curr = null;
//                }
//                else if (curr.next == null) {
//                    curr.item = curr.prev.item;
//                    curr.prev = null;
//                }
//                else if (curr.prev == null) {
//                    curr.item = curr.next.item;
//                    curr.next = null;
//                }
//                else {
//                    replacement = curr.next;
//
//                    if (replacement.prev != null && replacement.next != null) {
//                        replacement = replacement.prev;
//                        Node<T> link = curr.next;
//
//                        while (replacement.prev != null) {
//                            link = replacement;
//                            replacement = replacement.prev;
//                        }
//
//                        curr.item = replacement.item;
//
//                        if (replacement.next != null) {
//                            link.prev = replacement.next;
//                        } else {
//                            replacement = null;
//                        }
//
//                    }
//                    else if (replacement.next != null) {
//                        curr.item = replacement.item;
//                        curr.next = curr.next.next;
//                    } else {
//                        curr.item = replacement.item;
//                        curr.next = null;
//                    }
//
//                }
//
//
//            } catch (UnsupportedOperationException e) {
//                throw new UnsupportedOperationException();
//            } finally {
//                lock.unlock();
//            }
//        }

    public Object getFirst() {
        Node getFirst = root;
        if (getFirst != null) {
            while (getFirst.getLeft() != null) {
                getFirst = getFirst.getLeft();
            }
        }
        return getFirst.getData();
    }


    public Object getLast() {
        Node getLast = root;
        if (getLast != null) {
            while (getLast.getRight() != null) {
                getLast = getLast.getRight();
            }
        }
        return getLast.getData();
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
        Node node = new Node(1);
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

        public Object getData() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

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