class Graph(val nodes: List[Node], val edges: List[Edge]){
  private var incoming: Option[Map[Node, Array[Edge]]] = None
  private var outgoing: Option[Map[Node, Array[Edge]]] = None

  def get_incoming(): Map[Node, Array[Edge]] = {
    if(incoming.isEmpty){
      incoming = Some(edges.groupBy(edge => edge.b).map{case a -> b => a -> b.toArray})
    }
    incoming.get
  }

  def get_outgoing(): Map[Node, Array[Edge]] = {
    if(outgoing.isEmpty){
      outgoing = Some(edges.groupBy(edge => edge.a).map{case a -> b => a -> b.toArray})
    }
    outgoing.get
  }

  def remove_node(node_to_remove: Node): Graph = {
    val new_nodes: List[Node] = nodes.filter(node => !node.equals(node_to_remove))
    val new_edges: List[Edge] = edges.filter(edge => !edge.a.equals(node_to_remove) && !edge.b.equals(node_to_remove))
    new Graph(new_nodes, new_edges)
  }

}