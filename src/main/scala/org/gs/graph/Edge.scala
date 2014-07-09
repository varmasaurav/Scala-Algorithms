/** @see http://algs4.cs.princeton.edu/43mst/Edge.java.html
 */
package org.gs.graph
/** Weighted Edge for graphs extends [[org.gs.graph.BaseEdge]]
 *  
 * @author Scala translation by Gary Struthers from Java by Robert Sedgewick and Kevin Wayne.
 * @param v vertex at one end of edge
 * @param w vertex at the other end of edge
 * @param weight of Edge uses scala.math.Ordered for comparison 
 */
class Edge(v: Int, w: Int, weight: Double) extends BaseEdge(v, w, weight) with Ordered[Edge] {

  /** @return edge's "from" vertex */
  def either(): Int = v

  /** @return the matchinf "from" or "to" vertex for @param vertex, error if no match */
  def other(vertex: Int): Int = vertex match {
    case `v` => w
    case `w` => v
    case _ => throw new IllegalArgumentException(s"Illegal endpoint vertex:${vertex}")
  }

  /** @return -1 if this < that, 0 if equal, +1 if > */
  def compare(that: Edge): Int = weight.compareTo(that.weight)

  /** @return true if @param other is an Edge */
  def canEqual(other: Any): Boolean = other.isInstanceOf[Edge]

  override def hashCode(): Int = 41 * ( 41 + v) + w + weight.hashCode

  override def equals(that: Any): Boolean = that match {
    case that: Edge => (that canEqual this) && this.hashCode == that.hashCode
  }
}
