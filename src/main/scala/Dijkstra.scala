import scala.collection.mutable

object Dijkstra {

  def distance(graph: Graph, a: GraphNode, b: GraphNode): Double = {
    val dist: mutable.Map[GraphNode, Double] = mutable.Map[GraphNode, Double]()
    val queue: mutable.PriorityQueue[GraphNode] = new mutable.PriorityQueue[GraphNode]()(Ordering[Double].on(dist).reverse)
    val expanded: mutable.HashSet[GraphNode] = new mutable.HashSet[GraphNode]()

    dist(b) = Double.PositiveInfinity
    dist(a) = 0
    queue.addOne(a)

    while(!expanded.contains(b) && queue.nonEmpty){
      val node: GraphNode = queue.dequeue()
      expanded.add(node)
      graph.get_outgoing(node).foreach(edge => {
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