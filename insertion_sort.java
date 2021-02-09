public class insertion_sort {

    /** 
     * Sorts an array in increasing order using insertion-sort
     * @param list 
     */
    public void sort(double[] list) {

        // start with the second element of the list
        for (int j = 1; j < list.length; j++){
            // put the element into a seperate variable
            double key = list[j];   

            // i is the element that will be compared to the key (so in first iteration, i will be the first element, j will be the second element)
            int i = j - 1;

            // if any element is larger than the key, move it to the sorted part of the array
            while((i > 0) && (list[i] > key)){
                list[i + 1] = list[i];
                i = i - 1;
            }

            list[i + 1] = key; 
        }
    }
}
