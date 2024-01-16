package com.pallavi.ds.adv;

import java.util.ArrayList;
import java.util.List;

public class NoOfCoins {

	public static void main(String[] args) {
		System.out.println(solve(2011));

	}
	
	public static int solve(int A) {
        int divisor = 1220703125;
        int newno = A;
        int noOfCurrencyRequired = 0;
        
        if(A < 1) {
        	return 0;
        }else if(A == 1) {
        	return 1;
        }
        while(newno >= 1){
        	int division = newno / divisor;
            if(division > 0){
                noOfCurrencyRequired = noOfCurrencyRequired + division;
                newno = newno % divisor;
            }
            divisor = divisor / 5;
            
        }
        
        return noOfCurrencyRequired;
    }

}
