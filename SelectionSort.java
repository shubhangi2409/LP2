import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < n-1; i++) {
            int min = i;
            for(int j = i+1; j < n; j++) {
                if(arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        System.out.println("Sorted array:");
        for(int x : arr)
            System.out.print(x + " ");
    }
}





/*

Sample Output
Enter number of elements: 5
Enter elements:
64 25 12 22 11
Sorted array:
11 12 22 25 64 

*/