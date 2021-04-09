import java.util.Scanner;
//Binary search in descending sorted array
public class binSearchDescArray {
    static boolean binaryReverseSearch(int arr[], int start, int end, int element)
    {
        boolean present = false;
        if(start > end)
            return false;
        else {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)
                present = true;
            else if (arr[mid] > element)
                present = binaryReverseSearch(arr, mid + 1, end, element);
            else
                present = binaryReverseSearch(arr, start, mid - 1, element);
        }
        return present;
    }
    public static void main(String[] args) {
        Scanner ipReader = new Scanner(System.in);
        int size = ipReader.nextInt();
        int arr[] = new int[size];
        System.out.println("Input array in reverse sorting");
        for(int i = 0 ; i < size ; ++i)
            arr[i] = ipReader.nextInt();
        int element = ipReader.nextInt();
        boolean present = binaryReverseSearch(arr, 0, size - 1, element);
        if(present)
            System.out.println("Item found");
        else
            System.out.println("Item not found");
    }
}
