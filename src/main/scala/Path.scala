class Path(val nodes: Array[GraphNode], val weight: Double) {
  val path_length: Int = nodes.length

  def this(edges: List[GraphEdge]) = {
    this(
      (edges.head.a :: edges.map(edge => edge.b)).toArray,
      edges.map(edge => edge.weight).sum
    )
  }

  def first_node(): GraphNode = nodes(0)
  def last_node(): GraphNode = nodes(path_length - 1)

  def to_edge(): GraphEdge = new GraphEdge(first_node(), last_node(), weight)

}