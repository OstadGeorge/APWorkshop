package ir.ac.aut.ceit.APWorkshop;


import java.util.Scanner;

/**
 * Runner Class to run application
 *
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public class Runner {
    private MusicManager musicManager;
    private int status;
    private Scanner sc;

    public Runner() {
        sc = new Scanner(System.in);
        musicManager = new MusicManager();
        musicManager.addCategory(new MusicCollection("favorite"));
    }

    public void run() {
        System.out.println("MUSIC MANAGER SYSTEM\nCreated By Mohammad Ali Heydari\nlast update March 2020\n\n");
        while (true) {
            musicManagerMenu();
        }
    }

    private void musicManagerMenu() {
        System.out.println("Choose one option:");
        System.out.println("\t1- Show categories.");
        System.out.println("\t2- Add category.");
        System.out.println("\t3- Get category by index.");
        System.out.println("\t4- Get category by name.");
        System.out.println("\t5- Exit.");
        System.out.print("\nYour option: ");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                boolean flg = false;
                for(int i = 0; i < musicManager.getCategories().size(); ++i) {
                    try {
                        System.out.println(i + 1 + "- " + musicManager.getCategory(i));
                        flg = true;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                if(!flg) System.out.println("Music manger is Empty of collections.");
                break;
            case 2:
                System.out.println("Enter category name: ");
                String catName = sc.next();
                System.out.println("Category added successfully.");
                musicManager.addCategory(new MusicCollection(catName));
                break;
            case 3:
                System.out.println("Enter category index: ");
                int catIndex = sc.nextInt();
                try {
                    status = catIndex - 1;
                    musicCollectionMenu(musicManager.getCategory(catIndex - 1));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                System.out.println("Enter category name: ");
                String categoryName = sc.next();
                try {
                    for(int i = 0; i < musicManager.getCategories().size(); ++i) {
                        if(musicManager.getCategory(i).getName().equals(categoryName)) {
                            status = i;
                        }
                    }
                    musicCollectionMenu(musicManager.getCategory(categoryName));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Index out of range.");
        }
    }

    private void musicCollectionMenu(MusicCollection musicCollection) {
        System.out.println("You are in collection: " + musicCollection.getName());
        System.out.println("Size: " + musicCollection.getSize());
        System.out.println("Choose one option:");
        System.out.println("\t1- Show collection musics.");
        System.out.println("\t2- Change collection name.");
        System.out.println("\t3- Add music.");
        System.out.println("\t4- Remove music.");
        System.out.println("\t5- Find music.");
        System.out.println("\t6- Return");
        System.out.print("\nYour option: ");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                if(musicCollection.getSize() == 0) {
                    System.out.println(musicCollection.getName() + " collection is empty.");
                }
                for(Music music : musicCollection.getMusics()) {
                    System.out.println(music);
                }
                musicCollectionMenu(musicCollection);
                break;
            case 2:
                System.out.println("Enter new name for this collection:");
                String newName = sc.next();
                boolean nameExists = false;
                for(MusicCollection mc : musicManager.getCategories()) {
                    if(mc.getName().equals(newName)) {
                        nameExists = true;
                        break;
                    }
                }
                if(!nameExists) {
                    try {
                        musicManager.getCategory(musicCollection.getName()).setName(newName);
                        System.out.println("Name changed to " + newName + " successfully.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(newName + " is already exists.");
                }
                musicCollectionMenu(musicCollection);
                break;
            case 3:
                System.out.print("Enter music name: ");
                String musicName = sc.next();
                System.out.print("Enter music artist: ");
                String musicArtistName = sc.next();
                System.out.print("Enter music address: ");
                String musicAddress = sc.next();
                System.out.print("Enter music year: ");
                int musicYear = sc.nextInt();
                try {
                    musicManager.getCategory(musicCollection.getName()).addMusic(new Music(musicName,musicAddress, musicArtistName, musicYear));
                    System.out.println(musicName + " added successfully.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                musicCollectionMenu(musicCollection);
                break;
            case 4:
                System.out.println("Enter music name to remove: ");
                String musicNameToRemove = sc.next();
                try {
                    musicManager.getCategory(musicCollection.getName()).removeMusic(musicNameToRemove);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                musicCollectionMenu(musicCollection);
                break;
            case 5:
                System.out.println("Enter pattern: ");
                String pattern = sc.next();
                boolean flg = false;
                for(Music music : musicCollection.findMusic(pattern)) {
                    System.out.println(music);
                    flg = true;
                }
                if(!flg) {
                    System.out.println("pattern not matched with any music.");
                }
                musicCollectionMenu(musicCollection);
                break;
            case 6:
                break;
            default:
                System.out.println("Index out of range.");
                musicCollectionMenu(musicCollection);
        }
    }

    private void musicMenu(Music music) {
        System.out.println(music);
        System.out.println("Choose one option:");
        System.out.println("\t1- Add to favorite");
        System.out.println("\t2- Return");
        System.out.print("\nYour option: ");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                boolean flg = false;
                try {
                    for(Music mc : musicManager.getCategory(0).getMusics()) {
                        if(mc.getName().equals(music.getName())) {
                            flg = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(flg) {
                    System.out.println("Music " + music.getName() + " is already in favorite collection.");
                } else {
                    try {
                        musicManager.getCategory(0).addMusic(music);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                musicMenu(music);
                break;
            case 2:
                try {
                    musicCollectionMenu(musicManager.getCategory(status));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                musicMenu(music);
        }

    }

    @Override
    protected void finalize() throws Throwable {
        sc.close();
        super.finalize();
    }
}
