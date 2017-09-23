import java.util.LinkedList;
import java.util.List;

public  class myListDoubleLinkedList<T>  {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private myNode T;
	private static int counterNo;
	private myNode<T> Lnode;
	private myNode <T> Rnode;
	List<myNode> doubleLists = new LinkedList<myNode>();
	//-------------------------------------------------------------------
	// Basic Operation --> Create an empty myList: my_create_empty
	//-------------------------------------------------------------------
	//public myList my_create_empty(){}

	public myListDoubleLinkedList(){
		Lnode = new myNode(T);
	    Rnode = new myNode(T);
	}
	//-------------------------------------------------------------------
	// Basic Operation --> Get number of integers in myList: my_get_length
	//-------------------------------------------------------------------	
	public <T> int my_get_length(int index) throws myException{
		
        int count = 0;
        myNode current = null;
        while(!current.getInfo()){

            current.getLeft();
            count++;
        }

        for(int i = 0; i < count; i++) {  
            this.push(current.setInfo(i));
        }
        return count;   

	}

	//-------------------------------------------------------------------
	// Basic Operation --> Get integer of myList at a concrete index: my_get_element
	//-------------------------------------------------------------------
	public <T> Object my_get_element(int index) throws myException{
		if (index < 0){
			return null;
		}
		myNode current = null;
		
		if (Lnode != null) {
			current = Lnode.getLeft();
			for (int i = 0; i < index; i++) {
				if (current.getLeft() == null)
					return null;
 
				current = current.getLeft();
			}
			return current.getInfo();
		}else{
			current = Rnode.getRight();for (int i = 0; i < index; i++) {
				if (current.getRight() == null)
					return null;
 
				current = current.getRight();
			}
			return current.getInfo();
		}
		
 
	}
 
	
	//-------------------------------------------------------------------
	// Basic Operation --> Add integer to myList at a concrete index: my_add_element 
	//-------------------------------------------------------------------
	public void my_add_element(int index,myNode T ,myNode newnode) throws myException{
		if (Lnode == null) {
			Lnode = new myNode(newnode);
		}
		myNode temp = new myNode(newnode);
		myNode current = Lnode;
		if (current != null ){
		while(current.getLeft() != null){
			current = current.getLeft();
		}
		current.setLeft(temp);
		
		while(current.getRight() != null){
			current = current.getRight();
		}
		current.setRight(temp);
		}
		counterNo++;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Remove index of myList: my_remove_element 
	//-------------------------------------------------------------------	
	public <T> void my_remove_element(int index) throws myException{
		myNode current = Lnode;
		for (int i =0; i< index;i++){
			if (index < 0 || index > counterNo){
				System.out.print("index out of bounds");
				return;
				
			}else if (current == null ){
				System.out.print("This list is empty");
				return;
			}else if (i == index -1){
				myNode<T>Lnode = current.getRight();
				myNode<T>Rnode = current.getLeft();
				Rnode.setRight(Rnode);
				Lnode.setLeft(Lnode);
				return;
			}
			}
			current = current.getRight();
			counterNo -= 1;
		}
}
