import java.util.Scanner;

public class FloorOfAnElementInArray {
    static int findFloor(int arr[], int start, int end, int element)
    {
        if(arr[start] > element)
            return -1;
        if(arr[end] <= element)
            return arr[end];
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(arr[mid] == element)
                return element;
            if(mid > 0 && arr[mid - 1] <= element && arr[mid] > element)
                return arr[mid - 1];
            if(element < arr[mid])
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
        int floor = findFloor(arr,0,size - 1,element);
        System.out.println("Nearest to " + element +" is " + floor);
        System.out.println("If output is -1, no floor element found.");
    }
}
