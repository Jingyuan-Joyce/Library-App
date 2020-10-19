package model;

public class Book extends Publication {

    private int bookPage;

    public Book(String bookName, int bookNumber, int bookPage) {
        super(bookName, bookNumber);
        this.bookPage = bookPage;
    }

    @Override
    public void setLength(int bookPage) {
        this.bookPage = bookPage;
    }

    @Override
    public int getLength() {
        return bookPage;
    }

    @Override
    //EFFECTS: print out the page of the book and return the book page
    public int timeSpendOn() {
        System.out.println("depend on you, there are %d pages" + bookPage);
        return bookPage;
    }

    @Override
    //EFFECTS: return the book name, number and book page
    public String toString() {
        return super.toString() + " " + bookPage;
    }
}
