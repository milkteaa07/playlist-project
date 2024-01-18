import java.util.*;

/**
 * TO DO LIST:
 * - make option to only go back one page
 * - test all functions
 * - make sure program doesn't quit when invalid data in entered
 * - add booleans to editors: if empty exit editor
 * - clean up files (delete excess notes & methods)
 */
public class InterfaceRunner {
    public static void main(String[] args){
        
        System.out.println("Hello! Welcome to Playlist Maker!");
        System.out.println("What would you like to do today?");

        ArrayList<Playlist> all = new ArrayList<>();
        
        open(all);

    }
    public static void open(ArrayList<Playlist> all){
        
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while (!flag){
            System.out.println("\nHOME PAGE");
            System.out.println("    A: Make a new playlist");
            System.out.println("    B: Edit an existing playlist");
            System.out.println("    C: List existing playlists");
            System.out.println("    D: Exit");
            String choice = input.next(); 
            input.nextLine();
            if (choice.toLowerCase().equals("a")){
                System.out.println("Please enter a name for your playlist: ");
                String name = input.nextLine();
                Playlist p = new Playlist(name);
                System.out.println("Success! " + p.getPlaylistName() +" added. ");
                all.add(p);
                System.out.println();
            }else if (choice.toLowerCase().equals("b")){
                if (all.size() == 0){
                    System.out.println("No existiing playlists");
                }else{
                list(all);
                System.out.println("Enter the number of the playlist you would like to edit: ");
                int i = input.nextInt();
                System.out.println("Editing "+all.get(i-1).getPlaylistName()+"...");
                edit(all.get(i-1));
                }
            }else if (choice.toLowerCase().equals("c")){
                list(all);
            }else if (choice.toLowerCase().equals("d")){
                stop();
            }else{
                System.out.println("Please enter a valid option: ");
            }

            
        }
        input.close();
        
        
    }
    public static void list(ArrayList<Playlist> all){
        for (int i=0;i<all.size();i++){
             System.out.println("   "+(i+1)+". "+all.get(i).getPlaylistName());
        }
    }
    public static void edit(Playlist p){
        Scanner input = new Scanner(System.in);
        
        
        boolean done = false;
        while (!done){
            System.out.println("\nPLAYLIST EDITOR");
            System.out.println("Please select an option: ");
            System.out.println("    A: Add song                     B: Remove song");
            System.out.println("    C: Like/Unlike song             D: List all songs");
            System.out.println("    E: List liked songs             F: Find total duration of playlist");
            System.out.println("    G: Remove all unliked songs     H: Edit a song");
            System.out.println("    I: Return to main page          J: Exit"); //maybe add an option to only go back ONE page
            String i = input.next();
            input.nextLine();
        if (i.toLowerCase().equals("a")){
            System.out.println("Enter song title: ");
            String title = input.nextLine();
            System.out.println("Enter song artist: ");
            String artist = input.nextLine();
            System.out.println("Enter song duration [--:--]: ");
            String time = input.nextLine();
            Song s = new Song(title, artist, time);
            p.add(s);
            System.out.println("\""+s.getTitle()+"\" added!");
        }else if(i.toLowerCase().equals("b")){
            System.out.println(p.toString(p.getPlaylist()));
            System.out.println("Enter number of song you would like to remove: ");
            int n = input.nextInt();
            n-=1;
            System.out.println("\""+p.getSong(n).getTitle()+"\" removed");
            p.remove(n);
        }else if(i.toLowerCase().equals("c")){
            System.out.println(p.toString(p.getPlaylist()));
            System.out.println("Enter number of song you would like to edit: ");
            int b = input.nextInt();
            b-=1;
            System.out.println(b);
            System.out.println("Editing "+p.getSong(b).getTitle()+"...");
            System.out.println("Choose an option [1: like, 2: unlike]: ");
            int n = input.nextInt();
            if (n == 1){
                System.out.println(b);
                p.like(b);
                System.out.println("\""+p.getSong(n).getTitle()+"\" liked");
            }else if (n == 2){
                p.unlike(b);
                System.out.println("\""+p.getSong(n).getTitle()+"\" unliked");
            }
        }else if(i.toLowerCase().equals("d")){
            if (p.getPlaylist().size()==0){
                System.out.println("No songs");
            }else{
                System.out.println(p.toString(p.getPlaylist()));
            }
            
        }else if(i.toLowerCase().equals("e")){
            if (p.getLiked().size()==0){
                System.out.println("No liked songs");
            }else{
                System.out.println(p.toString(p.getLiked()));
            }
        }else if(i.toLowerCase().equals("f")){
            System.out.println("TOTAL DURATION: "+p.getTotalTime());
        }else if(i.toLowerCase().equals("g")){
            p.removeUnliked();
            System.out.println("All unliked songs removed.");
        }else if(i.toLowerCase().equals("h")){
            System.out.println(p.toString(p.getPlaylist()));
            int b = input.nextInt();
            editSong(p.getSong(b-1));
        }else if(i.toLowerCase().equals("i")){
            done = true;
        }else if(i.toLowerCase().equals("j")){
            stop();
        }else{
            System.out.println("Please enter valid option: ");
        }
    }
        input.close();
    }
    public static void editSong(Song s){
        System.out.println(s.toString());
        boolean done = false;
        Scanner input = new Scanner(System.in);
        while (!done){
            System.out.println("\nSONG EDITOR");
            System.out.println("Please select an option: ");
            System.out.println("    A: Change name                  B: Change artist");
            System.out.println("    C: Change duration              D: Change status");
            System.out.println("    E: Back                         F: Return to main page");
            System.out.println("    G: Exit");
            String c = input.next();
            input.nextLine();

            if (c.toLowerCase().equals("a")){
                System.out.println("Please enter new name: ");
                String name = input.nextLine();
                s.setTitle(name);
            }else if (c.toLowerCase().equals("b")){
                System.out.println("Please enter new artist: ");
                String name = input.nextLine();
                s.setArtist(name);
            }else if (c.toLowerCase().equals("c")){
                System.out.println("Please enter new duration: ");
                String name = input.nextLine();
                s.setDuration(name);
            }else if (c.toLowerCase().equals("d")){
                System.out.println("Please enter new status [1: no like, 2: liked]: ");
                int n = input.nextInt();
                if (n == 1){
                    s.setStatus(false);
                }else if (n == 2){
                    s.setStatus(true);
                }
            }else if (c.toLowerCase().equals("e")){
                done = true;
            }else if (c.toLowerCase().equals("f")){
                
            }else if (c.toLowerCase().equals("g")){
                stop();
            }else{
                System.out.println("Please enter valid option: ");
            }

       }
       input.close();
    }
    public static void stop(){
        System.out.println("Thanks for visiting! Come back soon :)");
        System.exit(0);
    }
}
