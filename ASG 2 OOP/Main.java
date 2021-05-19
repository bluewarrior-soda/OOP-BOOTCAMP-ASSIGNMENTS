import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Person> PERSON = new ArrayList<>();
	
	public static void main(String[] args) 
	{
		home_page();
	}
	
	public static void clear_console ()
	{
		for (int i = 0; i < 500; i++)
		{
			System.out.println("");
		}
	}
	
	public static boolean valid_option (int option)
	{
		return option >= 1 && option <= 4;
	}
	
	public static boolean username_is_taken (String name)
	{
		for (Person person : PERSON)
		{
			if (name.equals(person.name)) 
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean valid_name (String name)
	{
		boolean valid_length = name.length() >= 5 && name.length() <= 20;
		return valid_length && !username_is_taken(name);
	}

	public static void display_main_menu ()
	{
		System.out.println(" _______      ___             _______  _______  __   __  ______    _______ ");
		System.out.println("|  _    |    |   |           |       ||   _   ||  | |  ||    _ |  |       |");
		System.out.println("| |_|   |    |   |   ____    |  _____||  |_|  ||  |_|  ||   | ||  |    ___|");
		System.out.println("|       |    |   |  |____|   | |_____ |       ||       ||   |_||_ |   |___ ");
		System.out.println("|  _   |  ___|   |           |_____  ||       ||       ||    __  ||    ___|");
		System.out.println("| |_|   ||       |            _____| ||   _   ||   _   ||   |  | ||   |___ ");
		System.out.println("|_______||_______|           |_______||__| |__||__| |__||___|  |_||_______|");
		System.out.println("");
		System.out.println("Options");
		System.out.println("=========================");
		System.out.println("1. Start Sharing");
		System.out.println("2. Update Participant");
		System.out.println("3. Delete Participant");
		System.out.println("4. Close App");
		System.out.println("=========================");
	}
	
	public static void display_line ()
	{
		System.out.println("+======================================+");
	}
	
	public static void display_header ()
	{
		display_line();
		System.out.println("+  Share List                          |");
		display_line();
	}
	
	public static void display_table ()
	{
		display_header();
		int i = 0;
		for (Person person : PERSON)
		{
			System.out.printf("| %-3d| %-20s| %-10d|\n", i + 1, person.name, person.number);
			i++;
		}
		display_line();
	}
	
	public static void home_page ()
	{
		clear_console();
		display_main_menu();
		int option;
		do
		{
			System.out.print("Choice >> ");
			option = scan.nextInt();
		} while (!valid_option(option));
		
		switch (option)
		{
		case 1:
			start_sharing();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			close_app();
			break;
		}
	}
	
	public static void welcoming ()
	{
		System.out.println("You are the " + (PERSON.size() + 1) + " that joins the game");
	}
	
	public static void start_sharing () // 1
	{
		int number = 0;
		do
		{
			try
			{
				System.out.print("Input a number [1 - 100]: ");
				number = scan.nextInt();
			}
			catch (InputMismatchException e)
			{
				scan.nextLine();
				System.out.println("Input must be numeric");
			}
		} while (number < 1 || number > 100);
		
		String name;
		do
		{
			scan.nextLine();
			System.out.print("Could you give me your username [5 - 20 characters]? ");
			name = scan.nextLine();
			if (username_is_taken(name))
			{
				System.out.println("Username has already been taken");
			}
		} while (!valid_name(name));
		
		welcoming();
		scan.nextLine();
		
		Person person = new Person(number, name);
		PERSON.add(person);
		home_page();
	}
	
	public static void update () // 2
	{
		if (PERSON.isEmpty())
		{
			scan.nextLine();
			home_page();
		}
		else
		{
			clear_console();
			display_table();
			int idx;
			do
			{
				System.out.printf("Which participant would you like to update [1 - %d][0 to exit]? ", PERSON.size());
				idx = scan.nextInt();
			} while (idx < 0 || idx > PERSON.size());
			
			if (idx == 0)
			{
				home_page();
			}
			else
			{
				int number;
				do
				{
					System.out.println("Input a number [1 - 100]: ");
					number = scan.nextInt();
				} while (number < 0 || number > 100);
				
				int i = 0;
				for (Person person : PERSON)
				{
					if (i == idx - 1)
					{
						person.number = number;
					}
					i++;
				}
				
				scan.nextLine();
				System.out.println("Update Sucessful!");
				
				scan.nextLine();
				home_page();
			}
		}
	}
	
	public static void delete () // 3
	{
		if (PERSON.isEmpty())
		{
			scan.nextLine();
			home_page();
		}
		else
		{
			clear_console();
			display_table();
			int idx;
			do
			{
				System.out.printf("Which participant would you like to delete [1 - %d][0 to exit]? ", PERSON.size());
				idx = scan.nextInt();
			} while (idx < 0 || idx > PERSON.size());
			
			if (idx == 0)
			{
				home_page();
			}
			else
			{
				PERSON.remove(idx - 1);
				scan.nextLine();
				System.out.println("Participant successfully removed from the event");
				
				scan.nextLine();
				home_page();
			}
		}
	}
	
	public static void close_app () // 4
	{
		clear_console();
		System.out.println("Here's the completed share list");
		System.out.println("Remember, sharing is caring, happy sharing :D");
		
		ArrayList<String> FinalName = new ArrayList<>();
		int i = 0;
		for (Person person : PERSON)
		{
			FinalName.add(i++, person.name);
		}
		Collections.sort(FinalName);
		
		ArrayList<Integer> FinalNumber = new ArrayList<>();
		int j = 0;
		for (Person person : PERSON)
		{
			FinalNumber.add(j++, person.number);
		}
		Collections.shuffle(FinalNumber);
		Collections.reverse(FinalNumber);
		
		display_header();
		System.out.printf("+%-20s|%-8s|%-8s+\n", "  Username", " Before", "  After");
		display_line();
		int idx = 0;
		for (Person person : PERSON)
		{
			System.out.printf("+  %-18s|  %-6d|  %-6d+\n", FinalName.get(idx), person.number, FinalNumber.get(idx));
			idx++;
		}
		display_line();
	}
}