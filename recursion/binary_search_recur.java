import java.util.*;

public class binary_search_recur{
    static int binarySearch(int arr[], int l, int r, int x){
        int mid = 0;

            if (r >= l){
                mid = l + (r - l) / 2;
                if (arr[mid] == x)
                    return mid;
                else if (arr[mid] > x)
                    return binarySearch(arr, l, mid - 1, x);

                return binarySearch(arr, mid + 1, r, x);
            }
            return -1;
        }
        public static void main(String args[]){
            Scanner key = new Scanner(System.in);
            System.out.println("Enter the size of the array");
            int  n = key.nextInt();
            int arr[] = new int[n];

            for(int i=0; i<n; i++)
                arr[i] = key.nextInt();
            
            System.out.println("Enter the element you wanna search");
            int ele = key.nextInt();    
            int pos = binarySearch(arr, 0, arr.length-1, ele);

            System.out.println("The element is at position "+ pos);

            key.close();
        }
    }
  
