package observer;

import model.Manager;
import model.Reader;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void notifyObserver(Reader reader) {
        for (Observer o : observers) {
            o.update(reader);
        }
    }

    //    public ReaderObserver getObserver(int id) {
//        if (observers.contains(id)) {
//            return observers.get(id);
//        } else {
//            return null;
//        }
//
//    }
//    public ReaderObserver getObserver(int id) {
//        for (ReaderObserver readerObserver : observers) {
//            if (readerObserver.getReaderId() == id) {
//                return readerObserver;
//            }
//        }
//        return null;
//    }

//    public void addObserver(ReaderObserver readerObserver) {
//        if (!observers.contains(readerObserver)) {
//            observers.add(readerObserver);
//            readerObserver.assignReaderToLibrary(readerObserver.getReaderLibrary());
//            //keep bi-directional relationship
//
//        }
//    }
//
//    public void removeObserver(ReaderObserver c) {
//        if (observers.contains(c)) {
//            c.assignReaderToLibrary(null);
//            observers.remove(c);
//        }
//    }
//
//    public boolean containReader(Reader r) {
//        if (observers.contains(r)) {
//            return true;
//        }
//        return false;
//    }
//
//    public void notifyObserver(Publication p) {
//        for (ReaderObserver ro : observers) {
//            ro.update(p);
//
//        }
//    }
}

