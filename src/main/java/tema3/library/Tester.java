package tema3.library;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Library lib = new Library();
        lib.importBooks("Books.txt");
        while (true) {
            System.out.println("Enter 1 to display");
            System.out.println("Enter 2 to add a book");
            System.out.println("Enter 3 to delete a book");
            System.out.println("Enter x to exit");
            char key = scan.next().charAt(0);
            if (key == '1') {
                System.out.println("Enter <novel> to display a novel, <album> to display an album or enter <all> to display all books");
                String key1 = scan.next();
                switch (key1) {
                    case "novel": {
                        System.out.println("Enter the name of novel: ");
                        String name = scan.next();
                        name += scan.nextLine();
                        System.out.println("name = " + name);
                        lib.displayNovel(name);
                        break;
                    }
                    case "album": {
                        System.out.println("Enter the name of album: ");
                        String name = scan.next();
                        name += scan.nextLine();
                        lib.displayAlbum(name);
                        break;
                    }
                    case "all":
                        lib.displayAllBooks();
                        break;
                    default:
                        System.out.println("Error. Try again");
                        break;
                }
            } else if (key == '2') {
                System.out.println("Enter <novel> to add a novel or <album> to add an album");
                String typeOfBook = scan.next();
                System.out.println("Enter name: ");
                String s1 = scan.next();
                s1 += scan.nextLine();
                System.out.println("Enter the number of pages: ");
                int s2 = scan.nextInt();
                System.out.println("Enter the type (for novels) / quality of paper (for albums): ");
                String s3 = scan.next();
                if(s2 <= 0){
                    System.out.println("Incorrect number of pages, try again");
                }else{
                lib.addBooks(typeOfBook, s1, s2, s3);
                }
            } else if (key == 'x') {
                break;
            } else if (key == '3') {
                System.out.println("Enter the name of the book");
                String deleteName = scan.nextLine();
                lib.deleteBooks(deleteName);
            } else {
                System.out.println("Wrong button");
            }
        }
    }
}
