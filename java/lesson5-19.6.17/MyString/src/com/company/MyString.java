package com.company;

/**
 * Created by hackeru on 6/19/2017.
 */
public class MyString {

    private char[] chars;

    public MyString(char[] chars){
        this.chars = chars;
    }

   public int length(){
        return chars.length;
   }

   public int indexOf(char c){
       for(int i = 0; i < length(); i++){
           if (chars[i] == c){
               return i;
           }
       }
       return -1;
   }

   public boolean isEmpty(){
       return length() == 0;
       /*
       if(chars.length == 0){
           return true;
       }
       return false;
       */
   }

   public int sameCharCount(char c){
       int counter = 0;
       for (int i = 0; i < chars.length; i++){
           if (chars[i] == c){
               counter++;
           }
       }
       return counter;
   }

   public char charAt(int index){
       if (index >= 0 && index < chars.length){
           return chars[index];
       }
       return '@';
   }

   public boolean contains(char c){
       return indexOf(c) != -1;
   }

   public int[] indexesOf(char c){
       // create an array.
       int[] arr = new int[sameCharCount(c)];
       // insert data.
       int j = 0;
       for (int i = 0; i < chars.length; i++){
           if (chars[i] == c){
               arr[j] = i;
               j++;
           }
       }
       // return array.
       return arr;
   }

   public void print(){
       System.out.println(chars);
       /*
       for (int i = 0; i < chars.length; i++){
           System.out.print(chars[i]);
       }
       System.out.println();
       */
   }

   public MyString subString(int start, int end){
       if (start < 0 || end > chars.length || start > end){
           //return new MyString(new char[0]);
           return new MyString(new char[]{});
       }
       // create char array.
       char[] arr = new char[end-start];

       // insert chars to the array.

       for (int i = 0; i < arr.length; i++){
           arr[i] = chars[i + start];
       }
       /*
       for (int i = start; i < end; i++){
           arr[i - start] = chars[i];
       }
       */

       // return a new MyString object.
       return new MyString(arr);
   }

   public MyString replace(char oldChar, char newChar){
       char[] arr = new char[chars.length];
       for (int i = 0; i < arr.length; i++){
           //arr[i] = chars[i] == oldChar ? newChar : chars[i];
           if (chars[i] == oldChar){
               arr[i] = newChar;
           }else{
               arr[i] = chars[i];
           }
       }
       return new MyString(arr);
   }

   public MyString subString(int start){
       return subString(start, chars.length);
   }

}
