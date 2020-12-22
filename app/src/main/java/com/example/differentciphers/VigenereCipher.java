package com.example.differentciphers;

import java.util.HashMap;
import java.util.Map;

public class VigenereCipher {
    private char []arr;
    private Map<Character, Integer> hashMap;
    public VigenereCipher() {
        arr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        hashMap = new HashMap<Character, Integer>() {{
            put('a', 0);
            put('b', 1);
            put('c', 2);
            put('d', 3);
            put('e', 4);
            put('f', 5);
            put('g', 6);
            put('h', 7);
            put('i', 8);
            put('j', 9);
            put('k', 10);
            put('l', 11);
            put('m', 12);
            put('n', 13);
            put('o', 14);
            put('p', 15);
            put('q', 16);
            put('r', 17);
            put('s', 18);
            put('t', 19);
            put('u', 20);
            put('v', 21);
            put('w', 22);
            put('x', 23);
            put('y', 24);
            put('z', 25);

        }};
    }
    public String encrypt(String key,String plaintext ){
        String pl=plaintext;
        String keytext=key;
        StringBuilder ciphertext= new StringBuilder();
        for(int i=0;i<pl.length();i++){
            int temp= hashMap.get(pl.charAt(i));
            int temp2=(i%keytext.length());
            int temp3=hashMap.get(keytext.charAt(temp2));
            temp=(temp+temp3)%26;
            ciphertext.append(arr[temp]);
        }
        pl=ciphertext.toString();
        return pl;

    }
    public String decrypt(String key,String plaintext ){
        String pl=plaintext;
        String keytext=key;
        StringBuilder ciphertext= new StringBuilder();
        for(int i=0;i<pl.length();i++){
            int temp= hashMap.get(pl.charAt(i));
            int temp2=(i%keytext.length());
            int temp3=hashMap.get(keytext.charAt(temp2));
            temp=Math.abs((temp-(temp3-26)))%26;
            ciphertext.append(arr[temp]);
        }
        pl=ciphertext.toString();
        return pl;

    }
}
