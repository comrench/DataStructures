package com.company.ds;

public class BasicLinkedList<X> {
    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList(){
        first = null;
        last = null;
        nodeCount = 0;
    }

    public void add(X item){
        Node node = new Node(item);
        if(first == null){
            first = node;
            last = first;
        }else {
            last.setNextNode(node);
            last = node;
        }
        nodeCount++;
    }

    public X remove(){
        if(first == null){
            throw new IllegalStateException("Linked list is empty so can't remove item");
        }
        X temp = first.getNodeItem();
        first = first.getNextNode();
        nodeCount--;
        return temp;
    }

    public void insert(X item, int position){
        if(size() < position){
            throw new IllegalStateException("The linkedList is smaller than the position specified");
        }
        Node currentNode = first;
        for(int i=0;i<position && currentNode != null;i++){
            currentNode = currentNode.getNextNode();
        }
        Node nextNode = currentNode.getNextNode();
        Node node = new Node(item);
        currentNode.setNextNode(node);
        node.setNextNode(nextNode);
        nodeCount++;
    }

    public X removeAt(int position){
        if(size() < position){
            throw new IllegalStateException("The linkedList is smaller than the position specified");
        }
        Node currentNode = first;
        Node prevNode = first;
        for(int i=0;i<position && currentNode != null;i++){
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        X nodeItem = currentNode.getNodeItem();
        prevNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;
    }

    public X get(int position){
        if(size() < position){
            throw new IllegalStateException("The linkedList is smaller than the position specified");
        }
        Node currentNode = first;
        for(int i=0;i<size() && currentNode != null;i++){
            if(i== position){
                return currentNode.getNodeItem();
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    public int find(X item){
        if(first == null){
            throw new IllegalStateException("The linkedList is smaller than the position specified");
        }
        Node currentNode = first;
        for(int i=0;i<size() && currentNode != null;i++){
            if(currentNode.getNodeItem().equals(item)){
                return i;
            }
            currentNode = currentNode.getNextNode();
        }
        return -1;
    }

    public String toString(){
        StringBuffer contents = new StringBuffer();
        Node curNode = first;

        while(curNode != null){
            contents.append(curNode.getNodeItem());
            curNode = curNode.getNextNode();
            if(curNode != null){
                contents.append(", ");
            }
        }
        return contents.toString();
    }

    public int size(){
        return nodeCount;
    }

    private class Node {
        private Node nextNode;
        private X nodeItem;

        public Node(X item){
            this.nextNode = null;
            this.nodeItem = item;
        }

        public void setNextNode(Node nextNode){
            this.nextNode = nextNode;
        }

        public Node getNextNode(){
            return nextNode;
        }

        public X getNodeItem(){
            return nodeItem;
        }
    }
}
