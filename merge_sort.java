public class merge_sort {

    /** 
     * Sorts an array in increasing order using the merge-sort divide and conquer technique
     * @param list
     */
    public void sort(double[] list) {
        int length = list.length;

        // if the array has 1 element, or less than 1 element, it does not need to be sorted
        if (length <= 1){
            return;
        }

        // determine the middle index of the array (used for splitting the array into two arrays)
        int half  = length / 2;

        // put the first half of the array into a new array
        double[] firstHalf = new double[half];

        for (int i = 0; i < half; i++){
            firstHalf[i] = list[i];
        }

        // put the second half of the array into a new array
        double[] secondHalf = new double[length - half];

        for (int i = half; i < length; i++){
            secondHalf[i - half] = list[i];
        }

        // sort the first and second half of the array
        sort(firstHalf);
        sort(secondHalf);

        // after the individual arrays are sorted, combine them back into one big array
        merge(firstHalf, secondHalf, list);
    }

    
    /** 
     * This function combines the two halves of the list back into one sorted list
     * @param firstHalf (first half of the array)
     * @param secondHalf (second half of the array)
     * @param original_list 
     */
    public void merge(double[] firstHalf, double[] secondHalf, double[] original_list){
        // index of firstHalf list
        int i = 0;

        // index of secondHalf list
        int j = 0;
        
        while((i + j) < (original_list.length)){
            if (j == secondHalf.length || (i < firstHalf.length && compare(firstHalf[i], secondHalf[j]) < 0 )){
                // put ith element of firstHalf into the original
                original_list[i + j] = firstHalf[i++];  
            }
            else{
                // put jth elemenet of secondHalf into the original
                original_list[i + j] = secondHalf[j++];  
            }
        }
    }

    
    /** 
     * Compares two numbers, if first number is greater than second, returns 1, otherwise returns -1
     * @param x
     * @param y
     * @return int
     */
    public static int compare(double x, double y){
        if (x > y){
            return 1;
        }
        else{
            return -1;
        }
    }

}
