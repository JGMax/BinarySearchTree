class BinaryTree {
    private var head: Node? = null
    var size = 0
        private set

    fun add(value: Int) {
        if (head == null) {
            head = Node(value)
        } else {
            add(value, requireNotNull(head))
        }
        size++
    }

    private fun add(value: Int, node: Node) {
        if (value > node.value) {
            if (node.right == null) {
                node.right = Node(value)
            } else {
                add(value, requireNotNull(node.right))
            }
        } else {
            if (node.left == null) {
                node.left = Node(value)
            } else {
                add(value, requireNotNull(node.left))
            }
        }
    }

    fun traversal(type: TraversalType = TraversalType.PreOrder, action: (value: Int) -> Unit) {
        when(type) {
            TraversalType.PreOrder -> preOrderTraversal(action, head)
            TraversalType.PostOrder -> postOrderTraversal(action, head)
            TraversalType.InOrder -> inOrderTraversal(action, head)
            TraversalType.InOrderReverse -> inOrderReverseTraversal(action, head)
        }
    }

    private fun inOrderReverseTraversal(action: (value: Int) -> Unit, node: Node?) {
        if (node != null) {
            inOrderTraversal(action, node.right)
            action(node.value)
            inOrderTraversal(action, node.left)
        }
    }

    private fun inOrderTraversal(action: (value: Int) -> Unit, node: Node?) {
        if (node != null) {
            inOrderTraversal(action, node.left)
            action(node.value)
            inOrderTraversal(action, node.right)
        }
    }

    private fun postOrderTraversal(action: (value: Int) -> Unit, node: Node?) {
        if (node != null) {
            postOrderTraversal(action, node.left)
            postOrderTraversal(action, node.right)
            action(node.value)
        }
    }

    private fun preOrderTraversal(action: (value: Int) -> Unit, node: Node?) {
        if (node != null) {
            action(node.value)
            preOrderTraversal(action, node.left)
            preOrderTraversal(action, node.right)
        }
    }

    fun contains(value: Int) = (findParent(value) != null || head?.value == value)

    fun findParent(value: Int) : Node? {
        if (head == null) {
            return null
        }
        var destination: Node = head as Node
        var parent: Node? = null
        while (true) {
            when {
                value > destination.value -> {
                    if (destination.right == null) {
                        return null
                    } else {
                        parent = destination
                        destination = destination.right as Node
                    }
                }
                value < destination.value -> {
                    if (destination.left == null) {
                        return null
                    } else {
                        parent = destination
                        destination = destination.left as Node
                    }
                }
                else -> {
                    return parent
                }
            }
        }
    }
}