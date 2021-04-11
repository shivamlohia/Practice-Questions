import java.util.Scanner;

public class NumberOfRotation {
    static int numberOfRotations(int arr[], int n)
    {
        if(arr[0] < arr[n-1])
            return 0;
        int start = 0, end = n - 1;
        int c = 0;
        while(start <= end)
        {
            int mid = start + (end - start) /  2;
            if(arr[mid] < arr[(mid - 1 + n) % n])
                return n - mid;
            if(arr[end] > arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
            //System.out.println(++c + "iter. "+ arr[mid] + "- mid");
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner ipReader = new Scanner(System.in);
        int size = ipReader.nextInt();
        int arr[] = new int[size];
        for(int i = 0 ; i < size ; ++i)
            arr[i] = ipReader.nextInt();
        int rotations = numberOfRotations(arr, size);
        System.out.println(rotations);
    }
}
