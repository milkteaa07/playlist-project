/**
 * PLAYLIST TESTER
 * Sample of a tester file for the Playlist class. This file demonstrates all the capability of 
 * Playlist in the main method. 
 * 
 * Note: This tester is hardcoded. For interactive runner, see InterfaceRunner.java

 * @version 01-18-24
 */
public class PlaylistTester {
    public static void main(String[] args) {
        System.out.println("Initializing a Playlist...\n");
        Playlist p = new Playlist("Ava's Playlist");

        System.out.println("Adding songs to the Playlist...\n");
        /**
         * Add some songs here. Note that the format for adding a Song to a Playlist p
         * is something like...
         * p.addSong(new Song(..., ..., ...))
         */
        // title, artist, time, status
        p.add(new Song("Dancing Queen", "ABBA", "3:50"));
        p.add(new Song("Wildest Dreams (Taylor's Version)", "Taylor Swift", "3:40"));
        p.add(new Song("Jesse's Girl", "Rick Springfield", "3:14"));
        p.add(new Song("Still Into You", "Paramore", "3:36"));
        p.add(new Song("Take Me to Church", "Hozier", "4:01"));
        p.add(new Song("Blank Space (Taylor's Verson)", "Taylor Swift", "3:51"));
        p.add(new Song("Apocalypse", "Cigarettes After Sex", "4:50"));
        p.add(new Song("Strawberries & Cigarettes", "Troye Sivan", "3:21"));


        System.out.println("Printing the songs...\n");
        //Print out all the songs in the playlist to verify it's working correctly
        System.out.println(p.toString(p.getPlaylist()));

        System.out.println("\nLiking songs 1, 2, 3, & 7 etc....\n");
        //Once your songs are 'liked', this should be reflected in the next printout
        p.like(1-1);
        p.like(3-1);
        p.like(2-1);
        p.like(7-1);


        System.out.println("Printing the songs...\n");
        System.out.println(p.getLiked());

        System.out.println("\nRemoving songs 1, 5, & 8...\n");
        p.remove(8-1);
        p.remove(5-1);
        p.remove(1-1);
 
        System.out.println("Printing the songs...\n");
        System.out.println(p.toString(p.getPlaylist()));


        System.out.println("\nPrinting only the liked songs...\n");
        //Your Playlist should be able to do this without looping while in main!
        System.out.println(p.toString(p.getLiked()));


        System.out.println("\nPrinting the total duration of all songs...\n");
        //Note that the format should look something like minutes:seconds
        System.out.println("TOTAL DURATION: " + p.getTotalTime());


        System.out.println("\nRemoving all unliked songs from the playlist...\n");
        //This should be doable with a single method call
        p.removeUnliked();


        System.out.println("Printing all songs...\n");
        //This should now look like only the liked songs list from before
        System.out.println(p.toString(p.getPlaylist()));
    }
}
