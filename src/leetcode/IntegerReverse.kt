package leetcode

/**
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */

fun main(args: Array<String>) {
    println(reverse(123))
}

fun reverse(x: Int): Int {
    var xs = x.toString()
    if (xs.length == 1) {
        return x
    }
    val isNegative = xs[0] == '-'
    val hasZero = xs[xs.length - 1] == '0'
    if (isNegative) {
        xs = xs.substring(1, xs.length)
    }
    if (hasZero) {
        xs = xs.substring(0, xs.length - 1)
    }
    val temp = CharArray(xs.length)
    for (i in 0 until xs.length) {
        temp[xs.length - i - 1] = xs[i]
        temp[i] = xs[xs.length - i - 1]
    }
    var ret = 0
    try {
        ret = Integer.parseInt(String(temp))
    } catch (e: NumberFormatException) {
        return ret
    }

    if (isNegative) {
        ret = -ret
    }
    return ret
}