package basic;

import org.junit.Test;

public class AllSort {
    //冒泡排序
    public int[] bubbleSort(int[] arr) {
        if (arr==null||arr.length<2){
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    //冒泡优化
    public int[] bubbleSortPuls(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            boolean flag=true;
            for (int j = 0; j <arr.length-1-i ; j++) {
                if (arr[j+1]<arr[j]){
                    flag=false;
                    int temp= arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
            if (flag){
                break;
            }
        }
        return arr;
    }

    //快速排序
    public static int[] quickSort(int[] arr, int left, int right){

        return null;
    }
    //选择排序
    public static int[] selectSort(int[] a){
        for (int i = 0; i <a.length-1 ; i++) {
            int min=i;
            for (int j = i+1; j <a.length ; j++) {
                if (a[min]>a[j]){
                    min=j;
                }
            }
            int temp=a[i];
            a[i]=a[min];
            a[min]=temp;
        }
        return a;
    }
    //插入排序
    public static int[] insertSort(int[] arr){
        return null;
    }

    @Test
    public void test() {
        int[] test = {1, 3, 5, 4, 2, 6, 8, 0};
        int[] res = bubbleSortPuls(test);
        int[] ints = selectSort(test);
        for (int i = 0; i < ints.length; i++) {
            int re = ints[i];
            System.out.println(re);
        }
    }

}
