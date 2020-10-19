
package ui;

import model.*;

import java.util.Scanner;
import java.io.*;

public class OnlineLibrary {
//test coverage: test覆盖了多少code
//test score: 多少test是对的

    //create library object, book and video object
//所有method在ui里面call method def在model
//test的时候 可以只test subclass
    public static void main(String[] args) throws IOException {
        ReadWebPageEx.readWeb(); //how to use readWeb?
        Library library = new Library();
        Manager manager = new Manager("g");
        library.addObserver(manager);
        //OnlineLibrary onlineLibrary = new OnlineLibrary();
        Scanner keyboard = new Scanner(System.in);

        library.loadable("data.txt");
        System.out.println("would you like to deal with video or book?(1.book 2. video)");
        int type = keyboard.nextInt();
        if (type == 1) {
            Publication b1 = new Book(null, 0, 0);
            menu(b1, library);//why do we need to put onlineLibrary here??
        }
        if (type == 2) {
            Publication v1 = new Video(null, 0, 0);
            menu(v1, library);
        }
//        System.out.println(library.getPublicationMap());
        library.savable("data.txt");
//        library.loadable("data.txt");
//        System.out.println("do you want to load it out again? ");
//        String answer = keyboard.nextLine();
//        while (answer.startsWith("y")) {
//            library.loadable("data");
//        }
    }


//        PrintWriter outputFile = new PrintWriter("Data1.txt");
//        System.out.println("what are you going to do today?(1.load 2.save)");


//                library.loadable();
//
//
//                System.out.println("how many books do u put:");
//                int times = keyboard.nextInt();
//                library.savable(information(times));
//
//                System.out.println("lol");

//            case 2:
//                System.out.println("plz enter the book number:");
//                int bookNumber = keyboard.nextInt();
//                library.lookForBook(bookNumber);
//                break;
//            case 3:
//                System.out.println("enter the book number");
//                int
//                library.lookForBook();
//                break;


//        }


    //if it's too long. try to divide into different methods, or cut down some lines
//
//        outputFile.close();
//
//
//    }

    public static void menu(Publication onePublication, Library sampleLibrary) {
        Scanner keyboard = new Scanner(System.in);
        boolean repeat = true;
        while (repeat) {
            System.out.println("what to do today? (1.add 2.borrow 3.search)");
            int option = keyboard.nextInt();
            if (option == 1) {
                addPub(onePublication, sampleLibrary);
            }
            if (option == 2) {
                borrowPub(sampleLibrary);
            }
            if (option == 3) {
                searchPub(sampleLibrary);

            }
            repeat = again();

        }
    }

    public static void searchPub(Library sampleLib) {
        Scanner keyboard = new Scanner(System.in);
        boolean runLoop = true;
        while (runLoop) {
            System.out.println("enter the number you want to search: ");
            int searchId = keyboard.nextInt();
            try {
                Publication p = sampleLib.lookForPublication(searchId);
                System.out.println(p.toString());
                runLoop = false;
            } catch (BookNotFoundException e) {
                System.out.println("the publication did not find");
            }
        }
    }



    public static boolean again() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("do you want to add/borrow/search again?");
        String answer = keyboard.nextLine();
        if (answer.equals("yes") || answer.equals("Yes")) {
            return true;
        } else {
            return false;
        }
    }

    public static int loopTimes() throws TooManyBooksException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("plz enter the number you want to add: ");
        int times = keyboard.nextInt();
        if (times > 100) {
            throw new TooManyBooksException();
        }
        return times;

    }

    public static void addPub(Publication onePub, Library samLibrary) {
        while (true) {
            try {
                int manyTimes = loopTimes();
                for (int i = 0; i < manyTimes; i++) {
                    samLibrary.addPublication(publicationInfo(onePub));
                }
            } catch (TooManyBooksException e) {
                System.out.println("too many books you want to add");
                continue;
            }
            break;
        }

    }

    public static void borrowPub(Library samLibrary) {
        Scanner keyboard = new Scanner(System.in);
        boolean runLoop = true;
        while (runLoop) {
            System.out.println("enter the number: ");
            int id = keyboard.nextInt();
            try {
                Publication p = samLibrary.borrowBook(samLibrary.lookForPublication(id));
                System.out.println("you have borrowed the publication " + p.toString());
                runLoop = false;
            } catch (BookNotFoundException e) {
                System.out.println("Did not find the book in the library");//if did not find, go back to the while loop
            }

//            } finally {
//                System.out.println("I love book");
//            }
        }
    }

    public static Publication publicationInfo(Publication onePublication) {

        Scanner keyboard = new Scanner(System.in);
//        System.out.println("plz enter the number you want to add: ");
//        int times = keyboard.nextInt();
//        for (int i = 0; i < times; i++) {
//            keyboard.nextLine();
        System.out.println("enter the name :");
        String name = keyboard.nextLine();
        onePublication.setName(name);
        System.out.println("enter the number: ");
        int bookNb = keyboard.nextInt();
        onePublication.setNumber(bookNb);
        System.out.println("enter the pages of book/ length of video");
        int theLength = keyboard.nextInt();
        onePublication.setLength(theLength);
        return onePublication;
//        }
//        return null;
    }

}





















