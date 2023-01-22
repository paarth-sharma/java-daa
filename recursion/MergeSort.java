import java.util.*;
public class MergeSort {
    void merge(int arr[], int left, int mid, int right){
        int size1 = mid-left+1;
        int size2 = right-mid;

        int L[] = new int [size1];
        int R[] = new int [size2];

        // copy data to temp arrays
        for(int i=0; i<size1; i++)
            L[i] = arr[left+i];
        
        for(int j=0; j<size2; j++)
            R[j] = arr[mid + 1 + j];

        int i=0, j=0;

        int k = left;
        while(i < size1 && j< size2){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < size1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < size2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;
            sort(arr, left, mid);
            sort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }

    }

    public static void main(String[] args) {
        Scanner key = new Scanner (System.in);
        System.out.println("Enter no. of elements:");
        int n = key.nextInt();
        int arr[] = new int [n];
        System.out.println("Enter array to be sorted:");

        for(int i=0; i<n; i++)
            arr[i] = key.nextInt();
        
        MergeSort obj = new MergeSort();
        obj.sort(arr, 0, (arr.length - 1));

        System.out.println("Sorted array is:");

        for(int i =0; i<n; i++)
            System.out.print(arr[i]+ " ");

        key.close();
    }
}
