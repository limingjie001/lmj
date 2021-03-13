package com.jvm;

public class StringTableTest {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ab" + "c";
        String str3 = new String("ab") + "c";
        String str4 = str3.intern();
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println("---------------");
        String strA="a";
        String strB="b";
        String strAB="ab";
        System.out.println(strA+strB==strAB);
    }
}
