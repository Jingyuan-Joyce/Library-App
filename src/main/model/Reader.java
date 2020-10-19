package model;


import java.util.Objects;


public class Reader {
    private int readerId;
    private String readerName;
    private Library customerLibrary;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reader reader = (Reader) o;
        return readerId == reader.readerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(readerId);
    }

    //EFFECTS: return the reader name and reader ID
    public String toString() {
        return readerName + " " + readerId;
    }


    public Reader(String readerName, int readerId) {
        this.readerName = readerName;
        this.readerId = readerId;


    }

    public void setReaderName(String name) {
        this.readerName = name;
    }

    public String getName() {
        return readerName;
    }

    public void setReaderId(int newId) {
        this.readerId = newId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderLibrary(Library library) {
        this.customerLibrary = library;
    }

    public Library getReaderLibrary() {
        return customerLibrary;
    }


    //MODIFIES:this,libraryReaderWant
    //EFFECTS:if assign to library null, set the library field to null; if the library is not null and has
    //not been assigned, set the field to the sample library and add the reader to the sample library;
    //if the library is not null and has been assigned, change the library field to the sample library, add the
    //reader to the sample library and remove from the previous library assigned
    public void assignReaderToLibrary(Library libraryReaderWant) {
        if (libraryReaderWant != null) {
            if (this.customerLibrary == null) {
                this.customerLibrary = libraryReaderWant;
                libraryReaderWant.addCustomer(this);
            } else if (!this.customerLibrary.equals(libraryReaderWant)) {
                this.customerLibrary.removeCustomer(this.readerId);
                libraryReaderWant.addCustomer(this);
                this.customerLibrary = libraryReaderWant;
            }
        } else {
            this.customerLibrary = null;
        }
    }

    //MODIFIES:this,library
    //EFFECTS: if the publication is in the library,borrow the book and add it to the customer library
    //and assign the publication to the customer library;else print out not found statement
    public void borrowPub(Publication publication, Library library) {
        try {
            Publication onePub = library.borrowBook(publication);
            customerLibrary.addPublication(onePub);
            publication.assignToLibrary(this.customerLibrary);
            System.out.println("you have borrowed your book" + onePub.toString());
            //can create bi-directional relationship between customer and library
        } catch (BookNotFoundException e) {
            System.out.println("not found");
        }
    }

    //MODIFIES:this,library
    //EFFECTS: remove the publication from the customer library to the library and assign the publication field
    // to the library
    public void returnPub(Publication publication, Library library) {
        customerLibrary.deletePublication(publication);
        library.addPublication(publication);

    }

    //EFFECTS: if the customer library field is not null, and the publication number is in the customer library,
    //return the publication; if the publication number is not in the customer library, print out not found statement
    //and return null; if the customer library field is null, return null
    public Publication searchReaderPub(int borrowNum) {
        if (customerLibrary != null) {
            try {
                return customerLibrary.lookForPublication(borrowNum);

            } catch (BookNotFoundException e) {
                System.out.println("the book did not find");
                return null;
            }
        } else {
            return null;
        }


    }
}



