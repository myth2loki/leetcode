package leetcode

/** medium
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 */

fun main(args: Array<String>) {
//    println(longestPalindrome("ac"))
    println("result: " + longestPalindrome("abcda"))
    println("result: " + longestPalindrome("babad"))
    println("result: " + longestPalindrome("\"\""))

//    println("abc".isLoop())
//    println("aba".isLoop())
//    println("aa".isLoop())
//    println("abcba".isLoop())

//    println("abc".allSubStrings())
}

fun longestPalindrome(s: String): String {
    if (s.isEmpty() || s.length == 1) {
        return s
    }

//    val tempList = mutableListOf<String>()
//
//    for (i in 0..(s.length - 1)) {
//        for (j in (i + 1)..(s.length - 1)) {
////            println("$i $j ${s.substring(i , j + 1)}")
//            if (isLoop(s, i, j)) {
//                tempList += s.substring(i, j +1)
////                println("$i $j " +tempList.last())
//            }
////            val subString = s.substring(i, j)
////            if (subString.first() == subString.last()) {
////                tempList += subString
////            }
//        }
//    }

    val tempList = s.allSubStrings().filter { it.isLoop() }

    println(tempList)
    if (tempList.isEmpty()) {
        return s[0].toString()
    }
    return tempList.maxBy { it.length }!!
}

fun isLoop(s: String, i: Int, j: Int): Boolean {
    if (s.isEmpty() || s.length == 1) {
        return false
    }

//    println(j / 2)
    for (k in i..((j - i) / 2)) {
//        print("${s[k]}, ${s[j-k]}")
        if (s[k] != s[j - k]) {
            return false
        }
    }
    return true
}

fun String.allSubStrings(): List<String> {
    val tempList = mutableListOf<String>()
    for (i in indices) {
        for (j in (i + 1)..length) {
            tempList += substring(i, j)
        }
    }
    return tempList
}

fun String.isLoop(): Boolean {
    if (length < 2) {
        return false
    }
    for (i in 0..length / 2) {
        if (this[i] != this[length - i - 1]) {
            return false
        }
    }
    return true
}