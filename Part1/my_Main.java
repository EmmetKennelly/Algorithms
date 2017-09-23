import java.util.Scanner;

public class my_Main {

	//-------------------------------------
	//
	// ASSIGNMENT METHODS 
	//
	//-------------------------------------	
	
	//-------------------------------------
	// EXERCISE 01 
	//-------------------------------------	
	public static int getMaxValue(myStack<Integer> s){
		if (s.my_is_empty()) {
			return Integer.MAX_VALUE;
		}
		else{
			return s.my_peek();
		}
		
	}
	//-------------------------------------
	// tailGetMaxValue 
	//-------------------------------------	
	public static int tailGetMaxValue(myStack<Integer> s){
		//1. We create the output variable 
		int res = 0; 
		
		//2. We make a clean copy of the stack, so that we can screw its information.
		myStack<Integer> new_stack = stack_copy(s);
		
		//3. We use the additional function extra2 to get the max value of the stack in a tail recursive manner.
		res = extra02(new_stack, 0);
		
		//4. We return the output variable
		return res;
	}
		
	//-------------------------------------
	// EXERCISE 02 
	//-------------------------------------	
	public static int extra02(myStack<Integer> s, int max){
		if(s.my_is_empty()){
			return max;
		}
		int num = s.my_peek();
		s.my_pop();
		if(num >max){
			num=max;
		}
	return extra02(s ,max);
	}
	//-------------------------------------
	// EXERCISE 03 
	//-------------------------------------	
	public static int getNumAppearances(myList<String> l, String word){
		int res = 0;
		 for(int i = 0; i < l.my_get_length(); i++){
			 if (l.my_get_element(i) == word){
				 res++;
			 }
		 }
		return res;

			
	}
	//-------------------------------------
	// tailGetNumAppearances 
	//-------------------------------------	
	public static int tailGetNumAppearances(myList<String> l, String word){
		//1. We create the output variable 
		int res = 0; 
		
		//2. We compute the length of the list.
		int len = l.my_get_length();
		
		//3. We use the additional function extra04 to get the number of appearances of word in the list in a tail recursive manner.
		res = extra04(l, word, len, 0);
		
		//4. We return the output variable
		return res;
	}

	//-------------------------------------
	// EXERCISE 04
	//-------------------------------------	
	public static int extra04(myList<String> l, String word, int index, int accum){
		return accum;
		if(index == 0){
			return accum;
		}
		else{
			
			String word2 = l.my_get_element(word,index);	
			if(word2.equals(word)){
				
			accum++;
		}}
	return extra04(l, word, accum, accum);
	}	
	
	//-------------------------------------
	// EXERCISE 05 
	//-------------------------------------	
	public static int n_toThePowerof_m(int n, int m){
		int res;
	    int x;
	    if (n == 0) return 1;
	    if (n % 2 == 0) {
	        x = n_toThePowerof_m(m, n / 2);
	        return x * x;
	    } else return m * n_toThePowerof_m(m, n - 1);		
	}
	
	//-------------------------------------
	// tail_n_toThePowerof_m 
	//-------------------------------------	
	public static int tail_n_toThePowerof_m(int n, int m){
		//1. We create the output variable 
		int res = 0; 
		
		//2. We use the additional function extra06 to compute n to the poewr of m in a tail recursive manner.
		res = extra06(n, m, 1);
		
		//4. We return the output variable
		return res;
	}

	//-------------------------------------
	// EXERCISE 06
	//-------------------------------------	
	public static int extra06(int n, int m, int accum){
   if(m<=0){
	   return accum;
   }
   else{
	   return extra06(n, m-1, accum*n);
   }
	}	
		
	//-------------------------------------
	// EXERCISE 07 
	//-------------------------------------	
	public static void convert(int num) {
	
	        if(num > 0)
	        {
	            int a = num % 2;
                num = num / 2;
	            return a + "" + convert(num);
	        }
	        return;
	    
	
	}
		
	//-------------------------------------
	// EXERCISE 08 
	//-------------------------------------	
	public static void draw_image(int num, int totalSize) {
  String s1 = "       ";
  String s2 ="*";
  
		
		if (num==1 || num< 1){
	for(int i=1; i<totalSize-1; i++){
		System.out.println(s1);
		
	}
	System.out.println(s2);
	}
		else{
	   for(int i = 1; i< totalSize - 1;++i){
		   System.out.println(s1);
	   }
	   System.out.println(s2);
	   totalSize++;
	   num--;
	   
		}
		 draw_image(num, totalSize);
		}
	
	//-------------------------------------
	//
	// EXTRA METHODS 
	//
	//-------------------------------------	
	
	//-------------------------------------
	//	stack_copy 
	//-------------------------------------	
	public static myStack<Integer> stack_copy(myStack<Integer> s){
		//1. We create the stack to be returned
		myStack<Integer> new_s = new myStack_as_myList<Integer>(1);
		
		//2. We move the stack to a myList
		
		//2.1. We create the auxiliary list where we will put the elements from the stack 
		myList<Integer> m = new myListArrayList<Integer>();
		
		//2.2. We also count how many elements are in the stack
		int count = 0; 
		
		//2.3. While there are elements in the stack
		while (s.my_is_empty() == false){
			
			//2.3.1. Get the value of the top one
			int value = s.my_peek();
			
			//2.3.2. Add it at the beginning of the list 
			m.my_add_element(0, value);
			
			//2.3.3. Remove it from the stack
			s.my_pop();
			
			//2.3.4. Add one to the number of elements that were on the original stack
			count++;
		}
		
		//3. We populate again the current and the new stack.
		
		//3.1. As we know how many elements there were in the stack, 
		//we just use a for loop to bring each of them back to the old and new stack 
		for (int i = 0; i < count; i++){
			//3.1.1. We get the element to be added to the stacks 
			int value = m.my_get_element(i);
			
			//3.1.2. We add it to the old and new stacks
			s.my_push(value);
			new_s.my_push(value);
		}
		
		//4. We return the new stack 
		return new_s;
	}
		
	//-------------------------------------------------------------------
	// selectOption
	//-------------------------------------------------------------------
	public static int selectOption(Scanner sc){
		int option = 0;
			
		System.out.println("------------------------------------");
		System.out.println("			    MENU				");
		System.out.println("------------------------------------");
		System.out.println("1. Ex01");
		System.out.println("2. Ex02");
		System.out.println("3. Ex03");
		System.out.println("4. Ex04");
		System.out.println("5. Ex05");
		System.out.println("6. Ex06");
		System.out.println("7. Ex07");
		System.out.println("8. Ex08");
		System.out.println("0. Exit");
		
		boolean selected = false;
		
		while (selected == false){
			System.out.println("Please enter an option");
			try {
				option = sc.nextInt();
				sc.nextLine();
				if ((option >= 0) && (option <= 8))
					selected = true;
				else
					System.out.println("Sorry but the option must be 0..8");
				
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a valid option");
				sc.next();
			}		
		}
				
		return option;
	}
	
	//-------------------------------------
	// interactiveSession 
	//-------------------------------------	
	public static void interactiveSession(){
		//1. We create the scanner to read in from the user input
		Scanner sc = new Scanner(System.in);				
		
		//2. We create the variable to determine when to close the session
		boolean finish = false;
					
		//3. While the session is on
		while (finish == false){

			//3.1. We clear the screen
			for (int i = 0; i < 100; i++)
				System.out.println();
			
			//3.2. Ask for the exercise to be tried
			int option = selectOption(sc);
			
			//3.3. Perform the exercise
			switch (option){
			case 1: //Ex01

				//3.3.1.1. Set the scene for exercise 01
				myStack<Integer> s01 = new myStack_as_myList<Integer>(1);

				myStack<Integer> s02 = new myStack_as_myList<Integer>(1);
				s02.my_push(5);
				s02.my_push(9);
				s02.my_push(7);

				//3.3.1.2. Run exercise 01
				int max01 = getMaxValue(s01);
				int max02 = getMaxValue(s02);
				
				//3.3.1.3. Display the results of exercise 01
				System.out.println("\n-----------\nResults of Exercise 01\n-----------\n");
				System.out.println("Max of stack s01");
				System.out.println(max01);
				System.out.println("Max of stack s02");
				System.out.println(max02);
				
				System.out.println("Press any key to continue");
				sc.nextLine();
				break;

			case 2: //Ex02

				//3.3.2.1. Set the scene for exercise 01
				myStack<Integer> s03 = new myStack_as_myList<Integer>(1);

				myStack<Integer> s04 = new myStack_as_myList<Integer>(1);
				s04.my_push(5);
				s04.my_push(9);
				s04.my_push(7);

				//3.3.2.2. Run exercise 02
				int max03 = tailGetMaxValue(s03);
				int max04 = tailGetMaxValue(s04);
				
				//3.3.2.3. Display the results of exercise 01
				System.out.println("\n-----------\nResults of Exercise 02\n-----------\n");
				System.out.println("Max of stack s03");
				System.out.println(max03);
				System.out.println("Max of stack s04");
				System.out.println(max04);
				
				System.out.println("Press any key to continue");
				sc.nextLine();
				break;

			case 3: //Ex03

				//3.3.3.1. Set the scene for exercise 03
				myList<String> l01 = new myListArrayList<String>();

				myList<String> l02 = new myListArrayList<String>();
				l02.my_add_element(0, "Hello");
				l02.my_add_element(1, "Goodbye");
				l02.my_add_element(2, "Hello");
				l02.my_add_element(3, "Goodbye");
				l02.my_add_element(4, "Hello");
				
				//3.3.3.2. Run exercise 03
				int num01 = getNumAppearances(l01, "Hello");
				int num02 = getNumAppearances(l02, "Hello");
				
				//3.3.1.3. Display the results of exercise 01
				System.out.println("\n-----------\nResults of Exercise 03\n-----------\n");
				System.out.println("Num of appearances of Hello in l01");
				System.out.println(num01);
				System.out.println("Num of appearances of Hello in l02");
				System.out.println(num02);
				
				System.out.println("Press any key to continue");
				sc.nextLine();
				break;
				
			case 4: //Ex04
				
				//3.3.4.1. Set the scene for exercise 03
				myList<String> l03 = new myListArrayList<String>();

				myList<String> l04 = new myListArrayList<String>();
				l04.my_add_element(0, "Hello");
				l04.my_add_element(1, "Goodbye");
				l04.my_add_element(2, "Hello");
				l04.my_add_element(3, "Goodbye");
				l04.my_add_element(4, "Hello");
				
				//3.3.4.2. Run exercise 04
				int num03 = tailGetNumAppearances(l03, "Hello");
				int num04 = tailGetNumAppearances(l04, "Hello");
				
				//3.3.4.3. Display the results of exercise 04
				System.out.println("\n-----------\nResults of Exercise 04\n-----------\n");
				System.out.println("Num of appearances of Hello in l03");
				System.out.println(num03);
				System.out.println("Num of appearances of Hello in l04");
				System.out.println(num04);
				
				System.out.println("Press any key to continue");
				sc.nextLine();
				break;
				
			case 5: //Ex05
				
				//3.3.5.1. Set the scene for exercise 05
				int n1 = 2;
				int m1 = 0; 
				int m2 = 4;
				
				//3.3.5.2. Run exercise 05
				int pow01 = n_toThePowerof_m(n1, m1);
				int pow02 = n_toThePowerof_m(n1, m2);
				
				//3.3.1.3. Display the results of exercise 05
				System.out.println("\n-----------\nResults of Exercise 05\n-----------\n");
				System.out.println("2 to the power of 0 is:");
				System.out.println(pow01);
				System.out.println("2 to the power of 4 is:");
				System.out.println(pow02);
				
				System.out.println("Press any key to continue");
				sc.nextLine();
				break;
				
			case 6: //Ex06
				
				//3.3.6.1. Set the scene for exercise 06
				int n2 = 2;
				int m3 = 0; 
				int m4 = 4;
				
				//3.3.5.2. Run exercise 06
				int pow03 = tail_n_toThePowerof_m(n2, m3);
				int pow04 = tail_n_toThePowerof_m(n2, m4);
				
				//3.3.1.3. Display the results of exercise 06
				System.out.println("\n-----------\nResults of Exercise 06\n-----------\n");
				System.out.println("2 to the power of 0 is:");
				System.out.println(pow03);
				System.out.println("2 to the power of 4 is:");
				System.out.println(pow04);
				
				System.out.println("Press any key to continue");
				sc.nextLine();
				break;

			case 7: //Ex07
				
				//3.3.7.1. Set the scene for exercise 07
				int num05 = 4;
				int num06 = 27; 
				
				//3.3.7.2. Run exercise 07
				//draw_image(val01, val02);
				//draw_image(val02, val01);
				
				//3.3.7.3. Display the results of exercise 07
				System.out.println("\n-----------\nResults of Exercise 07\n-----------\n");
				System.out.println("The binary representation of 4 is:");
				convert(num05);
				System.out.println("\nThe binary representation of 27 is:");
				convert(num06);
				
				System.out.println("\nPress any key to continue");
				sc.nextLine();
				break;

			case 8: //Ex08
				
				//3.3.8.1. Set the scene for exercise 08
				int val01 = 3;
				int val02 = 5; 
				
				//3.3.8.2. Run exercise 08
				//draw_image(val01, val02);
				//draw_image(val02, val01);
				
				//3.3.1.3. Display the results of exercise 08
				System.out.println("\n-----------\nResults of Exercise 08\n-----------\n");
				System.out.println("The sequence for 3 prints:");
				draw_image(val01, val02);
				System.out.println("\nThe sequence for 5 prints:");
				draw_image(val02, val01);
				
				System.out.println("\nPress any key to continue");
				sc.nextLine();
				break;
								
			default: //Exit option
				finish = true;
				break;
			}
		}
	}
	
	//-------------------------------------
	// MAIN 
	//-------------------------------------	
	public static void main(String[] args) {
		interactiveSession();
	}

}
