import org.scalatest.funsuite.AnyFunSuite

class DijkstraTest extends AnyFunSuite {

  class SimpleNode(val id: Int) extends Node {}
  class SimpleEdge(val a: Node, val b: Node, val weight: Double) extends Edge {}

  val node1 = new SimpleNode(1)
  val node2 = new SimpleNode(2)
  val node3 = new SimpleNode(3)
  val node4 = new SimpleNode(4)
  val node5 = new SimpleNode(5)

  val graph = new Graph(
    List(node1, node2, node3, node4, node5),
    List(
      new SimpleEdge(node1, node2, 7), new SimpleEdge(node2, node1, 7),
      new SimpleEdge(node1, node3, 2), new SimpleEdge(node3, node1, 1),
      new SimpleEdge(node1, node4, 5), new SimpleEdge(node4, node1, 5),
      new SimpleEdge(node2, node3, 3), new SimpleEdge(node3, node2, 3),
      new SimpleEdge(node3, node4, 4), new SimpleEdge(node4, node3, 4),
      new SimpleEdge(node3, node5, 3), new SimpleEdge(node5, node3, 3),
      new SimpleEdge(node4, node5, 2), new SimpleEdge(node5, node4, 2)
    )
  )

  test("Shortest path in an undirected graph") {
    assert(Dijkstra.distance(graph, node1, node1) == 0)
    assert(Dijkstra.distance(graph, node1, node5) == 5)
    assert(Dijkstra.distance(graph, node1, node2) == 5)
    assert(Dijkstra.distance(graph, node1, node4) == 5)
  }

}