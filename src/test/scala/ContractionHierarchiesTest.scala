import org.scalatest.funsuite.AnyFunSuite

class ContractionHierarchiesTest extends AnyFunSuite {

  val node1 = new GraphNode(1)
  val node2 = new GraphNode(2)
  val node3 = new GraphNode(3)
  val node4 = new GraphNode(4)
  val node5 = new GraphNode(5)

  val graph = new Graph(
    List(node1, node2, node3, node4, node5),
    List(
      new GraphEdge(node1, node3, 1), new GraphEdge(node3, node1, 1),
      new GraphEdge(node2, node3, 4), new GraphEdge(node3, node2, 4),
      new GraphEdge(node2, node4, 1), new GraphEdge(node4, node2, 1),
      new GraphEdge(node3, node5, 1), new GraphEdge(node5, node3, 1),
      new GraphEdge(node4, node5, 1), new GraphEdge(node5, node4, 1)
    )
  )

  test("Graph contraction") {
    val contracted = ContractionHierarchies.contract(graph, node3)
    assert(contracted.edges.size == 8)
  }

}