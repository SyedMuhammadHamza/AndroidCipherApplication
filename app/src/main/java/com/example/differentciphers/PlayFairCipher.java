package com.example.differentciphers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayFairCipher {
    char matrix[][] = new char[5][5];
    char matrix2d []=new char[25];
    public String encrypt(String key,String plaintext ) {
        //dict for rules relexation
        Map<Character, String> map = new HashMap<>();
        //start of making of matrix
        String str = key;
        String str2 = "abcdefghiklmnopqrstuvwxyz";
        String input = str + str2;
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if (!result.contains(String.valueOf(input.charAt(i)))) {
                result += String.valueOf(input.charAt(i));
            }
        }
        String str4 = result;
        char mat[][] = new char[5][5];
        int k = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                k++;
                mat[i][j] = str4.charAt(k);
                String Dkey = String.valueOf(i) + String.valueOf(j);

                map.put(str4.charAt(k), Dkey);
            }
        }
        matrix =mat;
        //start of pairing
        ArrayList<String> si = new ArrayList<>();
        String pt=plaintext;
        for(int i=0;i<pt.length()-1;i++){
            StringBuilder pair=new StringBuilder();
            for(int j=0;j<2;j++){
                if(j==0 && (pt.charAt(i)==pt.charAt(i+1))){
                    pair.append(pt.charAt(i));
                    pair.append('X');
                    i++;
                    break;
                }
                else{
                    pair.append(pt.charAt(i));
                    i++;
                }
            }
            String sPair=pair.toString();
            si.add(sPair);
            i--;
        }
        //rules transformation

        ArrayList<String> ciphertext = new ArrayList<>();
        for (int p = 0; p < si.size(); p++) {
            StringBuilder pair2=new StringBuilder();
            String s=si.get(p);
            String s1=map.get(s.charAt(0));
            String s2=map.get(s.charAt(1));
            if('X'==s.charAt(1)){
                pair2.append(s.charAt(0));
                pair2.append('X');
                String Pairtext=pair2.toString();
                ciphertext.add(Pairtext);
            }
            else{
                int row1=Character.getNumericValue(s1.charAt(0));
                int row2=Character.getNumericValue(s2.charAt(0));

                int col1=Character.getNumericValue(s1.charAt(1));
                int col2=Character.getNumericValue(s2.charAt(1));

                //rule 2 3 AND 4

                if(row1==row2){
                    col1++;
                    col2++;
                    if(col1>4){
                        col1=Math.abs(col1-5);
                    }
                    if(col2>4){
                        col2=Math.abs(col2-5);
                    }
                    pair2.append(mat[row1][col1]);
                    pair2.append(mat[row2][col2]);
                    String Pairtext=pair2.toString();
                    ciphertext.add(Pairtext);
                }
                else if(col1==col2){
                    row1++;
                    row2++;
                    if(row1>4){
                        row1=Math.abs(row1-5);
                    }
                    if(row2>4){
                        row2=Math.abs(row2-5);
                    }
                    pair2.append(mat[row1][col1]);
                    pair2.append(mat[row2][col2]);
                    String Pairtext=pair2.toString();
                    ciphertext.add(Pairtext);
                }
                else{
                    int temp=col1;
                    col1=col2;
                    col2=temp;
                    pair2.append(mat[row1][col1]);
                    pair2.append(mat[row2][col2]);
                    String Pairtext=pair2.toString();
                    ciphertext.add(Pairtext);
                }
            }
        }
        StringBuilder pair3=new StringBuilder();
        for (int p = 0; p < ciphertext.size(); p++) {

            pair3.append(ciphertext.get(p));
        }
        //end of pairing
        String returntext=pair3.toString();
        return returntext;
    }
    public char[] getMatrix(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix2d[i+j]=matrix[i][j];

            }
        }
        return matrix2d;
    }
    public char[][] getMatrix2D(){
        return matrix;
    }
    }





