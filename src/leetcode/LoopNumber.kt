package leetcode

import java.lang.NumberFormatException

/**
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？
 */

fun main(args: Array<String>) {
//    println(isPalindrome1(123))
    println(isPalindrome2(121))
//    println(isPalindrome1(-121))
}

fun isPalindrome1(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    if (x == 0) {
        return true
    }

    var temp = x
    var shang = temp / 10
    var yu = temp % 10
    var temp2 = yu
    println("$shang, $temp2")
    while (shang > 0) {
        if (shang == temp2) {
            return true
        }
        temp = shang
        shang = temp / 10
        yu = temp % 10
        temp2 = temp2 * 10 + yu
        println("$shang, $temp2")
    }
    return shang == temp2
}

fun isPalindrome2(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    if (x == 0) {
        return true
    }
    var newX: Long = 0
    var temp = x
    while (temp > 0) {
        newX = newX * 10 + temp % 10
        temp /= 10
        println("$temp $newX")
    }
    return newX == x.toLong()
}

fun isPalindrome(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    if (x == 0) {
        return true
    }
    return x.reverse() == x.toLong()
}

fun Int.reverse(): Long {
//    val temp = toString().reversed()
    val temp = toString().toCharArray().reverse()
    return temp.joinToString("").toLong()
}

fun CharArray.reverse(): CharArray {
    for (i in 0 until (size / 2)) {
        this[i] = this[size - i - 1]
    }
    return this
}

