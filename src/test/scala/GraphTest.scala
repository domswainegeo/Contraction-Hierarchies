import org.scalatest.funsuite.AnyFunSuite

class GraphTest extends AnyFunSuite {

  val node1 = new SimpleNode(1)
  val node2 = new SimpleNode(2)
  val node3 = new SimpleNode(3)

  val graph = new Graph(
    List(node1, node2, node3),
    List(new SimpleEdge(node1, node2, 2), new SimpleEdge(node2, node3, 2))
  )

  test("Removing a node from a directed graph") {
    assert(graph.remove_node(node2).edges.isEmpty)
  }

}