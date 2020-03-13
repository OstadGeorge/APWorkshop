package ir.ac.aut.ceit.APWorkshop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * MusicCollection Class
 *
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public class MusicCollection {
    private String name;
    private ArrayList<Music> musics;

    public MusicCollection(String name) {
        this.name = name;
        this.musics = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Music> getMusics() {
        return musics;
    }

    public void addMusic(Music music) {
        musics.add(music);
    }

    public int getSize() {
        return musics.size();
    }

    public void removeMusic(Music music) {
        if(musics.contains(music)) {
            musics.remove(music);
        } else {
            System.out.println("Music not found!");
        }
    }

    public void removeMusic(String musicName) {
        Iterator<Music> iterator = musics.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getName().equals(musicName)) {
                iterator.remove();
                System.out.println("Music removed successfully.");
                return;
            }
        }
        System.out.println("Music not found!");
    }

    public ArrayList<Music> findMusic(String pattern) {
        ArrayList<Music> records = new ArrayList<>();
        for(Music music : musics) {
            if(music.getName().contains(pattern) || music.getAddress().contains(pattern)) {
                records.add(music);
            }
        }
        return records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicCollection)) return false;
        MusicCollection that = (MusicCollection) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "MusicCollection{" +
                "name='" + name + '\'' +
                '}';
    }
}
