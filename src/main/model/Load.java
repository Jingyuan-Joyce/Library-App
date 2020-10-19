package model;


import java.io.IOException;

public interface Load {
    public void loadable(String fn) throws IOException, ClassNotFoundException;
}
