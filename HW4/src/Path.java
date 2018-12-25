//----------------------------------------------------------------------
// Flights.java           by Dale/Joyce/Weems                  Chapter 9
//
// Supports flight objects having a "from" vertex, a "to" vertex, and a
// distance. Allows flights to be compared based on their distances.
//----------------------------------------------------------------------



public class Path implements Comparable<Path>
{
  protected Intersection fromVertex;
  protected Intersection toVertex;
  protected int distance;

  public Path(Intersection fromVertex, Intersection toVertex, int distance)
  {
    this.fromVertex = fromVertex;
    this.toVertex = toVertex;
    this.distance = distance;
  }

  public Intersection getFromVertex()
  {
    return fromVertex;
  }
  
  public Intersection getToVertex()
  {
    return toVertex;
  }
  
  public int getDistance()
  {
    return distance;
  }
  
  public void setFromVertex(Intersection vertex)
  {
    fromVertex = vertex;
  }

  public void setToVertex(Intersection vertex)
  {
    toVertex = vertex;
  }

  public void setDistance(int distance)
  {
    this.distance = distance;
  }

  public int compareTo(Path other)
  {
    return (other.distance - this.distance); // shorter is better 
  }
  
  @Override
  public String toString()
  {
    return (fromVertex + "    " + toVertex + "    " + distance);
  }
}
 