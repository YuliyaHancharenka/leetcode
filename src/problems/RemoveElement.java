package problems;

public class RemoveElement {
    //27
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    /*
    Approach 1: Two Pointers
Intuition
Since this question is asking us to remove all elements of the given value in-place,
we have to handle it with O(1) extra space. How to solve it? We can keep two pointers i and j, where i is the slow-runner while j is the fast-runner.
Algorithm
When nums[j] equals to the given value, skip this element by incrementing j. As long as nums[j] \neq val nums[j]
we copy nums[j] to nums[i] and increment both indexes at the same time. Repeat the process until j reaches the end of the array and the new length is i.
     */
    private static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /*
    Approach 2: Two Pointers - when elements to remove are rare
Intuition
Now consider cases where the array contains few elements to remove. For example, nums = [1,2,3,5,4], val = 4, nums=[1,2,3,5,4],val=4.
The previous algorithm will do unnecessary copy operation of the first four elements. Another example is nums = [4,1,2,3,5], val = 4,
nums=[4,1,2,3,5],val=4. It seems unnecessary to move elements [1,2,3,5] one step left
as the problem description mentions that the order of elements could be changed.
 */
    private static int removeElement2PointersWithElementsToRemoveAreRare(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}

/*
Example 1:
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */