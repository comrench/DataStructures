package com.company.ds;

public class BasicBinaryTree <X extends Comparable<X>>{
    private Node root;
    private int size;

    public BasicBinaryTree() {
        this.root = null;
    }

    public int size(){
        return size;
    }

    public void add(X item){
        Node node = new Node(item);
        if(root == null){
            this.root = node;
            System.out.println("Set root " + node.getItem());
            this.size++;
        }else{
            insert(this.root, node);
        }
    }

    public boolean contains(X item){
        Node currentNode = getNode(item);

        if(currentNode == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean delete(X item){
        boolean deleted = false;

        if(this.root == null){
            return false;
        }

        Node currentNode = getNode(item);
        if(currentNode != null){
            if(currentNode.getLeft() == null && currentNode.getRight() == null){
                unlink(currentNode, null);
                deleted = true;
            } else if(currentNode.getLeft() == null && currentNode.getRight() != null){
                unlink(currentNode, currentNode.getRight());
                deleted = true;
            }else if(currentNode.getLeft() != null && currentNode.getRight() == null){
                unlink(currentNode, currentNode.getLeft());
                deleted = true;
            } else{
                Node child = currentNode.getLeft();
                while(child.getRight() != null && child.getLeft() != null){
                    child = child.getRight();
                }

                child.getParent().setRight(null);

                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());

                unlink(currentNode, child);
                deleted = true;
            }
        }

        if(deleted){
            this.size--;
        }

        return deleted;
    }

    private void unlink(Node currentNode, Node newNode){
        if(currentNode == this.root){
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
        } else if (currentNode.getParent().getRight() == currentNode){
            currentNode.getParent().setRight(newNode);
        } else {
            currentNode.getParent().setLeft(newNode);
        }
    }

    /** Non recursive implementation for finding the item */
    private Node getNode(X item){
        Node currentNode = this.root;

        while(currentNode != null){
            int val = item.compareTo(currentNode.getItem());

            if(val == 0){
                return currentNode;
            }else if(val < 0){
                currentNode = currentNode.getLeft();
            }else{
                currentNode = currentNode.getRight();
            }
        }

        return null;
    }

    /** Recursive implementation for finding the node*/
//    private boolean find(Node parent, X item){
//        if(item.compareTo(parent.getItem()) == 0){
//            return true;
//        } else if(item.compareTo(parent.getItem()) < 0){
//            if(parent.getLeft() == null){
//                return false;
//            }else{
//                find(parent.getLeft(), item);
//            }
//        }else(item.compareTo(parent.getItem()) > 0){
//            if(parent.getRight() == null){
//                return false;
//            }else{
//                find(parent.getRight(), item);
//            }
//        }
//        return false;
//    }

    private void insert(Node parent, Node child){
        if(child.getItem().compareTo(parent.getItem()) < 0){
            if(parent.getLeft() == null){
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            } else{
                insert(parent.getLeft(), child);
            }
        }else if(child.getItem().compareTo(parent.getItem()) > 0){
            if(parent.getRight() == null){
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            }else{
                insert(parent.getRight(), child);
            }
        }

        // if parent and child happen to be equal, we don't do anything
    }

    private class Node{
        private Node left;
        private Node right;
        private Node parent;
        private X item;

        public Node(X item) {
            this.item = item;
            this.left = null;
            this.right = null;
            this.parent = null;
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

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }
    }
}
