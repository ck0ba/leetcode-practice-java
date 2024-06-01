package org.back0.leetcode.array;


//https://leetcode.com/problems/product-of-array-except-self/description/

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] resultProdArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            resultProdArr[i] = 1;
        }

        var leftProd = 1;
        var rightProd = 1;
        for (int i = 0; i < nums.length; i++) {
            resultProdArr[i] *= leftProd;
            resultProdArr[nums.length - 1 - i] *= rightProd;

            leftProd *= nums[i];
            rightProd *= nums[nums.length - 1 - i];
        }

        return resultProdArr;
    }

}
