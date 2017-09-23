import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class myListArrayList implements myList {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private ArrayList<myPlayer> items; //See the use of a dynamic data structure: ArrayList

	//-------------------------------------------------------------------
	// Basic Operation 1. --> Create an empty myList: my_create_empty
	//-------------------------------------------------------------------
	//public myList my_create_empty();

	public myListArrayList(){
		this.items = new ArrayList<myPlayer>();
	}

	//-------------------------------------------------------------------
	// Basic Operation 2. --> Get number of elements in MyList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length(){
		return this.items.size();
	}
	
	//-------------------------------------------------------------------
	// Basic Operation 3. --> Get element at of MyList at a concrete position: my_get_element
	//-------------------------------------------------------------------
	public myPlayer my_get_element(int index){
		myPlayer value = null;
		
		try{			
			value = this.items.get(index);		
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to access");
		}
		
		return value;	
	}
	
	//-------------------------------------------------------------------
	// Basic Operation 4. --> Add element to MyList at a concrete position: my_add_element 
	//-------------------------------------------------------------------
	public void my_add_element(int index, myPlayer value){
		try{
			this.items.add(index, value);		
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to add");
		}		
	}
	
	//-------------------------------------------------------------------
	// Basic Operation 5. --> Remove element of MyList at a concrete position: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index){
		try{			
			this.items.remove(index);		
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to remove");
		}		
	}

	//-------------------------------------------------------------------
	// Extended Operation 1. --> Load a MyList from file: load_file
	//-------------------------------------------------------------------
	public void load_file(String s){				
		
		try {
			//1. We create the file variable
			File my_file = new File(s);
			Scanner sc = new Scanner(my_file);

			//2. We empty the list
			int size = this.my_get_length();
			for (int i = 0; i < size; i++)
				this.my_remove_element(0);
						
			//3. We fill MyList with the content of the file
			int count = 0;
			while (sc.hasNext()){
				myPlayer player = new myPlayer(sc.next(), sc.nextInt());
				this.my_add_element(count, player);
				count = count + 1;
			}
			
			//4. We close the scanner
			sc.close();

			System.out.println("Load Operation Completed");
		} 
		catch (Exception e) {
			System.out.println("Sorry but there is not such file");
		}	
	}

	//-------------------------------------------------------------------
	// Extended Operation 2. --> Display MyFile content: show_elements
	//-------------------------------------------------------------------
	public void show_elements(){
		int listSize = items.size();
		for(int i =0; i < listSize; i++ ){
    	System.out.print("\n"+ items.get(i) +"\n");
    }
	}
	
	//-------------------------------------------------------------------
	// Extended Operation 3. --> Check if element is in MyList: find_element
	//-------------------------------------------------------------------
	public int find_element(String s){
		int i = 0;				
		for ( i = 0; i < items.size(); i++) {
			  if (items.get(i).print_info() == i) {
			    return items.get(i);
			  }
			}
		return i;
	}

	//-------------------------------------------------------------------
	// Extended Operation 4. --> Show info of element in MyList: show_info
	//-------------------------------------------------------------------
	public void show_info(String s){
		myPlayer p1 = null;
		ArrayList<myPlayer> info = p1.print_info();
		for (myPlayer item : info) {   
		    s =item.get_name() + " " + item.get_goals();
		}
	}
	
	//-------------------------------------------------------------------
	// Extended Operation 5. --> Add new element to MyList: add_by_keyboard
	//-------------------------------------------------------------------
	public void add(int  i, String s){
   int size= this.my_get_length();
   myPlayer p = new myPlayer(s,i);
   this.my_add_element(size, p);
   System.out.println("Added to Array");
   }
    
	

	//-------------------------------------------------------------------
	// Extended Operation 6. --> Update element of MyList: update
	//-------------------------------------------------------------------
	public void update(int i, String s){
		 i =0;
		   int goals = 0;
		   boolean located = false; 
		   int size = this.my_get_length();
		   for(i =0; i < size;i++){
			   String title = this.my_get_element(i).get_name();
			   if(title.equalsIgnoreCase(s)){
				   this.my_get_element(i).set_goals(goals);
				   located = true;
				   System.out.println("Found");
			   }
		   }
		   if(located == false){
			   System.out.println("Not Found");
		   }
		    }
	
	//-------------------------------------------------------------------
	// Extended Operation 7. --> Remove element of MyList: remove_element
	//-------------------------------------------------------------------
	public void remove(String s){
     int i;
     boolean located =false;
     int size = this.my_get_length();
     for(i =0; i<size;i++){
    	 String title = this.my_get_element(i).get_name();
		   if(title.equalsIgnoreCase(s)){
			this.my_remove_element(i);
			   located = true;
			   System.out.println("Removed");
		   }
	   }
	   if(located == false){
		   System.out.println("Not Removed");
	   }
	    }
	//-------------------------------------------------------------------
	// Extended Operation 8. --> sort elements of MyList: bubble_sort
	//-------------------------------------------------------------------
	public void bubble_sort(){
		for(int i = 0; i < this.my_get_length(); i++){
		if(this.my_get_element(i+1).smaller(this.my_get_element(i))){
			this.my_add_element(i+2, this.my_get_element(i));
			this.my_remove_element(i);
		}
			System.out.println("Section sorted");
		}
		}
	//-------------------------------------------------------------------
	// Extended Operation 9. --> Write a MyList to file: write_file
	//-------------------------------------------------------------------
	public void write_file(String s){
		FileWriter writer = new FileWriter("output.txt"); 
		for(myPlayer s: items) {
		  writer.myPlayer(s);
		}
		writer.close();
	}

	@Override
	public myList my_create_empty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void myArrayList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(String s, int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void my_add_element(int index, Object element) throws myException {
		// TODO Auto-generated method stub
		
	}
		
}


