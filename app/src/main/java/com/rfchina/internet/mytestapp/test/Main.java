package com.rfchina.internet.mytestapp.test;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public void plan(String n) {
        int max = 0;
        Stack s = new Stack();
        for (int j = 0; j < n.length(); j++) {
            if (!s.empty()) s.clear();
            for (int i = j; i < n.length(); i++) {
                if (s.empty()) s.push(n.charAt(i));
                else if (("" + n.charAt(i)).compareTo(""+s.peek()) <= 0) continue;
                else s.push( n.charAt(i));
            }
            if (max < s.size()) max = s.size();
        }
        System.out.println(max);
    }

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < n; j++) {
//                a[scanner.nextInt()]++;
//            }
            new Main().plan(scanner.next());
        }
    }
}
