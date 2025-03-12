package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        int c = messageLen / rows;
        if (c * rows < messageLen || messageLen == 0) {
            c ++;
        }
        return c;
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        String [][] rtrn = new String [rows][determineColumns(message.length(), rows)];
        int check = 0;
        for (int c = 0; c < rtrn.length; c++) {
            for (int d = 0; d < rtrn[0].length; d++) {
                if (check < message.length()) {
                    rtrn[c][d] = message.substring(check, check + 1);
                    check++;
                } else {
                    rtrn[c][d] = "=";
                }
            }
        }
        return rtrn;
    }

    public static String encryptMessage(String message, int rows){
        String [][] arr = generateEncryptArray(message, rows);
        String rtrn = "";
        for (int c = arr[0].length - 1; c > -1; c--) {
            for (int d = 0; d < rows; d ++) {
                rtrn += arr[d][c];
            }
        }
        return rtrn;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        int col = encryptedMessage.length() / rows;
        String [][] arr = new String [rows][col];
        int count = 0;
        String rtrn = "";
        for (int c = col - 1; c > -1; c--) {
            for (int d = 0; d < rows; d ++) {
                arr[d][c] = encryptedMessage.substring(count, count + 1);
                count ++;
            }
        }
        for (String [] c : arr) {
            for (String d : c) {
                if (!d.equals("=")) {
                    rtrn += d;
                }
            }
        }
        return rtrn;
    }
}