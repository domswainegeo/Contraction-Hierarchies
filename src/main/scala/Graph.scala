class Graph(val nodes: Set[GraphNode], val edges: Set[GraphEdge]){
  private var incoming: Option[Map[GraphNode, Array[GraphEdge]]] = None
  private var outgoing: Option[Map[GraphNode, Array[GraphEdge]]] = None

  def this(nodes: List[GraphNode], edges: List[GraphEdge]) = {
    this(nodes.toSet, edges.toSet)
  }

  def get_incoming(): Map[GraphNode, Array[GraphEdge]] = {
    if(incoming.isEmpty){
      incoming = Some(edges.groupBy(edge => edge.b).map{case a -> b => a -> b.toArray})
    }
    incoming.get
  }

  def get_incoming(node: GraphNode): Array[GraphEdge] = get_incoming().getOrElse(node, new Array[GraphEdge](0))

  def get_outgoing(): Map[GraphNode, Array[GraphEdge]] = {
    if(outgoing.isEmpty){
      outgoing = Some(edges.groupBy(edge => edge.a).map{case a -> b => a -> b.toArray})
    }
    outgoing.get
  }

  def get_outgoing(node: GraphNode): Array[GraphEdge] = get_outgoing().getOrElse(node, new Array[GraphEdge](0))

  def remove_node(node_to_remove: GraphNode): Graph = {
    val new_nodes: Set[GraphNode] = nodes.filter(node => !node.equals(node_to_remove))
    val new_edges: Set[GraphEdge] = edges.filter(edge => !edge.a.equals(node_to_remove) && !edge.b.equals(node_to_remove))
    new Graph(new_nodes, new_edges)
  }

  def add_edges(edges_to_add: List[GraphEdge]): Graph = new Graph(nodes, edges ++ edges_to_add)

}