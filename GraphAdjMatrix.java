import java.util.Stack;

public class GraphAdjMatrix implements Graph {

	private int[][] edges; // collection of edges
	private int size;
	private int V;

	// constructor
	public GraphAdjMatrix(int vertices) {
		size = vertices;
		this.V = vertices;
		edges = new int[size][size];
	}

	public void addEdge(int v1, int v2) {
		edges[v1][v2] = 1;
		edges[v2][v1] = 1;
		size++;
	}

	public void addEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		size++;

	}

	public void topologicalSort() {

		boolean[] visited = new boolean[edges.length];

		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				dfSearch(i, visited);
			}
		}

	}

	private void dfSearch(int vertex, boolean[] visited) {

		Stack<Integer> s = new Stack<Integer>();
		s.push(new Integer(vertex));

		while (!s.empty()) {

			int pop = s.pop();
			visited[vertex] = true;
			int[] neighbors = neighbors(pop);

			for (int i = 0; i < neighbors.length; i++) {
				if (visited[neighbors[i]] == false) {
					s.push(new Integer(neighbors[i]));
					visited[neighbors[i]] = true;
				}
			}
		}

	}

	public int[] neighbors(int vertex) {

		int[] vertexs = new int[outDegree(vertex)];
		int index = 0;

		for (int i = 0; i < edges.length; i++) {
			if (edges[vertex][i] == 1) {
				vertexs[index] = i;
				index++;
			}
		}
		return vertexs;
	}

	private int outDegree(int vertex) {
		int degree = 0;
		for (int i = 0; i < edges.length; i++) {
			if (edges[vertex][i] != Integer.MAX_VALUE && edges[vertex][i] != 0) {
				degree++;
			}
		}
		return degree;
	}

	public int getEdge(int v1, int v2) {
		return edges[v1][v2];
	}

	public int createSpanningTree() {
		return primMST(edges);
	}

	private int minKey(int key[], Boolean mstSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}

	private int primMST(int graph[][]) {

		int parent[] = new int[V];
		int key[] = new int[V];
		Boolean mstSet[] = new Boolean[V];

		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		key[0] = 0;
		parent[0] = -1;

		for (int count = 0; count < V - 1; count++) {
			int u = minKey(key, mstSet);

			mstSet[u] = true;
			for (int v = 0; v < V; v++) {
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}

		}

		int result = 0;
		for (int i = 1; i < V; i++) {
			result += graph[i][parent[i]];
		}

		return result;
	}

}