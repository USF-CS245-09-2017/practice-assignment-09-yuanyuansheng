
public interface Graph {
	
	// These functions are vestigial (used in P8, not used in P9). These can be left unimplemented.
	public void addEdge(int v1, int v2);
	public void topologicalSort();
	

	// These functions have been added to P9.
	public void addEdge(int v1, int v2, int weight);
	public int getEdge(int v1, int v2);
	public int createSpanningTree();

}
