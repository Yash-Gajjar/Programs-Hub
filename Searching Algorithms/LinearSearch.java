public class LinearSearch {

    static int linearSearch(int[] numbers, int element) {
        for(int i = 0; i < numbers.length; i++)
            if(numbers[i] == element)
                return i;

        return -1 ;
        
    }

    public static void main(String argsp[]) {
        
        int[] numbers = {1,3,4,6,8,9,10,21,31,24,53,56,74} ;
        int element = 56;
        int index =  linearSearch(numbers, element) ;

        if(index > -1)
            System.out.println("Element Found At: "+(index+1)+" Position!");
        else
            System.out.println("Element Not Found!") ;

    }
}