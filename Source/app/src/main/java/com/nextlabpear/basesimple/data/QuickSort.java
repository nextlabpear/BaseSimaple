package com.nextlabpear.basesimple.data;

public class QuickSort{

    public static int part(int[] data, int left, int right){
        int pivot = data[(left+right)/2];

        while (left < right){
            while (data[left] < pivot) left++;
            while (data[right] >pivot) right--;
            if(left < right){
                swap(data, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void sort(int[] data, int left, int right){
        if(left >= right)
            return;
        int mid = part(data, left, right);
        sort( data, left, mid-1);
        sort(data, mid, right);
    }

    private static void swap(int data[], int left, int right)
    {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }
}
