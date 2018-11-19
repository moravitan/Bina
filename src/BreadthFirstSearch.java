import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	List<ASearchNode> open;
	List<ASearchNode> closed;

	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot(IProblemState problemState){
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() {
	    open = new ArrayList<>();
	    closed = new ArrayList<>();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node){
	    if(open.contains(node)){
	        return node;
        }
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node){
		return open.contains(node);
	}
	
	@Override
	public boolean isClosed(ASearchNode node) {
	    return closed.contains(node);
	}

	@Override
	public void addToOpen (ASearchNode node) {
	    open.add(node);
		
	}

	@Override
	public void addToClosed (ASearchNode node) {
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
	    ASearchNode best = open.remove(0);
	    return best;
	}

	

}
