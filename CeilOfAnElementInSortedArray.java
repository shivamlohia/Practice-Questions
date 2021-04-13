import java.util.Scanner;

public class CeilOfAnElementInSortedArray {
    static int findCeil(int arr[], int start, int end, int element)
    {
        if(arr[start] >= element)
            return arr[start];
        if(arr[end] < element)
            return -1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(arr[mid] == element)
                return element;
            if(mid < end && arr[mid] < element && arr[mid + 1] >= element)
                return arr[mid + 1];
            if(mid > start && arr[mid] > element && arr[mid - 1] < element)
                return arr[mid];
            if(arr[mid] < element)
                start = mid + 1;
            else
                end = mid - 1;
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
        int ceil = findCeil(arr,0, size - 1,element);
        if(ceil == -1)
            System.out.println("All array elements less than "+element);
        else
            System.out.println("Ceil is " + ceil);
    }
}
