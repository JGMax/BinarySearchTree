
fun main() {
    val tree = BinaryTree()
    tree.add(4)
    tree.add(8)
    tree.add(5)
    tree.add(1)
    tree.add(-8)
    tree.add(7)
    tree.add(6)
    tree.add(8)
    tree.traversal(type = TraversalType.InOrder, action = object : Action {
        override fun action(value: Int) {
            print("$value ")
        }
    })
}
