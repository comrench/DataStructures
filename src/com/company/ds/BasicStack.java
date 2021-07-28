package com.company.ds;

public class BasicStack<X> {
    private X [] data;
    private int stackPointer;

    public BasicStack(){
        data = (X[]) new Object[1000];
        stackPointer = 0;
    }

    public void push(X newItem){
        data[stackPointer++] = newItem;
    }

    public X pop(){
        if(stackPointer == 0){
            throw new IllegalStateException("No more items on the stack");
        }
        return data[--stackPointer];
    }

    public boolean contains(X item){
        for(int i=0; i<stackPointer; i++){
            if(data[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    public X access(X item){
        while(stackPointer > 0){
            X tmpItem = pop();
            if(item.equals(tmpItem)){
                return tmpItem;
            }
        }
        throw new IllegalArgumentException("Could not find the item on the stack: " + item);
    }

    public int size(){
        return stackPointer;
    }

}
