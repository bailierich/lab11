package lab11;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lab11Main {
	private static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		

		// A arraylist to house all the movies from the MovieIO
		ArrayList<Movie> filmCatalog = new ArrayList<>();
		// using a tree set because they are sorted already and sets can't have repeats
		Set<String> filmCatagories = new TreeSet<>();

		for (int index = 1; index <= 100; index++) {
			filmCatalog.add(MoviesIO.getMovie(index));
			filmCatagories.add(filmCatalog.get(index - 1).getCatagory());
		}

		System.out.println("Welcome to the Movie List Application!");
		do {
			//System.out.println("Here are the genres of Movies that we offer.");
			//printCatagories(filmCatagories);
			// System.out.println("Which genre of movie are you interested in?");
			// userInput = scnr.next();
			getInput(filmCatalog,filmCatagories);
			System.out.println();
			//printFilmsInCatagory(filmCatalog, userInput,filmCatagories);
			System.out.println();

		} while (getYesNo());
	}

	private static void printCatagories(Set<String> a) {
		for (String catagory : a) {
			String s1 = catagory.substring(0, 1).toUpperCase();
			System.out.println(s1 + catagory.substring(1));
		}
	}

	private static void printFilmsInCatagory(ArrayList<Movie> a, String userInput, Set<String> filmCatagories) {
		if (filmCatagories.contains(userInput)) {
			for (int index1 = 0; index1 < 100; index1++) {
				Movie movies = a.get(index1);
				if (movies.getCatagory().equalsIgnoreCase(userInput)) {
					System.out.println(movies.getTitle());
				}
			}
		} else {
			System.out.println("There isn't a genre by that name. Try Again. ");
			getInput(a,filmCatagories);
			;
		}
	}

	private static boolean getYesNo() {
		System.out.print("Would you like to choose another genre (yes or no)?");
		String yesOrNo = scnr.next();
		boolean goAgain = true;
		if (yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("no")) {
			if (yesOrNo.equalsIgnoreCase("yes")) {
				return goAgain;
			} else {
				return goAgain = false;
			}

		} else {
			System.out.println("Opps! It doesn't seem like you gave a valid answer. Try again.");
			return getYesNo();
		}
	}
	private static void getInput(ArrayList<Movie> a,Set<String> filmCatagories) {
		String userInput;
		System.out.println("Here are the genres of Movies that we offer.");
		printCatagories(filmCatagories);
		System.out.println("Which genre of movie are you interested in?");
		userInput = scnr.next();
		printFilmsInCatagory(a, userInput, filmCatagories);
	}
}
