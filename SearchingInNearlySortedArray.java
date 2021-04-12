import java.util.Scanner;

public class SearchingInNearlySortedArray {
    static int nearlySortedBS(int arr[], int start, int end, int element)
    {
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(arr[mid] == element)
                return mid;
            if(mid > start && arr[mid - 1] == element)
                return mid-1;
            if(mid < end && arr[mid + 1] == element)
                return mid+1;
            if(arr[mid] > element)
                end = mid - 2;
            else
                start = mid + 2;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner ipReader = new Scanner(System.in);
        int size = ipReader.nextInt();
        int arr[] = new int[size];
        for(int i = 0 ; i < size ; ++i)
            arr[i] = ipReader.nextInt();
        int element = ipReader.nextInt();
        int index = nearlySortedBS(arr, 0, size - 1, element);
        if(index == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element at: " + index);
    }
}
