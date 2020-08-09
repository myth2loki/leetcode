package leetcode

/**
 *
 * 实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

 */
fun main(args: Array<String>) {
    val str1 = "mississippi"
    val str2 = "issip"
    println(strStr(str1, str2) == 4)
}

/**
 * 思路：
 * 1. 先找到子串第一个字符在母串中的位置并记录
 * 2. 开始逐一比较字符
 * 3. 如果不相等，则继续查找下一个子串第一个字符开始的位置
 * 4. 如果一直相等，并且字符字符已经全部比较完成则返回记录的开始位置
 */
fun strStr(hayStack: String, needle: String): Int {
    //判断空串
    if (needle.isEmpty()) return 0
    //判断子串长度过大
    if (needle.length > hayStack.length) return -1

    var j = 0
    var start: Int
    var keyChar = needle[0]
    for (i in 0 until hayStack.length) {
        if (hayStack[i] == keyChar) {
            start = i
            for (k in i until hayStack.length) {
                if (hayStack[k] == needle[j++]) {
                    if (j >= needle.length) {
                        return start
                    }
                } else {
                    j = 0
                    break
                }
            }
        }
    }

    return -1
}