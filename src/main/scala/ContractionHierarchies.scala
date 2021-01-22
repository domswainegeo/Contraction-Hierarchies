import scala.collection.mutable.ListBuffer

object ContractionHierarchies {

  def contract(graph: Graph, node: GraphNode): Graph = {
    val paths: Array[Path] = for (in <- graph.get_incoming(node); out <- graph.get_outgoing(node))
      yield new Path(List(in, out))
    val graph_without_node = graph.remove_node(node)
    val augmenting_edges: ListBuffer[GraphEdge] = new ListBuffer[GraphEdge]()

    paths.foreach(path => {
      val distance = Dijkstra.distance(graph_without_node, path.first_node(), path.last_node())
      if(path.weight < distance){
        augmenting_edges.addOne(path.to_edge())
      }
    })

    graph_without_node.add_edges(augmenting_edges.toList)
  }

}
