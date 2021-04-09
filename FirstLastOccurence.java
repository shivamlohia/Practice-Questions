import java.util.Scanner;

public class FirstLastOccurence {
    static int firstOccurence(int arr[], int start, int end, int element)
    {
        int result = -1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(arr[mid] < element)
                start = mid + 1;
            else if(arr[mid] > element)
                end = mid - 1;
            else
            {
                result = mid;
                end = mid - 1;
            }
        }
        return result;
    }
    static int lastOccurence(int arr[], int start, int end, int element)
    {
        int result = -1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(arr[mid] < element)
                start = mid + 1;
            else if(arr[mid] > element)
                end = mid - 1;
            else
            {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner ipReader = new Scanner(System.in);
        int size = ipReader.nextInt();
        int arr[] = new int[size];
        for(int i = 0 ; i < size ; ++i)
            arr[i] = ipReader.nextInt();
        int element = ipReader.nextInt();
        int occurence = firstOccurence(arr, 0, size - 1, element);
        if(occurence == -1)
            System.out.println("Item not found");
        else
            System.out.println("First occurence index : " + occurence);
        occurence = lastOccurence(arr, 0, size - 1, element);
        if(occurence != -1)
            System.out.println("Last occurence index : " + occurence);
    }
}
