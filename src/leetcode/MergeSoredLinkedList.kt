package leetcode

/**
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */

fun main(args: Array<String>) {
    val list1 = createList(0..1)
    val list2= createList(2..3)
    print(mergeTwoLists1(list1, list2))

    print(mergeTwoLists1(createList(intArrayOf(1,3,5,7)), createList(intArrayOf(2,4,6,8))))
    print(mergeTwoLists1(createList(intArrayOf(1,2,6,7,8,9)), createList(intArrayOf(0,3,4,11,33,55))))
}

fun print(list: ListNode?) {
    list?: return
    var cur: ListNode = list
    while(true) {
        print("${cur.`val`}, ")
        cur = cur.next?: break
    }
    println()
}

fun createList(array: IntArray): ListNode {
    var root: ListNode? = null
    var cur: ListNode? = null
    for (i in array) {
        if (root == null) {
            root = ListNode(i)
            cur = root
            continue
        }
        cur!!.next = ListNode(i)
        cur = cur.next!!
    }
    return root!!
}

fun createList(range: IntRange): ListNode {
    var root: ListNode? = null
    var cur: ListNode? = null
    for (i in range) {
        if (root == null) {
            root = ListNode(i)
            cur = root
            continue
        }
        cur!!.next = ListNode(i)
        cur = cur.next!!
    }
    return root!!
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 != null) {
        return l2
    }
    if (l2 == null && l1 != null) {
        return l1
    }

    var l1Node = l1
    var l2Node = l2
    // 类似归并排序中的合并过程
    val dummyHead = ListNode(0)
    var cur: ListNode? = dummyHead
    while (l1Node != null && l2Node != null) {
        if (l1Node.`val` < l2Node.`val`) {
            cur!!.next = l1Node //当前节点next指向l1
            cur = cur.next
            l1Node = l1Node.next
        } else {
            cur!!.next = l2Node
            cur = cur.next
            l2Node = l2Node.next
        }
    }
    // 任一为空，直接连接另一条链表
    if (l1Node == null) {
        cur!!.next = l2Node
    } else {
        cur!!.next = l1Node
    }
    return dummyHead.next
}

fun mergeTwoLists1(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }
    return if (l1.`val` > l2.`val`) {
        l2.next = mergeTwoLists1(l2.next, l1)
        l2
    } else {
        l1.next = mergeTwoLists1(l1.next, l2)
        l1
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "ListNode(`val`=$`val`)"
    }
}