package com.company;

import java.util.Scanner;

public class WordComparison {
    WordComparison(String tab1[], String tab2[]) {
        System.out.println(tab2[3]);
        Scanner scanner = new Scanner(System.in);
        int points = 0;
        for (int i = 0; i < tab1.length; i++) {
            System.out.println(tab1[i]);
            String tmp = scanner.next();
            if (tab2[i].equalsIgnoreCase(tmp)) {
                System.out.println("OK");
                points++;
            } else
                System.out.println("NOK");

        }
    }
}
