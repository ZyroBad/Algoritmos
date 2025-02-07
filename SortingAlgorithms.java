import java.util.ArrayList;
import java.util.Collections;

public class SortingAlgorithms {

    // Bucket Sort para números entre 0 y 1
    public static void bucketSort(double[] arr) {
        int n = arr.length;
        ArrayList<Double>[] buckets = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for (double num : arr) {
            int bucketIndex = (int) (num * n);
            buckets[bucketIndex].add(num);
        }
        
        for (ArrayList<Double> bucket : buckets) {
            Collections.sort(bucket);
        }
        
        int index = 0;
        for (ArrayList<Double> bucket : buckets) {
            for (double num : bucket) {
                arr[index++] = num;
            }
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];
            
            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, arr.length - mid);
            
            mergeSort(left);
            mergeSort(right);
            
            merge(arr, left, right);
        }
    }
    
    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        
        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Radix Sort
    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }
    
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }
    
    private static void countingSort(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];
        
        for (int num : arr) {
            count[(num / exp) % 10]++;
        }
        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        // Pruebas de los algoritmos
        double[] bucketArray = {0.4, 0.2, 0.6, 0.1};
        bucketSort(bucketArray);
        System.out.println("Bucket Sort: " + Arrays.toString(bucketArray));
        
        int[] insertionArray = {5, 2, 4, 6, 1, 3};
        insertionSort(insertionArray);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionArray));
        
        int[] mergeArray = {12, 11, 13, 5, 6, 7};
        mergeSort(mergeArray);
        System.out.println("Merge Sort: " + Arrays.toString(mergeArray));
        
        int[] quickArray = {10, 7, 8, 9, 1, 5};
        quickSort(quickArray);
        System.out.println("Quick Sort: " + Arrays.toString(quickArray));
        
        int[] radixArray = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(radixArray);
        System.out.println("Radix Sort: " + Arrays.toString(radixArray));
    }
}