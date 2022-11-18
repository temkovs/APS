package com.apsaud6_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        // Vasiot kod tuka

        Stack<Integer> tmp = new Stack<>();

        String stringNumber = "";
        boolean lastSignMultiply = false;
        for(int i=0;i<expression.length();i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                int number = Integer.parseInt(stringNumber);
                if(lastSignMultiply) {
                    int previousNumber = tmp.pop();
                    tmp.push(previousNumber*number);
                    lastSignMultiply = false;
                } else {
                    tmp.push(number);
                }
                if(expression.charAt(i) == '*') {
                    lastSignMultiply = true;
                }

                stringNumber = "";
            } else {
                stringNumber+=expression.charAt(i);
            }
        }
        int number = Integer.parseInt(stringNumber);

        if(lastSignMultiply) {
            int previousNumber = tmp.pop();
            tmp.push(previousNumber*number);
        } else {
            tmp.push(number);
        }

        int sum = 0;
        while(!tmp.isEmpty()) {
            sum+=tmp.pop();
        }

        return sum;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}