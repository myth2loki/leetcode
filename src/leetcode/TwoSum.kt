package leetcode

/** easy
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */

fun main(args: Array<String>) {
    val arr1 = intArrayOf(2,7,11,15)
    val target = 9
    val result = Solution.twoSum(arr1, target)
    result.forEach { println(it) }
}

object Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0..(nums.size - 1)) {
            val v1 = nums[i]
            for (j in (i + 1)..(nums.size - 1)) {
                val v2 = nums[j]
                if (v1 + v2 == target) {
                    val intArray = IntArray(2)
                    intArray[0] = i
                    intArray[1] = j
                    return intArray
                }
            }
        }
        return IntArray(2) { 0 }
    }
}