trait Node {
  def id: Int
  override def hashCode(): Int = id
  override def equals(obj: Any): Boolean = hashCode() == obj.hashCode()
}