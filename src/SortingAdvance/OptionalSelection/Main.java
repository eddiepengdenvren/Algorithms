package SortingAdvance.OptionalSelection;

import SortingAdvance.QuickSort.SortTestHelper;

import java.util.Arrays;

/**
 * Created by SJW on 2017/7/9.
 * 测试插入排序算法和选择排序算法的效率
 */
public class Main {

    public static void main(String[] args) {
        int n = 100;

        Integer[] arr1 = SortingAdvance.QuickSort.SortTestHelper.generateTestArray(n,0,n);
        //Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(n,100);
        //Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
        /*Integer[] arr3 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1,arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1,arr1.length);*/

        //此时的选择排序比插入排序的效率高
        /*SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.SelectionSort",arr1);
        SortTestHelper.testSort("SortingBasic.InsertionSortAdvance.InsertSort",arr2);
        SortTestHelper.testSort("SortingBasic.BubbleSort.BubbleSort",arr3);*/
        //SortingAdvance.QuickSort.SortTestHelper.testSort("SortingAdvance.MergeSortAdvance.MergeSort",arr1);
        SortTestHelper.testSort("SortingAdvance.OptionalSelection.QuickSort",arr1);

        return;
    }
}
