package com.company;

public class Main {

    public static void main(String[] args) {

        char[] c = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
        MyString m = new MyString(c);

        //System.out.println(m.length());

        //System.out.println(m.indexOf('r'));           // 8
        //System.out.println(m.isEmpty());              // false
        //System.out.println(m.sameCharCount('o'));     // 2
        //System.out.println(m.charAt(6));              // 'W'
        //System.out.println(m.contains(' '));          // true
        /*
        int[] indexes = m.indexesOf('l');               // [2,3,9]
        for (int i = 0; i < indexes.length; i++){
            System.out.println(indexes[i]);
        }
        */
        //m.print();
        //m.subString(3,8).print();
        //m.replace('l', '*').print();
        //m.subString(4).print();
        MyString arr = m.split(' ');

    }

}
