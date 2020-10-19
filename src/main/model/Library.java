package model;

import observer.Subject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

//all things relate to library, put in same module
//book number start with 1, video number start with 2
public class Library extends Subject implements Load, Save {
    private Map<Integer, Publication> publicationMap;
    private Map<Integer, Reader> readers;


    //use interface here!! you don't need to use it in test!! use different types of book to implement！
    //should I put add the book methods here or interface?
//Map(k,v) k=key one unique key, v=value, can return a object.
    public Library() {

        publicationMap = new HashMap<>();

        readers = new HashMap<>();

    }


    public Reader getReader(int id) { //do I still need to keep relationship between library and reader?
//        return getObserver(id); //can I just call the superclass ?
        return readers.get(id);
    }

    //MODIFIES:this,c
    //EFFECTS: if the readers does not contain the reader, add the reader to the readers,
    // assign the reader's customer library to this library and notify observer
    public void addCustomer(Reader c) {
        if (!readers.containsValue(c)) {
            readers.put(c.getReaderId(), c);
            c.assignReaderToLibrary(this); //the object you refer
        }

        notifyObserver(c);

    }

    //MODIFIES: this,c
    //EFFECTS: if the readers contain the customerId, remove the reader from the readers,
    // assign the reader's customer library to null; else return null
    public Reader removeCustomer(int customerId) {

        if (readers.containsKey(customerId)) {
            Reader c = readers.get(customerId);
            c.assignReaderToLibrary(null);
            return readers.remove(c.getReaderId());
        } else {
            return null;
        }
    }

    //EFFECTS: if the readers contain the customerId, return the reader; else return null
    public Reader lookForReader(int customerId) {
        if (readers.containsKey(customerId)) {
            return readers.get(customerId);
        }
        return null;
    }

    //EFFECTS: return the size of the readers
    public int readerSize() {
        return readers.size();
    }

//    public void hasReturn(Publication p) {
//        if (p.publicationHasReturn(this)) {
//            notifyObserver(p);
//        }
//    }


    //EFFECTS: if the library contains the publication number, return the publication in the library
    // else throw out the BookNotFound Exception
    public Publication lookForPublication(int number) throws BookNotFoundException {
        if (!publicationMap.containsKey(number)) {
            throw new BookNotFoundException();
        }
        return publicationMap.get(number);
    }


    //MODIFIES:this,p
    //EFFECTS:if the library does not contain the publication, add the new publication to the library
    // and assign the publication's library to this library
    public void addPublication(Publication p) { //every book has diff bookNum
        if (!publicationMap.containsKey(p.getNumber())) {
            publicationMap.put(p.getNumber(), p);
            p.assignToLibrary(this);

        }
    }


    //MODIFIES: this,p
    //EFFECTS；if the library contains the publication, remove it from the library
    // and assign the publication's library to null
    public void deletePublication(Publication p) {
        if (publicationMap.containsValue(p)) {

            setFieldNull(p); //coupling
            publicationMap.remove(p.getNumber());
        }

    }

    private void setFieldNull(Publication publication) {
        publication.assignToLibrary(null);
    }


    //MODIFIES: this,p
    //EFFECTS: if the library contain the publication, assign the publication's library to null, remove the publication
    // from the library and return the publication; else throw out the BookNotFound Exception
    public Publication borrowBook(Publication publication) throws BookNotFoundException {
        if (!publicationMap.containsValue(publication)) {
            throw new BookNotFoundException();
        }
        setFieldNull(publication);
        return publicationMap.remove(publication.getNumber());

    }


    //EFFECTS: return the publication map of the library
    public Map getPublicationMap() {
        return publicationMap;
    }

    //EFFECTS: return the readers map of the library
    public Map getReadersMap() {
        return readers;
    }


    //EFFECTS:return the total number of publications in the library
    public int librarySize() {
        return publicationMap.size();
    }

    //EFFECTS: save the information of the publications and readers from the library to the file
    @Override
    public void savable(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for (Map.Entry<Integer, Publication> entry : publicationMap.entrySet()) {
                writer.print("Publication information." + entry.getValue().getName() + ".");
                writer.print(entry.getValue().getNumber() + ".");
                writer.print(entry.getValue().getLength() + "\n");
            }
            for (Map.Entry<Integer, Reader> entry : readers.entrySet()) {
                writer.print("Reader information." + entry.getValue().getName() + ".");
                writer.print(entry.getValue().getReaderId() + "\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    @Override
    //EFFECTS: load the readers and publications information from the file to the library
    public void loadable(String fileName) throws IOException {
        List<String> loading = Files.readAllLines(Paths.get(fileName));
        for (String p : loading) {
            List<String> partLoading = Arrays.asList(p.split("\\."));
            if (partLoading.get(0).startsWith("P")) {
                if (partLoading.get(2).startsWith("1")) {
                    Publication loadBook = new Book(partLoading.get(1), Integer.parseInt(partLoading.get(2)),
                            Integer.parseInt(partLoading.get(3)));
                    publicationMap.put(Integer.parseInt(partLoading.get(2)), loadBook);
                } else {
                    Publication loadVideo = new Video(partLoading.get(1), Integer.parseInt(partLoading.get(2)),
                            Integer.parseInt(partLoading.get(3)));
                    publicationMap.put(Integer.parseInt(partLoading.get(2)), loadVideo);
                }
            } else {
                Reader loadReader = new Reader(partLoading.get(1), Integer.parseInt(partLoading.get(2)));
                readers.put(Integer.parseInt(partLoading.get(2)), loadReader);

            }


//        for (String p : loading) {
//            partLoading = Arrays.asList(p.split("\\ "));
//            if (partLoading.get(2).startsWith("1")) {
//                Publication loadBook = new Book(partLoading.get(0),
//                        Integer.parseInt(partLoading.get(1)),
//                        Integer.parseInt(partLoading.get(2)));
//                library.put(Integer.parseInt(partLoading.get(2)), loadBook);
//            } else {
//                Publication loadVideo = new Video(partLoading.get(0),
//                        Integer.parseInt(partLoading.get(1)),
//                        Integer.parseInt(partLoading.get(2)));
//                library.put(Integer.parseInt(partLoading.get(1)), loadVideo);
//            }
//
//
//        }

        }
//        File myFile = new File("Data1.txt");
//        Scanner inputFile = new Scanner(myFile);
//        while (inputFile.hasNext()) {
//            Book b = null;
//            String str = inputFile.nextLine();
//            String[] tokens = str.split("\\ ");
//            for (int i = 0; i < tokens.length; i++) {
////                System.out.println(tokens[]);
//                b = new Book(tokens[0], tokens[1],
//                        +Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
//            }
//            library.put(b.getNumber(), b);//just get the book number there
//            System.out.println(library.keySet());
//        }
//        inputFile.close();
//
//
//    }
    }
}
