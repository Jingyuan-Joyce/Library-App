package model;

import observer.Observer;

public class Manager implements Observer {
    private boolean hasUpdated = false;
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHasUpdated(boolean b) {
        this.hasUpdated = b;

    }

    public boolean getHasUpdate() {
        return hasUpdated;
    }


    @Override
    //MODIFIES: this
    //EFFECTS: print out welcome the reader and update the status of hasUpdated
    public void update(Reader reader) {
        System.out.println("welcome " + reader.toString());
        hasUpdated = true;
    }
}



