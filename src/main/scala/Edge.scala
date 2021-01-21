trait Edge {
  def a: Node
  def b: Node
  def weight: Double
  override def hashCode(): Int = (a, b).hashCode()
  override def equals(obj: Any): Boolean = hashCode() == obj.hashCode()
}