package observer;

import model.Library;
import model.Publication;
import model.Reader;

public interface Observer {
    public void update(Reader reader);



//    public void update(Publication publication);//should update something else
//
//    public int getReaderId();
//
//    public void assignReaderToLibrary(Library libraryReaderWant);
//
//    public Library getReaderLibrary();
}
