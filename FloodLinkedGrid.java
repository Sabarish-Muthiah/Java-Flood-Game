package code;

public class FloodLinkedGrid {
	private Node first;
	
	//Constructor, a method that automatically runs when the object is created
	public FloodLinkedGrid(int dimension) {
		//Setting up the first node in the top left corner
	
		Node temp = null;

		first = new Node(generateCount());
		Node cm = first; // cm --> column marker
		Node rm = first; // rm --> row marker
		
		for(int x = 0; x < dimension - 1; x++) {
			temp = new Node(generateCount());
			cm.setRight(temp);
			temp.setLeft(cm);
			cm = temp;
		}
		for(int q = 0; q < dimension - 1; q++) {
			//Building the first node in a row
			temp = new Node(generateCount());
			temp.setUp(rm);
			rm.setDown(temp);
			cm = temp;
			rm = rm.getDown();
			
			for(int x = 0; x < dimension - 1; x++) {
				//Building the rest of the row
				temp = new Node(generateCount());
				cm.setRight(temp);
				temp.setLeft(cm);
				temp.setUp(cm.getUp().getRight());
				temp.getUp().setDown(temp);
				cm = temp;
			}
		}
	}
	public void display() {
		Node temp = first;
		Node rm = first;
		while(temp!= null) {
			while(temp != null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getRight();
			}
			System.out.println();
			temp = rm.getDown();
			rm = temp;
		}		
		 
	}
	public int generateCount() {
		return ((int)(Math.random() * (6 - 1 + 1)) + 1);
	}
	public void passInput(int userChoice) {
		int newColor = userChoice;
		floodProgram(newColor, first);
	}
	public void floodProgram(int newColor, Node node) {
		int oldColor = node.getData();
		
		if(newColor != oldColor) {
			node.setData(newColor);
			
			if(node.getUp() != null && node.getUp().getData() == oldColor) {
				floodProgram(newColor, node.getUp());
			}
			if(node.getRight() != null && node.getRight().getData()== oldColor) {
				floodProgram(newColor, node.getRight());
			}
			if(node.getDown() != null && node.getDown().getData() == oldColor) {
				floodProgram(newColor, node.getDown());
			}
			if(node.getLeft() != null && node.getLeft().getData() == oldColor) {
				floodProgram(newColor, node.getLeft());
			}
			
			/*ANOTHER WAY
			try{
				if(temp.getUp().getData() == oldNumber){
					flood(temp.getUp(), newNumber);
				}
			}
			catch(Exception e){}
			 */
		}
	}
	public boolean checkWin(int dimension) {
		Node rm = first;
		Node cm = first;
		boolean win = true;
		int color = cm.getData();;
		
		for(int x = 0; x < dimension-1; x++) {
			for(int y = 0; y < dimension-1; y++) {
				cm = cm.getRight();
				if(color != cm.getData()) {
					win = false;
					break;
				}
			}
			if(win == false) {
				break;
			}
			rm = rm.getDown();
			cm = rm;
		}
		
		return win;
	}
	
	/* CHECK WIN DIFFERENT CODE
	public boolean complete() {
		int number = first.getData();
		Node temp = first;
		Node rm = first;
		while(temp!= null) {
			while(temp != null) {
				if(temp.getData() != number) {
					return false;
				}
				temp = temp.getRight();
			}
			System.out.println();
			temp = rm.getDown();
			rm = temp;
		}
		return true;	
	}
	*/
}
