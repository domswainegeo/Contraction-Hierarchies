import scala.collection.mutable

object Dijkstra {

  def distance(graph: Graph, a: Node, b: Node): Double = {
    val dist: mutable.Map[Node, Double] = mutable.Map[Node, Double]()
    val queue: mutable.PriorityQueue[Node] = new mutable.PriorityQueue[Node]()(Ordering[Double].on(dist).reverse)
    val expanded: mutable.HashSet[Node] = new mutable.HashSet[Node]()

    dist(b) = Double.PositiveInfinity
    dist(a) = 0
    queue.addOne(a)

    while(!expanded.contains(b) && queue.nonEmpty){
      val node: Node = queue.dequeue()
      expanded.add(node)
      graph.get_outgoing().getOrElse(node, new Array[Edge](0)).foreach(edge => {
        val adjacent_node = edge.b
        val adjacent_node_distance = dist(node) + edge.weight
        if(!dist.contains(adjacent_node) || adjacent_node_distance < dist(adjacent_node)){
          dist.addOne(adjacent_node -> adjacent_node_distance)
          queue.enqueue(adjacent_node)
        }
      })
    }
    dist(b)
  }

}