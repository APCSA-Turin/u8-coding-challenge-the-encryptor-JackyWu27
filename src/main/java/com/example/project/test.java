package com.example.project;

public class test {
    public static void main(String[] args) {
        Encryptor e = new Encryptor();
        System.out.println(e.encryptMessage("I like keyboard shift better.", 3));
        System.out.println(e.decryptMessage("yf=ei.khr see tkdtirelab o Ibt", 3));
    }
}
