/**
 * SONG OBJECT
 * Creates an object storing song information
 * 
 * @field String title
 * @field String artist
 * @field String time - "--:--" format
 * @field boolean status - true: like, false: no like
 * 
 * constructors
 * @method Song(String title, String artist, String time, boolean status)
 * @method Song(String title, String artist, String time) - status defaults to "no like"
 * 
 * getters
 * @method getTitle() - returns String title
 * @method getArtist() - returns String artist
 * @method getTime() - returns String time
 * @method getStatus() - return String status
 * 
 * mutators
 * @method setTitle(String n) - changes title to n
 * @method set Artist(String n) - changes artist to n
 * @method setTime(String n) - changes time to n 
 * @method setStatus(boolean n ) - changes status to n
 * @method toString() - returns String of Song information
 * 
 */
public class Song{
    //fields
    private String title;
    private String artist;
    private String time;
    private boolean status;

    //constructors
    public Song(String a, String b, String c, boolean d){
        title = a;
        artist = b;
        time = c;
        status = d;
    }
    public Song(String a, String b, String c){
        title = a;
        artist = b;
        time = c;
        status = false;
    }

    // getter methods
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public String getTime(){
        return time;
    }
    public boolean getStatus(){
        return status;
    }
    
    // mutator methods
    public void setTitle(String t){
        this.title = t;
    }
    public void setArtist(String a){
        this.artist = a;
    }
    public void setDuration(String d){
        this.time = d;
    }
    public void setStatus(boolean s){
        this.status = s;
    }

    // String function
    public String toString(){
        return "\""+this.title+"\""+ " by "+this.artist+" ("+this.time+")";
    }
}
