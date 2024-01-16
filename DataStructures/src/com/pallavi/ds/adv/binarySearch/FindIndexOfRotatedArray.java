package com.pallavi.ds.adv.binarySearch;

import java.util.ArrayList;

public class FindIndexOfRotatedArray {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(6);
		arrayList.add(7);
		System.out.println(binarySearch(arrayList, 5, 0, arrayList.size()-1));
	}
	
	public static int binarySearch(ArrayList<Integer> A, int B, int startIndex, int endIndex){
        if(startIndex > endIndex){
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        int middleElement = A.get(mid);
        int firstArrayElement = A.get(0);

        if(middleElement == B){
            return mid;
        }
        
        if(firstArrayElement <= B){
            if(middleElement >= firstArrayElement){
                if(middleElement < B){
                    startIndex = mid+1;
                }else{
                    endIndex = mid-1;
                }
            }else{
                endIndex = mid - 1;
            }
        }else{
            if(middleElement < firstArrayElement){
                if(middleElement < B){
                    startIndex = mid+1;
                }else{
                    endIndex = mid-1;
                }
            }else{
                startIndex = mid+1;
            }
        }
        return binarySearch(A, B, startIndex, endIndex);
    }

}
