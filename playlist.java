import java.util.*;
/**
 * PLAYLIST OBJECT
 * Creates an editable playlist 
 * 
 * @field ArrayList<Song> playlist
 * @field String name
 * 
 * constructors
 * @method Playlist (String name)
 * 
 * getters
 * @method getPlaylistName() - returns name of playlist
 * @method getSong(int i) - returns Song at index i
 * @method get Playlist() - returns ArrayList<Song> of all songs
 * @method getLiked() - returns ArrayList<Song> of all liked songs
 * @method getTotalTime() - returns String of total duration of playlist
 *
 * mutators
 * @method add(Song s) - adds a Song to playlist
 * @method like(int i) - likes Song at index i
 * @method unlike(int i) - unlikes Song at index i
 * @method remove(int i) - removes Song at index i
 * @method removeUnliked() - removes all unliked songs
 * @method toString() - prints all Songs in list format
 */

public class Playlist{

    ArrayList<Song> playlist = new ArrayList<>();
    private String name;

    public Playlist(String name){
        this.name = name;
    }
    
    // GETTER METHODS
    public String getPlaylistName(){
        return name;
    }
    public Song getSong(int i){
        return playlist.get(i);
    }
    public ArrayList<Song> getPlaylist(){
        return playlist;
    }
    public ArrayList<Song> getLiked(){
        ArrayList<Song> list = new ArrayList<>();
        for (Song s:playlist){
            if (s.getStatus()){
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
    
    // MUTATOR METHODS
    // add song
    public void add(Song s){
        playlist.add(s);
    }
    // like song
    public void like(int i){
        // like by index
        playlist.get(i).setStatus(true);
    }
    public void unlike(int i){
        // like by index
        playlist.get(i).setStatus(false);
    }

    // remove song
    public void remove(int i){
        // remove by index
        playlist.remove(i);
    }

    // remove all unliked songs
    public void removeUnliked(){
        for (int i=0; i<playlist.size(); i++){
            Song s = playlist.get(i);
            if (!s.getStatus()){
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
        for (int i=0;i<list.size();i++){
            Song curr = list.get(i);
            output += "    "+ (i+1) +". \""+ curr.getTitle()+"\" by "+curr.getArtist() + " ("+curr.getTime()+")"+"\n";
        }
        return output;
    }
}
