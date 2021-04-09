import java.util.Scanner;

public class OrderAgnosticSearch {
    static boolean NormalBinarySearch(int arr[], int start, int end, int element)
    {
        if(start > end)
            return false;
        else
        {
            boolean present;
            int mid = start + (end - start) / 2;
            if(arr[mid] == element)
                present = true;
            else if(arr[mid] > element)
                present = NormalBinarySearch(arr,start,mid - 1, element);
            else
                present = NormalBinarySearch(arr,mid+1,end,element);
            return present;
        }
    }
    static boolean reverseBinarySearch(int arr[], int start, int end, int element)
    {
        if(start > end)
            return false;
        else
        {
            boolean present;
            int mid = start + (end - start) / 2;
            if(arr[mid] == element)
                present = true;
            else if(arr[mid] < element)
                present = reverseBinarySearch(arr,start,mid - 1, element);
            else
                present = reverseBinarySearch(arr,mid+1,end,element);
            return present;
        }
    }
    public static void main(String[] args) {
        Scanner ipReader = new Scanner(System.in);
        int size = ipReader.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter array in ascending or descending order");
        for(int i = 0 ; i < size ; ++i)
            arr[i] = ipReader.nextInt();
        int element = ipReader.nextInt();
        if(size == 1 && arr[0] == element)
            System.out.println("Item found");
        else if(size == 1 && arr[0] != element)
            System.out.println("Item not found");
        else {
            boolean present;
            if (arr[0] < arr[size - 1])
                present = NormalBinarySearch(arr, 0, size - 1, element);
            else
                present = reverseBinarySearch(arr, 0, size - 1, element);
            if (present)
                System.out.println("Item found");
            else
                System.out.println("Item not found");
        }
    }
}
