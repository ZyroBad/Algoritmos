import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortingAlgorithmsTest {

    @Test
    void testBucketSort() {
        double[] arr = {0.4, 0.2, 0.6, 0.1};
        double[] expected = {0.1, 0.2, 0.4, 0.6};
        SortingAlgorithms.bucketSort(arr);
        assertArrayEquals(expected, arr, 0.001);
        
        double[] empty = {};
        SortingAlgorithms.bucketSort(empty);
        assertEquals(0, empty.length);
    }

    @Test
    void testInsertionSort() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        int[] expected = {1, 2, 3, 4, 5, 6};
        SortingAlgorithms.insertionSort(arr);
        assertArrayEquals(expected, arr);
        
        int[] single = {42};
        SortingAlgorithms.insertionSort(single);
        assertArrayEquals(new int[]{42}, single);
    }

    @Test
    void testMergeSort() {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};
        SortingAlgorithms.mergeSort(arr);
        assertArrayEquals(expected, arr);
        
        int[] reverse = {4, 3, 2, 1};
        SortingAlgorithms.mergeSort(reverse);
        assertArrayEquals(new int[]{1, 2, 3, 4}, reverse);
    }

    @Test
    void testQuickSort() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};
        SortingAlgorithms.quickSort(arr);
        assertArrayEquals(expected, arr);
        
        int[] duplicates = {3, 1, 2, 3};
        SortingAlgorithms.quickSort(duplicates);
        assertArrayEquals(new int[]{1, 2, 3, 3}, duplicates);
    }

    @Test
    void testRadixSort() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        SortingAlgorithms.radixSort(arr);
        assertArrayEquals(expected, arr);
        
        int[] varied = {3, 12, 456, 7};
        SortingAlgorithms.radixSort(varied);
        assertArrayEquals(new int[]{3, 7, 12, 456}, varied);
    }
}