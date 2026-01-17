package tutor;
import java.util.*;


class User  {
	 static List<User> st= new ArrayList<>();
	private String bookname;
	private String authorname;
	User(String bookname , String authorname){
		this.bookname = bookname;
		this.authorname = authorname;

		
	}
	
	
	public String getBookname() {
		return bookname;
	}


	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public String getAuthorname() {
		return authorname;
	}


	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String toString() 
	{
		return " \n bookname : "+getBookname()+" \n authorname  : "+getAuthorname();
	}
	
	
  
    
	static void user(Scanner scan) {
	
	     
		
		System.out.println("Logged as student");
		addBook(scan);
	    
		while(true) {
			System.out.println("1. Borrow book \n 2. Return book \n 3. Display books  \n 4 Exit");
			int choice1 = scan.nextInt();
			scan.nextLine();
			switch(choice1) {
			case 1 :
			    	  Logged.logged(scan);
				break;
			case 2:
				
					Logged.Return(scan);
				
				break;
			case 3:
				
				DisplayBook();
				break;
		
			case 4:
				exit();
				return;
				default:
					System.out.println("Oops it is wrong");
			}
		}
		
	}
	static void addBook(Scanner scan) {
		st.add(new User("stranger Things","suba"));
		st.add(new User("stranger","subadharshana"));
		st.add(new User("Things","suba"));
		st.add(new User("special Things","dharshna"));
		st.add(new User("stranger 2.0","sudharshana"));
		
	}
	
	
    static int count =0;
	static void BorrowBook(Scanner scan) {
	 while(true) {
		boolean found = false;
		if(count<3) {
		scan.nextLine();
		System.out.println("Enter the book name");
		String bookname = scan.nextLine();
	    System.out.println("Enter the author name");
	    String authorname  = scan.nextLine();
		Iterator<User> it = st.iterator();
		while(it.hasNext()) {
			if(it.next().getBookname().equalsIgnoreCase(bookname)) {
				found = true;
				count++;
			    System.out.println(count);
				it.remove();
				return;
				
			}	
		}
	    
		if(!found) {
			System.out.println("Book not here");
			return;
			}
		 }
	 
	 else {
		 System.out.println("limted reached");
		 return;
	 }
	 }
	}
	
		

	static void ReturnBook(Scanner scan) {
		while(true) {
			if(count>0) {
		
		System.out.println("Enter the book name");
		String bookname = scan.nextLine();
		System.out.println("Enter the author name");
		String authorname = scan.nextLine();
		st.add(new User(bookname , authorname));
		count--;
		return;
			}
			else {
				System.out.println("No more return books");
				return;
			}
		}
		
		
	}
	static void DisplayBook() {
		if(st.isEmpty()) {
			System.out.println("there is no element");
		}
		else {
		for(User us:st) {
			System.out.println(us);
		}
		}
		
	}
	
	static void exit() {
		System.out.println("Thanking you");
	}
	static void AddBook(Scanner scan) {
		System.out.println("Enter  the book name");
		String bookname =scan.nextLine();
		System.out.println("Enter the author name");
		String authorname = scan.nextLine();
    	st.add(new User(bookname , authorname));
    	System.out.println("ADDED SUCCESSFULLY");
	}
	
	
}
class Librarian {
	private String name;
	Librarian(String name){
		this.name = name;
		
	}
	
	


	public  String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "name"+getName();
		}


	static   List<Librarian> ad = new ArrayList<>();
	  static void admin(Scanner scan) {
		  Logged.Adduser();
			User.addBook(scan);
		  while(true) {
			 
			  System.out.println(" 1. Add user \n 2.  View user \n 3. Search user \n 4.delete user \n 5.Viewbook   \n 6. AddBook  \n 7. Exit ");
			  int choice = scan.nextInt();
			  scan.nextLine();
			  switch(choice) {
			  case 1:
				  AddUser(scan);
				  break;
			  case 2:
				  Logged. ViewUser();
				
				  break;
			  case 3:
				 Logged. searchUser(scan);
				  break;
			  case 4:
				   Logged.DeleteUser(scan);
				  break;
			  case 5:
				  User.DisplayBook();
				  break;
			  case 6:
				  User.AddBook(scan);
				  break;
			 
			  case 7:
				  User.exit();
				  return ;
				  
				  
				  
			  }
			
			  }
		  
		  }
	
	  static void AddUser(Scanner scan) {
		
				  Logged.login(scan);
				 
			
		  
		 
	  }
	  
	 	  
		  }
 class Logged extends Librarian{
	 private int id;
	
	 Logged(String name, int id){
		 super(name);
		 this.id= id;
	
	 }
	 
	 public  int getId() {
		return id;
	}
	 public void setId(int id) {
		 this.id = id;
	 }
	
	 static ArrayList<Logged> lg = new  ArrayList<>();
	
	 static void login(Scanner scan) {
		 System.out.println("Enter the student id");
		 int id = scan.nextInt();
		 scan.nextLine();
		 boolean found = false;
		 for(Logged ll :lg) {
			 if(ll.getId()==id) {
				 System.out.println("you are already logged in");
				 found = true;
			
				 
			 }
			
			
		 }
		 if(!found) {
			 
				 System.out.println("Enter the student name");
				 String name = scan.nextLine();
				 lg.add(new Logged(name,id));
				 System.out.println(" Added Successfully");
				 
				 
			 }
		 
	 }
	 static void Adduser() {
		 lg.add(new Logged("Subadharshana " , 76));
		 lg.add(new Logged( " Vishali " ,90));
		 lg.add(new Logged("Savitha " ,70));
		 lg.add(new Logged("parkkavi ",59));
		 
	 }
	 
	 static void  ViewUser() {
		 for(Logged ll:lg) {
			 if(lg.isEmpty()) {
				 System.out.println("there is no  user");
			 }
			 else {
			 System.out.println(ll);
			 }
		 }
	 }
	
	 public String toString() {
		 return " name"+getName() +"\n id "+id;
	 }
	    
		 static void log(Scanner scan) {
			 Logged.Adduser();
			 System.out.println("  \n 1. new user \n 2. Old user ");
			 int option = scan.nextInt();
			 scan.nextLine();
			 if(option ==1) {
				 login(scan);
				 User.user(scan);
			 }
			 else if(option==2) {
				 boolean found = false;
				 System.out.println("Enter the id");
				 int id = scan.nextInt();
				 scan.nextLine();
				 for(Logged ll:lg) {
					 if(ll.getId()==id) {
						 System.out.println("verified!  you are already logged");
						 found = true;
						 User.user(scan);
						 break;
						
					 }
				 }
				 
					 if(!found) {
						 System.out.println("Invalid id");
					
					 }
				 
				 }
			 }
			
			
				
				
			 
			 
		 
	
		 static void logged(Scanner scan) {
	
				
			 System.out.println("Enter the id");
			 int id = scan.nextInt();
			 boolean found = false;
			for(Logged ll :lg) {
				if(ll.getId()==id) {
					System.out.println("you can borrow only 3 books");
					User.BorrowBook(scan);
					found = true;
					break;
					
					}
				
				
				
			}
			if(!found) {
				System.out.println("i cannot find your id");
			}
			 
		 
				 
			  }
		 
		 static void Return(Scanner scan) {
			 System.out.println("Enter the id");
			 int id = scan.nextInt();
			 scan.nextLine();
			 for(Logged ll : lg) {
				 if(ll.getId()==id) {
					 User.ReturnBook(scan);
					 break;
				 }
				 else {
					 System.out.println("Invalid user id");
					 break;
				 }
			 }
				 
			
			 
		 }
		 static void searchUser(Scanner scan) {
			 
			  System.out.println("Enter the user id");
			 int id = scan.nextInt();
			 scan.nextLine();
			  for(Logged ll:lg) {
				  if(ll.getId()==id) {
					  System.out.println(ll);
					  break;
				  }
				  else {
					  System.out.println("Invalid id");
					  break;
				  }
			  }
			  
		  }
		  static void DeleteUser(Scanner scan) {
			  System.out.println("Enter the id ");
			  int id = scan.nextInt();
			  scan.nextLine();
			  Iterator<Logged> it = lg.iterator();
			  while(it.hasNext()) {
				  if(it.next().getId()==id) {
					  it.remove();
				  }
				  else {
					  System.out.println("invalid id");
				  }
				 
			  }
			  System.out.println("DELETED SUCCESSFULLY");
			  
		  }	
 }

public class Source {
	 static Scanner scan = new Scanner(System.in);
	public static void main(String args[]) {
		System.out.println("Enter your Choice \n 1. Admin \n 2. User");
		int role = scan.nextInt();
		scan.nextLine();
		if(role == 1) {
			System.out.println("Enter the username");
			String username = scan.nextLine();
			if(username.equals("admin")) {
				System.out.println("Enter the password");
				int password = scan.nextInt();
				scan.nextLine();
				
					if(password == 123) {
						Librarian.admin(scan);
					}
					else {
						System.out.println("wrong password");
					}
				
				
			}
			else {
				System.out.println("Wrong User name");
			}
			
		}
		else if (role==2) {
		 Logged.log(scan);
	      
		}
		
		else {
			System.out.println("Enter the correct number");
		}
		
		
	}

}
