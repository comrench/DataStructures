package com.company.ds;

public class BasicQueue<X> {
    private X[] data;
    private int front;
    private int end;

    public BasicQueue(){
        this(1000);
    }

    public BasicQueue(int size){
        this.front = -1;
        this.end = -1;
        data = (X[])new Object[size];
    }

    public int size(){
        if(front == -1 && end == -1){
            return 0;
        }else{
            return end-front + 1;
        }
    }

    public void enQueue(X item){
        if((end+1)%data.length == front){
            throw new IllegalStateException("Queue is full");
        }else if(size() == 0){
            front++;
            end++;
            data[end]= item;
        }else {
            data[++end] = item;
        }
    }

    public X deQueue(){
        X item = null;
        if(size() == 0){
            throw new IllegalStateException("Can't deQueue because queue is empty");
        }else if (front == end){
            item = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        }else{
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;
    }

    public boolean contains(X item){
        if(size() == 0){
            return false;
        }
        for(int i=front;i<end;i++){
            if(item.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    public X access(int position){
        if(size() == 0 || position > size()){
            throw new IllegalStateException("No items found in the queue or position is greater than size of queue");
        }
        int trueIndex = 0;
        for(int i=front; i<end; i++){
            if(trueIndex == position){
                return data[i];
            }
            trueIndex++;
        }
        throw new IllegalStateException(("Could not get queue item at position: "+ position));
    }

}
