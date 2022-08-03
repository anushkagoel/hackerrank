package com.demo;

public class SearchRotatedSortedArray {
    public int search(int[] a, int target) {
        int i=0;
        int j=a.length-1;
        int mid=0;

        while(i<=j){
            mid=(i+j)/2;
            if(a[mid]==target){
                return mid;
            }
            //left portion array
            if(a[i]<=a[mid]){
                if(target<=a[mid] && target >=a[i]){
                    j=mid-1;
                }else{
                    i=mid+1;
                }

            } //right portion array
            else{
                if(target>=a[mid] && target <=a[j]){
                    i=mid+1;
                }else{
                    j=mid-1;
                }
            }
        }
        return -1;
    }
}
