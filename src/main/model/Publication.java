package model;


import java.util.Objects;

public abstract class Publication {
    protected String name;
    protected int number;
    private Library library;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Publication that = (Publication) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    //    public boolean compare(Publication p) {
////        return this.number == p.getNumber();
////    }
    public Publication(String name, int number) {
        this.name = name;
        this.number = number;


    }

    public void setName(String bn) {
        name = bn;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int nb) {
        number = nb;
    }

    public int getNumber() {
        return number;
    }

    public Library getPublicationLocation() {
        return library;
    }




    //MODIFIES:this,samLibrary
    //EFFECTS:if assign to library null, set the library field to null; if the library is not null and has
    //not been assigned, set the field to the sample library and add the publication to the sample library;
    //if the library is not null and has been assigned, change the library field to the sample library, add the
    //publication to the sample library and remove from the previous library assigned
    public void assignToLibrary(Library samLibrary) {
        if (samLibrary != null) {
            if (this.library == null) {
                this.library = samLibrary;
                samLibrary.addPublication(this);
            } else if (!this.library.equals(samLibrary)) {
                this.library.deletePublication(this);
                samLibrary.addPublication(this);
                this.library = samLibrary;
            }
        } else {
            this.library = null;
        }
    }


//        if (library != null) {
//            library.crossOutPublication(this.getNumber());
////          this.getPublicationLocation().crossOutPublication(this.getNumber());
//            samLibrary.addPublication(this);
//            this.library = samLibrary;
//        } else {
//            if (samLibrary != null) {
//                samLibrary.addPublication(this);
//                this.library = samLibrary;
//            }

    //MODIFIES:this,l
    //EFFECTS:if the library has been assigned, set the library field to null and remove the publication from
    // the library
    public void removeFromLibrary() {
        if (this.library != null) {
            Library l = getPublicationLocation();
            l.deletePublication(this);
            this.library = null;

        }
    }


//            if (samLibrary != this.getPublicationLocation()) { // override equals in library
//                library.crossOutPublication(this.getNumber());
////                this.getPublicationLocation().crossOutPublication(this.getNumber());
//                samLibrary.addPublication(this);
//                this.library = samLibrary;
//
//            } else if (samLibrary == this.getPublicationLocation()) {
//                this.library = samLibrary;
//            }
//        }
//        this.library = null;


    public abstract int timeSpendOn();

    public abstract void setLength(int length);

    public abstract int getLength();

    //EFFECTS: return the name and number of the publication
    public String toString() {
        return name + " " + number;
    }

}
