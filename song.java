public class Song {
    //Fields-- what information do we want each Song to store?
    private String title;
    private String artist;
    private String time;
    private String status;


    /**
     * Constructor-- what information needs to be given to make a Song?
     * How will you handle 'liked' songs? It makes sense for a Song not be 'liked' by default
     */
    public Song(String a, String b, String c, String d){
        title = a;
        artist = b;
        time = c;
        status = d;
    }

    public Song(String a, String b, String c){
        title = a;
        artist = b;
        time = c;
        status = "no like";
    }


     /**
      * Methods-- what will you want each Song to do?
      * Consider all the getter methods (getName, getArtist, etc.)
      * You should probably have a toString method to be able to get the information for the full
      * song easily as well!
      * What kind of mutator (setter) methods will you need?
      */

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
    public String getStatus(){
        return status;
    }
    
    // mutator methods
    public void setStatus(){
        // changes status to whatever it is not currently
        if (this.getStatus()=="no like"){
            this.status = "liked";
        }else{
            this.status = "no like";
        }
    }
    public void setStatus(String s){
        this.status = s;
    }

    public String toString(){
        return "Song: " + this.toString();
    }
}
