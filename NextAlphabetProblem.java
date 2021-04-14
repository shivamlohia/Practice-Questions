import java.util.Scanner;

public class NextAlphabetProblem {
    static char findCeilAlphabet(char arr[], int start, int end, char element)
    {
        if(element > arr[end])
            return '#';
        if(element < arr[start])
            return arr[start];
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] == element && arr[mid + 1] > element)
                return arr[mid + 1];
            if(mid > start && arr[mid - 1] == element && arr[mid] > element)
                return arr[mid];
            if(mid < end && arr[mid] < element && arr[mid+1] > element)
                return arr[mid+1];
            if(mid > start && arr[mid] > element && arr[mid - 1] < element)
                return arr[mid];
            if(arr[mid] > element)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return '#';
    }
    public static void main(String[] args) {
        Scanner ipReader = new Scanner(System.in);
        char arr[] = ipReader.next().toCharArray();
        char element = ipReader.next().charAt(0);
        char ceil = findCeilAlphabet(arr, 0, arr.length - 1, element);
        if(ceil == '#')
            System.out.println("No ceil element found.");
        else
            System.out.println("Ceil is " + ceil);
    }
}
