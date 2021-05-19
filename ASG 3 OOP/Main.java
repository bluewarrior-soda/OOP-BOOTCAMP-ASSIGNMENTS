import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main
{
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Shoe> SHOE = new ArrayList<>();
	
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
	
	public static void press_enter_to_continue ()
	{
		System.out.println("Press enter to continue..");
		scan.nextLine();
	}
	
	public static boolean valid_option (int option)
	{
		return option >= 1 && option <= 4;
	}
	
	public static boolean valid_name (String name)
	{
		return name.endsWith("shoe");
	}
	
	public static boolean valid_category (String category)
	{
		return category.equals("Sneaker") || category.equals("Running") || category.equals("Boot");
	}
	
	public static boolean valid_date (String date)
	{
		boolean format_is_right = (date.charAt(2) == '-' && date.charAt(5) == '-')? true : false;
		boolean all_numbers = true;
		for (int i = 0; i < date.length(); i++)
		{
			if ((i != 2 && i != 5) && (date.charAt(i) < '0' || date.charAt(i) > '9'))
			{
				all_numbers = false;
			}
		}
		
		return format_is_right && all_numbers;
	}
	
	public static boolean valid_price (int price)
	{
		return price >= 5000;
	}
	
	public static boolean valid_idx_to_delete (int idx)
	{
		return idx >= 1 && idx <= SHOE.size();
	}
	
	public static void home_page ()
	{
		System.out.println("Shoe Shop");
		System.out.println("=========");
		System.out.println("1. View Shoes");
		System.out.println("2. Add Shoe");
		System.out.println("3. Delete Shoe");
		System.out.println("4. Exit");
		int option;
		do
		{
			System.out.println(">> ");
			option = scan.nextInt();
		} while (!valid_option(option));
		
		switch (option)
		{
		case 1: 
			view_shoes();
			break;
		case 2:
			add_shoe();
			break;
		case 3:
			delete_shoe();
			break;
		case 4:
			exit_app();
			break;
		}
	}
	
	public static void display_table () 
	{
		int i = 0;
		for (Shoe shoe : SHOE)
		{
			System.out.println(i + 1 + ". " + shoe.name + "-" + shoe.code);
			System.out.println("==================");
			System.out.println("Category: " + shoe.category);
			System.out.println("Release date: " +  shoe.date);
			System.out.println("Price: " + shoe.price);
			System.out.println("");
			i++;
		}
	}
	
	public static void view_shoes () // 1
	{
		clear_console();
		if (SHOE.isEmpty())
		{
			System.out.println("No shoes available..");
			press_enter_to_continue();
		}
		else
		{
			display_table();
			press_enter_to_continue();
		}
		
		scan.nextLine();
		clear_console();
		home_page();
	}
	
	public static void add_shoe () // 2
	{
		clear_console();
		String name;
		do
		{
			scan.nextLine();
			System.out.println("Input shoe's name[name ends with shoe, example: \"Fire shoe\"]: ");
			name = scan.nextLine();
		} while (!valid_name(name));
		
		String category;
		do
		{
			System.out.println("Input shoe's category[Sneaker | Running | Boot] (case sensitive): ");
			category = scan.nextLine();
		} while (!valid_category(category));
		
		String date;
		do
		{
			System.out.println("Input shoe's release date[dd-mm-yyyy]: ");
			date = scan.nextLine();
		} while (!valid_date(date));
		
		int price;
		do
		{
			System.out.println("Input shoe's price[more than or equals to 5000]: ");
			price = scan.nextInt();
		} while (!valid_price(price));
		
		Random random = new Random();
		String first_two_letters = "SH";
		Integer x = random.nextInt(10);
		Integer y = random.nextInt(10);
		Integer z = random.nextInt(10);
		String code = first_two_letters + x.toString() + y.toString()+ z.toString();
		
		Shoe shoe = new Shoe(name, code, category, date, price);
		SHOE.add(shoe);
		
		scan.nextLine();
		System.out.println("Shoe added!");
		scan.nextLine();
		clear_console();
		home_page();
	}
	
	public static void delete_shoe () // 3
	{
		clear_console();
		if (SHOE.isEmpty())
		{
			System.out.println("No shoes available..");
			press_enter_to_continue();
		}
		else
		{
			display_table();
			int number;
			do
			{
				System.out.printf("\nChoose shoe's number to delete[1..%d]: ", SHOE.size());
				number = scan.nextInt();
			} while (!valid_idx_to_delete(number));

			SHOE.remove(number - 1);
			
			System.out.println("Shoe removed!");
			scan.nextLine();
		}
		
		scan.nextLine();
		clear_console();
		home_page();
	}
	
	public static void exit_app () // 4
	{
		clear_console();
		System.out.println("Thank you for using this application!");
	}
}
