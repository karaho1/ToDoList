package ToDoList;

import java.util.Scanner;
import java.io.FileWriter;
import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.IOException;
//imports 

public class ToDoList{

	public static void main(String[] args) {
		/*
		 * Create a menu system to allow users to select different predefined operations
		Create a data structure to store the tasks entered by the user.
		Implement functionality to add tasks to the list.
		Implement functionality to display the current list.
		Include an option to quit the application. 
		Include an option to save the list to a file.
		 */
		LinkedList<String> tasks = new LinkedList<>();
		//opens a linked list for the user to put their tasks into
		Scanner userInput = new Scanner(System.in);
		//opening scanner 
		
		System.out.println("Hello User! Today we're going to be making a to-do list.");
		System.out.println(" [1] Enter Task \n [2] Delete Task \n [3] Display To Do List \n [4] Save List \n [5] Quit Program");
		System.out.println("Please input which option you would like to do: ");
		//This displays a menu of options for the user to choose from
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("To Do.txt"));
			while(true) {
				String option = userInput.nextLine();
				if(option.equals("1")) {
					//use writer to input task
					System.out.println("Please enter a task:");
					String todo = userInput.nextLine();
					tasks.add(todo);
					System.out.println("Please select another option: ");
				}
				//option 1 allows the user to enter their own task as a string
				else if(option.equals("2")) {
					//delete task
					System.out.println("Please enter the task you would like to delete:");
					System.out.println(tasks);
					String delete = userInput.nextLine();
					tasks.remove(delete);
					for(String items:tasks) {
						if(items.equals(delete)) {
							tasks.remove(delete);
						}
						System.out.println(tasks);
						System.out.println("Please select another option: ");
					}
				//option 2 lets the user delete a task from the linked list
				}
				else if(option.equals("3")) {
					//display to do list
					System.out.println("Here is your To-Do List: ");
					System.out.println(tasks);
					System.out.println("Please select another option: ");
				}
				//option 3 displays the to do list for the user
				else if(option.equals("4")) {
					for(String items:tasks) {
						writer.write("\n" + items);
					}
					writer.close();
					System.out.println("File saved as 'To Do.txt'.");
					
				}
				//option 4 saves a file to the desktop so the user can have their to do list to keep
				else if(option.equals("5")) {
					//quit program
					System.out.println("Thank you for using this program!");
					break;
				}
				//option 5 breaks the loop and exits the program
				else {
					System.out.println("I'm sorry, that is not a valid input :( Try again: ");
				}
				//this allows for user error
				
			}
		
		} catch (IOException e) {
			userInput.close();
			e.printStackTrace();
		
		}
		
		userInput.close();
		//closing my scanner
		
	
		
		
	}

}
//program by: Kara Ho
