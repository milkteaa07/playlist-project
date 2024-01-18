import java.util.*;

/**
 * The Playlist class, which will keep track of a playlist of Song objects
 * Refer to the project description to make sure you have access to all available methods
 */
public class Playlist{
    /**
     * Fields-- This will likely just need to be the ArrayList of Songs. Reference our previous problems
     * (CarDealership, Zoo) for structure on how this will look
     */

     ArrayList<Song> playlist = new ArrayList<>();
    private String name;

     /**
      * Constructor-- this doesn't need any parameters. You should just initialize the ArrayList and
      * then use additional methods to add Songs in one-by-one
      */

    public Playlist(String name){
        this.name = name;
    }
      

      /**
       * Methods-- Remember that you need to be able to complete all of the following:
       * Adding a song
       * 'liking' a song
       * Removing a specific song
       * Examining all Songs (a String return or void print makes sense here)
       * Examining a sublist of all liked songs
       * Determining the total duration of all songs
       * Removing all unliked songs from the playlist (careful with this one!)
       */
    
    // GETTER METHODS
    public Song getSong(int i){
        return playlist.get(i);
    }

    public ArrayList<Song> getLiked(){
        ArrayList<Song> list = new ArrayList<>();
        for (Song s:playlist){
            if (s.getStatus() == "liked"){
                list.add(s);
            }
        }
        return list;
    }
    public String getTotalTime(){
        // 2:40
        int sec = 0;
        int min = 0;
        int hr = 0;
        for (Song s : playlist) {
            String time = s.getTime();
            String[] split = time.split(":", 0);
    
            if (split.length == 1) {
                sec += Integer.parseInt(split[0]);
            } else if (split.length == 2) {
                sec += Integer.parseInt(split[1]);
                min += Integer.parseInt(split[0]);
            } else {
                sec += Integer.parseInt(split[2]);
                min += Integer.parseInt(split[1]);
                hr += Integer.parseInt(split[0]);
            }
        }
    
        return simplify(sec, min, hr);
    }
    
    private String simplify(int s, int m, int h) {
        if (s >= 60) {
            m += s / 60;
            s %= 60;
        }
        if (m >= 60) {
            h += m / 60;
            m %= 60;
        }
        return h + ":" + m + ":" + s;
    }
    public String getPlaylistName(){
        return name;
    }
    public ArrayList<Song> getPlaylist(){
        return playlist;
    }

    // MUTATOR METHODS

    // add song
    public void add(Song s){
        playlist.add(s);
    }

    // like song
    public void like(Song s){
        // like by Song
        for (Song a:playlist){
            if (s.equals(a) && a.getStatus() != "liked"){
                a.setStatus();
            }
        }
    }
    public void like(int i){
        // like by index
        playlist.get(i).setStatus("liked");
    }
    public void unlike(int i){
        // like by index
        playlist.get(i).setStatus("no like");
    }
    public void like(String n){
        for (Song s:playlist){
            if (s.getTitle().equals(n)){
                s.setStatus("liked");
            }
        }
    }


    // remove song
    public void remove(Song s){
        // remove by Song
        for (int i=0; i<playlist.size(); i++){
            if (s.equals(playlist.get(i))){
                playlist.remove(i);
            }
        }
    }
    public void remove(int i){
        // remove by index
        i -= 1;
        playlist.remove(i);
    }
    public void remove(String n){
        for (int i=0; i<playlist.size(); i++){
            Song s = playlist.get(i);
            if (s.getTitle().equals(n)){
                playlist.remove(i);
            }
        }
    }
    public void remove(Integer[] list){
        for (int i: list){
            playlist.remove(i-1);
        }
    }

    // remove all unliked songs
    public void removeUnliked(){
        for (int i=0; i<playlist.size(); i++){
            Song s = playlist.get(i);
            if (s.getStatus() == "no like"){
                playlist.remove(i);
                i--;
            }
        
        }
    }
    public void rename(String n){
        name = n;
    }

    public String toString(ArrayList<Song> list){
        String output ="";
        output += name+"\n";
        for (int i=0;i<list.size();i++){
            Song curr = list.get(i);
            output += "    "+ (i+1) +". \""+ curr.getTitle()+"\" by "+curr.getArtist() + " ("+curr.getTime()+")"+"\n";
        }
        return output;
    }
}
