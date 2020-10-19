package model;

public class Video extends Publication {
    private int lengthOfVideo;


    public Video(String videoName, int videoNumber, int lengthOfVideo) {
        super(videoName,videoNumber);
        this.lengthOfVideo = lengthOfVideo;

    }

    @Override
    public void setLength(int lengthOfVideo) {
        this.lengthOfVideo = lengthOfVideo;
    }

    @Override
    public int getLength() {
        return lengthOfVideo;
    }


//    @Override
//    public Library getPublicationLocation() {
//        return library;
//    }

//    @Override
//    public void setPublicationLocation(Library samLibrary) {
//        if (samLibrary != null) { //if the library is null
//            if (!samLibrary.contain(this)) { //if the library does not have the publication
////                library.crossOutPublication(this.getNumber());
//                this.getPublicationLocation().crossOutPublication(this.getNumber());
//                samLibrary.addPublication(this);
//                this.library = samLibrary;
//            } else if (samLibrary.contain(this)) { //if the library has got the publication
//                this.library = samLibrary;
//            }
//
//        }
//
//        this.library = null; //how to reduce duplication for two methods in different classes?
//        //if i put it in abstract class,
//    }


    @Override
    //EFFECTS:print out the length of the video and return it
    public int timeSpendOn() {
        System.out.println(lengthOfVideo);
        return lengthOfVideo;
    }

    @Override
    //EFFECTS: return the name number and length of the video
    public String toString() {
        return super.toString() + " " + lengthOfVideo;
    }



}
