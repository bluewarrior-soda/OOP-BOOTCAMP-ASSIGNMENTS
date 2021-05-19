import java.util.Scanner;

public class Main 
{
	static Scanner scan = new Scanner(System.in);
	static Integer a, b;
	static Boolean p1, p2;
	public static void main(String[] args) 
	{
		home_page();
	}
	
	public static void clear_console ()
	{
		for (int i = 0; i < 1000; i++)
		{
			System.out.println("");
		}
	}
	
	public static void press_enter_to_proceed ()
	{
		System.out.println("Press enter to proceed..");
		scan.nextLine();
	}
	
	public static boolean valid_option (int option)
	{
		return option == 1 || option == 2;
	}
	
	public static boolean valid_number (int number)
	{
		return number >= 0 && number <= 100;
	}
	
	public static boolean valid_boolean (boolean bool)
	{
		return bool == true || bool == false;
	}
	
	public static void display_title ()
	{

		System.out.println(" /$$$$$$$     /$$$$$                        /$$$$$ /$$$$$$$  /$$$$$$$$        /$$       /$$ ");         
		System.out.println("| $$__  $$   |__  $$                       |__  $$| $$__  $$|__  $$__/       | $$      | $$");          
		System.out.println("| $$  \\ $$      | $$                          | $$| $$  \\ $$   | $$  /$$$$$$ | $$$$$$$ | $$  /$$$$$$"); 
		System.out.println("| $$$$$$$       | $$       /$$$$$$            | $$| $$$$$$$/   | $$ |____  $$| $$__  $$| $$ /$$__  $$");
		System.out.println("| $$__  $$ /$$  | $$      |______/       /$$  | $$| $$____/    | $$  /$$$$$$$| $$  \\ $$| $$| $$$$$$$$");
		System.out.println("| $$  \\ $$| $$  | $$                    | $$  | $$| $$         | $$ /$$__  $$| $$  | $$| $$| $$_____/");
		System.out.println("| $$$$$$$/|  $$$$$$/                    |  $$$$$$/| $$         | $$|  $$$$$$$| $$$$$$$/| $$|  $$$$$$$");
		System.out.println("|_______/  \\______/                      \\______/ |__/         |__/ \\_______/|_______/ |__/ \\_______/");
	}
	
	public static void display_data_types ()
	{
		clear_console();
		String string_type = a.toString() + " + " + b.toString();
		
		int temp_int_A = a;
		int temp_int_B = b;
		char char_A = (char) temp_int_A;
		char char_B = (char) temp_int_B;
		String character_type = "  " + char_A + "   " + char_B;
		
		Integer mult = a * b;
		String integer_type = mult.toString();
		
		float float_A = (float) temp_int_A;
		float float_B = (float) temp_int_B;
		Float floating_type_div = float_A / float_B;
		
		String boolean_type = (temp_int_A == temp_int_B)? "True" : "False";
		System.out.println("+============================================================================================================================+");
		System.out.printf("+%-20s|%-20s|%-20s|%-20s|%-40s+\n", "  + (String Type)", "  (Character Type)", "  * (Integer type)", "  / (Floating type", "  input 1 == input 2 (Boolean Type)");
		System.out.println("+============================================================================================================================+");
		System.out.printf("+  %-18s|  %-18s|  %-18s|  %-18.3s|  %-38s+\n", string_type, character_type, integer_type, "  " + floating_type_div.toString(), boolean_type);
		System.out.println("+============================================================================================================================+");
		System.out.println("");
	}
	
	public static void display_arithmetic_operations ()
	{
		clear_console();
		Integer addition = a + b;
		Integer substraction = a - b;
		Integer multiplication = a * b;
		Integer division = a / b;
		Integer modulo = a % b;
		System.out.println("+============================================+");
		System.out.println("+Data Type : Integer			     +");
		System.out.println("+============================================+");
		System.out.printf("+   %-5c|   %-5c|   %-5c|   %-5c|   %-5c+\n", '+', '-', '*', '/', '%');
		System.out.println("+============================================+");
		System.out.printf("+  %-6d|  %-6d|  %-6d|  %-6d|  %-6d+\n", addition, substraction, multiplication, division, modulo);
		System.out.println("+============================================+");
		System.out.println("");
	}
	
	public static void display_logical_table ()
	{
		clear_console();
		String p1_code = p1? "T" : "F";
		String p2_code = p2? "T" : "F";
		String bool_values = "  P1 = " + p1_code + " , " + "P2 = " + p2_code;
		System.out.println("+===================================+");
		System.out.println("+Logical Table                      +");
		System.out.println("+===================================+");
		System.out.printf("+%-35s+\n", bool_values);
		System.out.println("+===================================+");
		System.out.printf("+  %-6s|  %-6s|  %-6s|  %-6s+\n", "!P1", "!P2", "&&", "||");
		System.out.printf("+  %-6b|  %-6b|  %-6b|  %-6b+\n", !p1, !p2, p1 && p2, p1 || p2);
		System.out.println("+===================================+");
		System.out.println("");
	}
	
	public static void input_booleans ()
	{
		clear_console();
		do
		{
			System.out.print("Give me the value of p1 [true | false]: ");
			p1 = scan.nextBoolean();
		} while (!valid_boolean(p1));
		
		do
		{
			System.out.print("Give me the value of p2 [true | false]: ");
			p2 = scan.nextBoolean();
		} while (!valid_boolean(p2));
	}
	
	public static void home_page ()
	{
		display_title();
		System.out.println("");
		System.out.println("1. Start The Simulation!!");
		System.out.println("2. Close App");
		
		int option;
		do
		{
			System.out.print("Choice >> ");
			option = scan.nextInt();
		} while (!valid_option(option));
		
		if (option == 1)
		{
			do
			{
				System.out.println("Input the first number [1 - 100](inclusive): ");
				a = scan.nextInt();
			} while (!valid_number(a));
			
			do
			{
				System.out.println("Input the second number [1 - 100](inclusive): ");
				b = scan.nextInt();
			} while (!valid_number(b));
			
			// JAVA BASIC DATA TYPES
			display_data_types();
			scan.nextLine();
			press_enter_to_proceed();
			
			// BASIC ARITHMETIC OPERATIONS
			display_arithmetic_operations();
			press_enter_to_proceed();
			
			// LOGICAL TABLE
			input_booleans();
			display_logical_table();
		}
		else if (option == 2)
		{
			System.out.println("thank you for using the app!!");
		}
	}
}
