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

}