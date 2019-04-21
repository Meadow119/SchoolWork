import java.util.*;
import java.lang.*;
import java.awt.*;

public class Bookstore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BookCollection bookCollection = new BookCollection();

        //Creates loop until user quits
        boolean runProgram = true;
        do {

            //This menu will display after each selection and completion of section.
            System.out.print("" +
                    "\n--------------------------------------------" +
                    "\nMain Menu" +
                    "\n--------------------------------------------" +
                    "\n  a - add a book           r - remove a book" +
                    "\n  s - search for books     f - find a book" +
                    "\n  d - display all books    q - quit" +
                    "\n--------------------------------------------" +
                    "\nPlease enter an option ==>");


            //get user input
            String userInput = input.nextLine().toLowerCase();
            System.out.println();


                switch (userInput) {

                    case "q":
                        runProgram = false;
                        break;
//**********************************************************************************************
                    //Add book
                    case "a":
                        System.out.print("Please enter the book title.\n");
                        String desiredTitle = input.nextLine();
                        System.out.print("Please enter the book's author.\n");
                        String desiredAuthor = input.nextLine();
                        System.out.print("Please enter the book ISBN.\n");
                        String desiredISBN = input.nextLine();
                        bookCollection.addBook(desiredTitle, desiredAuthor, desiredISBN);

                        System.out.printf("\n%s has been added to the collection.\n", desiredTitle);
                        break;

//**************************************************************************************************
                    case "s":
                        System.out.println("Please enter the term you would like to search for");
                        String term = input.nextLine();
                        System.out.println("Search (t)itles or (a)uthors?");
                        String criteria = input.nextLine().toLowerCase();
                        int critNumber;
                            if(criteria.equals("t")){
                                critNumber = 0;
                            }
                            else if(criteria.equals("a")){
                                critNumber = 1;
                            }
                            else{System.out.println("Invalid entry. Please try again.");
                            break;}

                        bookCollection.search(term, critNumber);
                            break;
//**********************************************************************************************
                    //Displays all books in the Collection
                    case "d":
                        bookCollection.ToString();
                        break;

//******************************************************************************************************
                    //Removes a book from the collection based on ISBN
                    case "r":
                        System.out.println("Please enter the ISBN of the book you would like to remove.");
                        String removedBook = input.nextLine();
                        System.out.println("\nThe following book will be removed: \n");
                        bookCollection.getBook(removedBook);
                        System.out.println("\nAre you sure? Y/N\n");
                        String removeBookAnswer = input.nextLine().toUpperCase();
                        if (removeBookAnswer.equals("Y")) {
                            bookCollection.removeBook(removedBook);
                            System.out.println("The book has been removed.\n");
                        } else if (removeBookAnswer.equals("N")) {
                            System.out.println("The book has been retained.\n");
                        } else {
                            System.out.println("Invalid entry. The book has not been removed.\n");
                        }
                        break;

//*******************************************************************************************************
                    //Finds a book in the collection based on ISBN
                    case "f":
                        System.out.println("Please enter the ISBN of the book you would like to look up.");
                        String findBook = input.nextLine();
                        bookCollection.getBook(findBook);
                        break;

//*******************************************************************************************************
                    //Displays an error message for invalid entry
                    default:
                        System.out.print("Invalid entry. Please try again.");
                        break;
                }
//*******************************************************************************************************

        } while (runProgram);
    }
}


class BookCollection{

   ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author, String isbn){
        Book book = new Book(title, author, isbn);
        books.add(book);}

//*************************************************
    public void removeBook(String isbn){
        for(Book book : books){
            if(isbn.equals(book.getISBN())){
                books.remove(book);
                return;
            }
            else{}
        }
    }

//*************************************************
    public void getBook(String isbn){
        for(Book book : books){
            if(isbn.equals(book.getISBN())){
               book.ToString();
            }
            else{}
        }
    }
//****************************************************
    public void search(String term, int type){
        ArrayList<Book> searchResults = new ArrayList<>();
            if(type == 0){
                for(Book book:books){
                    if(book.getTitle().contains(term)){
                            book.ToString();}
                    else{}
                }}
            else if (type == 1){
                    for (Book book:books){
                        if (book.getAuthor().contains(term)){
                            book.ToString();
                        }
                        else{}
                    }
                }
            else {
                System.out.print("\nNo items matched your search criteria");
            }


        }
//****************************************************

    public void ToString(){
        for(Book book: books){
            book.ToString();
        }
    }
}

class Book{
    private String title;
    private String author;
    private String isbn;

    //Setters
    public void setTitle(String desiredTitle){
        title = desiredTitle;}

    public void setAuthor(String desiredAuthor){
        author = desiredAuthor;}

    public void setISBN(String desiredISBN){
        isbn = desiredISBN;}

    //Getters
    public String getTitle(){
        return title;}
    public String getAuthor(){
        return author;}
    public String getISBN(){
        return isbn;}

    //Constructors
    Book(){}
    Book(String desiredTitle){
        setTitle(desiredTitle);}
    Book(String desiredTitle, String desiredAuthor){
        setTitle(desiredTitle);
        setAuthor(desiredAuthor);}
    Book(String desiredTitle, String desiredAuthor, String desiredISBN){
        setTitle(desiredTitle);
        setAuthor(desiredAuthor);
        setISBN(desiredISBN);}

   public void ToString(){
        System.out.printf("\nTitle: %s" +
                "\nAuthor: %s" +
                "\nISBN: %s\n", title, author, isbn);
    }



}
