import org.scalatest.funsuite.AnyFunSuite

class DijkstraTest extends AnyFunSuite {

  val node1 = new GraphNode(1)
  val node2 = new GraphNode(2)
  val node3 = new GraphNode(3)
  val node4 = new GraphNode(4)
  val node5 = new GraphNode(5)
  val node6 = new GraphNode(6)

  val graph = new Graph(
    List(node1, node2, node3, node4, node5),
    List(
      new GraphEdge(node1, node2, 7), new GraphEdge(node2, node1, 7),
      new GraphEdge(node1, node3, 2), new GraphEdge(node3, node1, 1),
      new GraphEdge(node1, node4, 5), new GraphEdge(node4, node1, 5),
      new GraphEdge(node2, node3, 3), new GraphEdge(node3, node2, 3),
      new GraphEdge(node3, node4, 4), new GraphEdge(node4, node3, 4),
      new GraphEdge(node3, node5, 3), new GraphEdge(node5, node3, 3),
      new GraphEdge(node4, node5, 2), new GraphEdge(node5, node4, 2)
    )
  )

  test("Shortest path in an undirected graph") {
    assert(Dijkstra.distance(graph, node1, node1) == 0)
    assert(Dijkstra.distance(graph, node1, node5) == 5)
    assert(Dijkstra.distance(graph, node1, node2) == 5)
    assert(Dijkstra.distance(graph, node1, node4) == 5)
    assert(Dijkstra.distance(graph, node1, node6) == Double.PositiveInfinity)
  }

}