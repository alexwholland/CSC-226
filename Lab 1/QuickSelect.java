//Template is created by Zhuoli Xiao, on Sept. 19st, 2016.
//Only used for Lab 226, 2016 Fall.
//All Rights Reserved.

//modified by Rich Little on Sept. 23, 2016
//modified by Rich Little on May 12, 2017


import java.util.Random;

public class QuickSelect {
    //Function to invoke quickSelect
    public static int QS(int[] S, int k){
        if (S.length==1)
            return S[0];

        return quickSelect(0,S.length-1,S,k);
    }

    //do quickSelect in a recursive way
    private static int quickSelect(int left,int right, int[] array, int k){
        if (left == right) {
            return array[left];
        }
        //Pick a random pivot
        int pIndex = pickRandomPivot(left, right);
        //Partition based on the pivot
        int partition = partition(left, right, array, pIndex);
        //Return value at k if the partition value is equal to the kth position
        if (partition == k - 1) {
            return array[partition];
        //Search right side of array if partition value is less than the kth position.
        } else if (partition < k - 1) {
            return quickSelect(partition + 1, right, array, k);
        // Search left side of array if partition value is greater than the kth position
        } else {
            return quickSelect(left, partition - 1, array, k);
        }
    }

    private static int partition(int left, int right, int[] array, int pIndex){
        int value = array[pIndex];
        swap(array, pIndex, right);
        int partitionPoint = left;
        for (int i = left; i < right; i++) {
            if (array[i] < value) {
                swap(array, partitionPoint, i);
                partitionPoint++;
            }
        }
        swap(array, right, partitionPoint);
        return partitionPoint;
    }

    //Pick a random pivot to do the QuickSelect
    private static int pickRandomPivot(int left, int right){
        int index=0;
        Random rand= new Random();
        index = left+rand.nextInt(right-left+1);
        return index;
    }
    //swap two elements in the array
    private static void swap(int[]array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }


    //Our main function to test the algorithm
    public static void main (String[] args){
        //array one has duplicate elements
        int[] array1 ={12,13,17,14,21,3,4,9,21,8};
        //sorted array1 = {3,4,8,9,12,13,14,17,21,21}

        int[] array2 ={14,8,22,18,6,2,15,84,13,12};
        //sorted array2 = {2,6,8,12,13,14,15,18,22,84}

        int[] array3 ={6,8,14,18,22,2,12,13,15,84};

        int[] array4 = {1,2};

        int[] array5 = {1,1,1,2,2,4};

        System.out.println("Correct answer is 12 = " + "Your answer: "+QS(array1,5));
        System.out.println("Correct answer is 21 = " + "Your answer: "+QS(array1,10));

        System.out.println("Correct answer is 15 = " + "Your answer: "+QS(array2,7));
        System.out.println("Correct answer is 13 = " + "Your answer: "+QS(array3,5));
        System.out.println("Correct answer is 1 = " + "Your answer: "+QS(array4,1));
        System.out.println("Correct answer is 2 = " + "Your answer: "+QS(array5,5));
    }
}
