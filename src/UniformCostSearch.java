import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearch   extends ASearch
{
	// Define lists here ...
	PriorityQueue<ASearchNode> open;
	List<ASearchNode> closed;

	
	@Override
	public String getSolverName() 
	{
		return "UCS";
	}

	@Override
	public ASearchNode createSearchRoot(IProblemState problemState) {
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() {
		open = new PriorityQueue<>(new UCSComparator());
		closed = new ArrayList<>();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node) {
		if(open.contains(node))
			return node;
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node)
	{
		if(open.contains(node))
			return true;
		return false;
	}
	
	@Override
	public boolean isClosed(ASearchNode node) {
		if(closed.contains(node))
			return true;
		return false;
	}

	@Override
	public void addToOpen(ASearchNode node) {
		open.add(node);
	}

	@Override
	public void addToClosed(ASearchNode node) {
		closed.add(node);
	}

	@Override
	public int openSize() 
	{
		return open.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return open.remove();
	}

}

class UCSComparator implements Comparator<ASearchNode> {

	// Overriding compare()method of Comparator
	public int compare(ASearchNode node1, ASearchNode node2) {
		if (node1.getG() < node2.getG())
			return -1;
		else if (node1.getG() > node2.getG())
			return 1;
		return 0;
	}


}

