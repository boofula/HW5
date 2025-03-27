/******************************************************************
 *
 *   Will Bales / 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset of array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */


    public boolean isSubset(int list1[], int list2[]) {

        // Create an integer hash set to store the elements of list1
        Set <Integer> set = new HashSet<Integer>();

        // Add the elements of list1 to the hash set using a for loop
        for (int i = 0; i < list1.length; i++) {
            set.add(list1[i]);
        }

        // Check if the elements of list2 are contained in the hash set
        for (int i = 0; i < list2.length; i++) {
            // If the element is not contained in the hash set, return false
            // because list2 is not a subset of list1
            if (!set.contains(list2[i])) {
                return false;
            }
        }

        // If all the elements of list2 are contained in the hash set, return true
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // Create a priority queue to store the elements contained in the array
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Add the elements of the array to the priority queue using a for loop
        for (int i = 0; i < array.length; i++) {
            // Add the elements to the prioriy queue
            // since the priority queue is a min heap, the smallest element will be at the top
            pq.add(array[i]);

            // If the size of the priority queue is greater than k,
            // remove the smalles element from the priority queue
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // From this process pq.peek() will return the kth largest element in the array
        return pq.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // Create a new array to store the elements of array1 and array2
        int[] result = new int[array1.length + array2.length];

        // Copy the elements of array1 to the result array
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
        }

        // Copy the elements of array2 to the rest of the result array
        for (int i = array1.length; i < result.length; i++) {
            result[i] = array2[i - array1.length];
        }

        // Create a priority queue to store the elements of the result array
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Add the elements of the result array to the priority queue
        // since the priority queue is a min heap, the smallest element will be at the top
        for (int i = 0; i < result.length; i++) {
            pq.add(result[i]);
        }

        // Create an index variable to store the index of the result array
        int index = 0;
        // Slowly remove the elements from the priority queue and add them to the result array
        while(!pq.isEmpty()) {
            result[index++] = pq.poll();
        }

        // Return the sorted result array
        return result;
    }

}
