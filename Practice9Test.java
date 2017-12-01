
public class Practice9Test {
	
	
	public Practice9Test() {
		// TODO: Need to create an instance?
	}
	

	public Graph getGraph(int size) {
		return new GraphAdjMatrix(size);
	}

	
	public boolean createGraphTest() {
		// Just create a graph and expect it not to blow up...
		try {
			Graph g = getGraph(2);
			g.addEdge(0, 1, 100);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	public boolean addEdgeTest() {
		Graph g = getGraph(3);
		
		g.addEdge(0,  1, 5);
		g.addEdge(0, 2, 3);
		
		return g.getEdge(0, 1) == 5 && g.getEdge(0, 2) == 3;
	}
	
	
	public boolean spanningTreeTest() {
		Graph g = getGraph(5);
		
		g.addEdge(0, 1, 9);
		g.addEdge(0, 2, 12);
		g.addEdge(1, 2, 6);
		g.addEdge(1, 4, 20);
		g.addEdge(1, 3, 18);
		g.addEdge(2, 4, 15);
		g.addEdge(3, 4, 19);
		
		// The spanning tree over this graph has a weight of 48.
		if (g.createSpanningTree() != 48) {
			return false;
		}
		// Once the spanning tree is created, only these edges remain:
		if ((g.getEdge(0, 1) != 9) ||
				(g.getEdge(1, 2) != 6) ||
				(g.getEdge(1, 3) != 18) ||
				(g.getEdge(2, 4) != 15))
			return false;
		return true;
	}
	
	
	public void runTest () {
		int grade = 0;
		
		if (createGraphTest()) {
			grade += 20;
			System.out.println("[+20%] Passed create graph test");
		} else {
			System.out.println("[    ] Failed create graph test");
		}
		
		if (addEdgeTest()) {
			grade += 35;
			System.out.println("[+35%] Passed adding edge / check neighbours test");
		} else {
			System.out.println("[    ] Failed adding edge / check neighbours test");
		}
		
		if (spanningTreeTest()) {
			grade += 45;
			System.out.println("[+45%] Passed spanning tree test");
		} else {
			System.out.println("[    ] Passed spanning tree test");
		}
		
		System.out.println("Grade for this assignment: " + grade + "%");
	}

	public static void main(String[] args) {
		Practice9Test test = new Practice9Test();
		test.runTest();
	}

}
