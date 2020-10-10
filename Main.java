package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);
        System.out.println("Do you want to find Book by Name or Author name ?\n 1. Book by Author name\n 2. Book by its name \n ==> ");
        int choice = s1.nextInt();
        if (choice == 1) {
            findAuthor fa1 = new findAuthor();
            fa1.findBookByAuthorName();
        } else if (choice == 2) {
            findBook fb1 = new findBook();
            fb1.findBookByBookName();
        } else {
            System.out.println("Incorrect Value -> plz try again.. ;(");
        }
        System.out.println("/$----------------------------------------------------$/");
    }
}
