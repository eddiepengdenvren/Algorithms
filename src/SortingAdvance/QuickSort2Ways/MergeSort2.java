package SortingAdvance.QuickSort2Ways;

import java.util.Arrays;

/**
 * Created by SJW on 2017/7/11.
 * 归并排序算法(优化后)
 * 先将数组递归分成一个个独立元素，然后每组元素排序，然后归并，后继续排序，向上归并，最终排序完成
 */
public class MergeSort2 {

    private MergeSort2(){}

    /**
     * 递归排序方法
     * @param array
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] array,int l,int mid,int r){
        //先复制数组到存储空间
        Comparable[] copy = Arrays.copyOfRange(array,l,r+1);

        //初始化
        int i = l;
        int j = mid + 1;

        for (int k=l;k<=r;k++){
            if (i > mid){   //说明左面的游标已经结束，左半边已经排序完成
                array[k] = copy[j-l];
                j++;
            }else if(j > r){    //说明右面的游标已经结束，右半边已经排序完成
                array[k] = copy[i-l];
                i++;
            }else if(copy[i-l].compareTo(copy[j-l])<0){ //说明左面比右边小
                array[k] = copy[i-l];
                i++;
            }else{  //说明左面比右边大
                array[k] = copy[j-l];
                j++;
            }
        }
    }

    /**
     * 优化后的递归排序数组
     * @param array
     * @param l
     * @param r
     */
    private static void sort(Comparable[] array,int l,int r){
        //优化点2：如果数组的元素在15个以内的话，代表着数组的有序程度可能会比较强，所以这种情况下可以使用插入排序算法来代替归并排序法，效率会更高
        /*if (l>=r)
            return;*/
        if (r - l <= 15){
            InsertSort.sort(array,l,r);
            return;
        }
        int mid = (l+r)/2;
        sort(array,l,mid);
        sort(array,mid+1,r);
        //优化点1：如果左半边的最后一个元素比右半边的最后一个元素大的话，才执行归并排序方法，否则的话代表左右数组的顺序已经排好，即已经得到一个有序数组了
        if(array[mid].compareTo(array[mid+1]) > 0){
            merge(array,l,mid,r);
        }
    }

    //公开归并方法
    public static void sort(Comparable[] array){
        int length = array.length;
        sort(array,0,length-1);
    }

    // 测试MergeSort
    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 50000;
        Integer[] arr = SortTestHelper.generateTestArray(N, 0, N);
        SortTestHelper.testSort("SortingAdvance.MergeSort.MergeSort", arr);

        return;
    }
}
