
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class dbManagement implements myList {

	private  int i = 0;
	//--------------------------------------------------
	// Attribute
	//--------------------------------------------------
	int size;
	ArrayList<String> list = new ArrayList<String>();
	myList myList;
	myPlayer player;
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	public dbManagement(int mode){
	if(mode == 1){
		myList = new myListArrayList();
	}
	else if (mode == 2){
		myList = new myListLinkedList<myPlayer>();
		
	}
	else if (mode == 3){
		myList = new myListDoubleLinkedList<myPlayer>();
	}
	}
	
	//-------------------------------------------------------------------
	// 1. Problem Specific Operation --> Load a MyList from file: load_file
	//-------------------------------------------------------------------
	public List<String> load_file(String s){				
		 List<String> list = null;
		    URI uri = null;

		    try {
		        uri = ClassLoader.getSystemResource("example.txt").toURI();
		    } catch (URISyntaxException e) {
		       System.out.print("Failed to load file."+ e);
		    }

		    try (Stream<String> lines = Files.lines(Paths.get(uri))) {
		        list = lines.collect(Collectors.toList());
		    } catch (IOException e) {
		        System.out.print("File does not exists ."+ e);
		    }
		    return list;
		}
	

	//-------------------------------------------------------------------
	// 2. Problem Specific Operation --> Display MyFile content: show_elements
	//-------------------------------------------------------------------
	public void show_elements(){
     int size = myList.my_get_length();
     for( i =0; i< size; i++){
    	myList.my_get_length(i).print_info();
    	}
	}
	
	//-------------------------------------------------------------------
	// 3. Problem Specific Operation --> Check if element is in MyList: find_element
	//-------------------------------------------------------------------
	public int find_element(String s){
		int i =0;
		int size = myList.my_get_length();
		 for( i =0; i< size; i++){
	String name = myList.my_get_element(i).get_name();
	if(name.equalsIgnoreCase(s)){
		return i;
	}
	}
	}
	//-------------------------------------------------------------------
	// 4. Problem Specific Operation --> Show info of element in MyList: show_info
	//-------------------------------------------------------------------
	public void show_info(String s){
    int i = 0;
    String namePrint;
    String goalPrint;
    int size = myList.my_get_length();
    for( i =0; i< size; i++){
    	String name = myList.my_get_element(i).get_name();
    	 namePrint = ("Name :"+name+"\n");
    	int goal = myList.my_get_element(i).get_goals();
         goalPrint =("Goals:"+goal+"/n");
    	
	}
    s = namePrint +goalPrint;
	}
	//-------------------------------------------------------------------
	// 5. Problem Specific Operation --> Add new element to MyList: add_by_keyboard
	//-------------------------------------------------------------------
	public void add(String s, int i){
		int size= myList.my_get_length(i).get_name();
		   myPlayer p = new myPlayer(s,i);
		   this.my_add_element(size, p);
		   System.out.println("Added to Array");
		   }
	

	//-------------------------------------------------------------------
	// 6. Problem Specific Operation --> Update element of MyList: update
	//-------------------------------------------------------------------
	public void update(String s, int g){
    int i =0;
    boolean locate = false;
    int size = myList.my_get_length(i).get_name();
    for (i = 0; i <size; i++){
    	String name = myList.my_get_element(i).get_name();
    	if (name.equalsIgnoreCase(s)){
    		myList.my_get_element(i).set_goals(g);
    		locate = true;
    		System.out.print("Done");
    		break;
    	}
    	if (locate == false ){
    		System.out.print("Not Found");
    	}
	}
	
	//-------------------------------------------------------------------
	// 7. Problem Specific Operation --> Remove element of MyList: remove_element
	//-------------------------------------------------------------------
	public void remove(String s){
		int i =0;
	    boolean locate = false;
	    int size = myList.my_get_length(i).get_name();
	    for (i = 0; i <size; i++){
	    	String name = myList.my_get_element(i).get_name();
	    	if (name.equalsIgnoreCase(s)){
	    		this.my_remove_element(i);
	    		locate = true;
	    		System.out.print("Done");
	    		break;
	    	}
	    	if (locate == false ){
	    		System.out.print("Not Found");
	    	}
		}
	}
	
	//-------------------------------------------------------------------
	// 8. Problem Specific Operation --> sort elements of MyList: bubble_sort
	//-------------------------------------------------------------------
	public void bubble_sort(){
    for(int num=0; num < myList.my_get_length(); num++){
    	 if(((myPlayer) myList.my_get_element(num+1)).smaller(player)) myList.my_add_element(num, myList);
    	 {
    		 myList.my_add_element(num+2, myList.my_get_element(num));
    		 myList.my_remove_element(num);
    	 }
    }
    	
    	System.out.print("Completed");
    	
	}
	
	//-------------------------------------------------------------------
	// 9. Problem Specific Operation --> Write a MyList to file: write_file
	//-------------------------------------------------------------------
	public void write_file(String s){
		FileWriter writer = new FileWriter("output.txt");
		try {
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} 
		for(String s: list) {
			  writer.player(s);
			}
			writer.close();
		}
	}		
	
}
