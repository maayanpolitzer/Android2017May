package com.company;

/**
 * Created by hackeru on 6/26/2017.
 */
public class DynamicArray {

    private String[] arr;
    private int counter;
    private int growFactor = 2;

    public DynamicArray(){
        arr = new String[10];
    }

    public void add(String str){
        if (counter == arr.length){
            makeRoom();
        }
        arr[counter++] = str;
    }

    public boolean remove(String str){
        /*
        for (int i = 0; i < counter; i++){
            if (arr[i] == str){
                for (int j = i; j < counter-1; j++){
                    arr[j] = arr[j+1];
                }
                counter--;
                return true;
            }
        }
        return false;
        */
        boolean startMove = false;
        for (int i = 0; i < counter; i++){
            if (arr[i] == str){
                startMove = true;
                counter--;
            }
            if (startMove == true && i < counter){
                arr[i] = arr[i+1];
            }
        }
        return startMove;
    }

    public boolean add(int index, String str) {
        if (index >= counter || index < 0){
            return false;
        }
        counter++;
        for (int i = counter - 1; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = str;
        return true;
    }

    public boolean set(int index, String str){
        if (index >= 0 && index < counter){
            arr[index] = str;
            return true;
        }
        return false;
    }

    public boolean contains(String str){
        for(int i = 0; i < counter; i++){
            if (arr[i] == str){
                return true;
            }
        }
        return false;
    }

    public String get(int index){
        if (index >= 0 && index < counter){
            return arr[index];
        }
        return null;
    }

    public DynamicArray subList(int start, int end){
        if(start < 0 || start >= end || end > counter){
            return null;
        }
        DynamicArray d = new DynamicArray();
        for (int i = start; i < end; i++){
            d.add(arr[i]);
        }
        return d;
    }

    public boolean sameAs(DynamicArray rami){
        if (rami == this){
            return true;
        }
        if (rami.size() != counter){
            return false;
        }
        for (int i = 0; i < counter; i++){
            if (rami.get(i) != arr[i]){
                return false;
            }
        }
        return true;
    }

    public int size(){
        return counter;
    }

    private void makeRoom(){
        String[] temp = new String[arr.length * growFactor];
        for (int i = 0; i < counter; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void print(){
        System.out.print("[");
        for (int i = 0; i < counter; i++){
            System.out.print(arr[i]);
            if (i < counter - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
