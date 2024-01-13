import java.util.*;
public class song {
    //fields
    private ArrayList<String> playlist;
    private String title;
    private String artist;
    private double duration; //????
    private String status;


    //constructors
    public song(String myTitle, String myArtist, double myDuration, String myStatus){
        playlist = new ArrayList<String>();
        title = myTitle;
        artist = myArtist;
        duration = myDuration;
        status = myStatus;
    }



    //methods

    public void addSong(){
        
    }

    public void changeStatus(){
        
    }

    public void removeSong(){

    }

    public double total(){
        double total = 0;
        for(int i = 0; i < playlist.size(); i++){
            //get the duration of playlist[i] then add to total
        } 
        return total;
    }

    public void removeUnliked(){
        
    }
}
