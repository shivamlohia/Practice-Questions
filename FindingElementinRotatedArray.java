import java.util.Scanner;

public class FindingElementinRotatedArray {
    static int numberOfRotation(int arr[], int n) {
        if (arr[0] < arr[n - 1])
            return 0;
        int start = 0, end = n - 1;
        int c = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[(mid - 1 + n) % n])
                return mid;
            if (arr[end] > arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
            //System.out.println(++c + "iter. "+ arr[mid] + "- mid");
        }
        return 0;
    }
    static int binarySearch(int arr[], int start, int end, int element)
    {
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(arr[mid] == element)
                return mid;
            else if(arr[mid] > element)
                end = mid - 1;
            else
                start = mid + 1;
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
        int minEleIndex = numberOfRotation(arr, size);
        int index1 = binarySearch(arr,0,minEleIndex - 1,element);
        int index2 = binarySearch(arr,minEleIndex,size - 1,element);
        if(index1 != -1 && index2 == -1)
            System.out.println("Index: " + index1);
        else if(index2 != -1 && index1 == -1)
            System.out.println("Index: " + index2);
        else if(index1 == -1 && index2 == -1)
            System.out.println("Element not found");
        else
            System.out.println("2 index found.\nIndex 1: " + index1 + "\nIndex 2 : " + index2);
    }
}
