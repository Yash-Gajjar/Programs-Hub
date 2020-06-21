public class BinarySearch {

    static int binarySearch(int[] numbers, int element) {
        int lowerBound = 0 ;
        int upperBound = numbers.length -1 ;
        int middle = numbers.length/2 ;

        for( ; upperBound != lowerBound; middle = (upperBound + lowerBound) / 2){
            if(element == numbers[middle])
                return middle ;
            else if(numbers[middle] < element)
                lowerBound = middle+1 ;
            else
                upperBound = middle-1 ;
        }
        
        return -1 ;
    }

    public static void main(String args[]) {

        int[] numbers = {1,3,4,6,8,9,10,21,31,24,53,56,74} ;
        int element = 56;
        int index =  binarySearch(numbers, element) ;

        if(index > -1)
            System.out.println("Element Found At: "+(index+1)+" Position!");
        else
            System.out.println("Element Not Found!") ;

    }
}