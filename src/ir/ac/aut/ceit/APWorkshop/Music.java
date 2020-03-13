package ir.ac.aut.ceit.APWorkshop;


import java.util.Objects;

/**
 * Music class
 *
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public class Music {
    private String name;
    private String address;
    private String artist;
    private int year;

    public Music(String name,String address, String artist, int year) {
        this.name = name;
        this.address = address;
        this.artist = artist;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Music)) return false;
        Music music = (Music) o;
        return getYear() == music.getYear() &&
                Objects.equals(getName(), music.getName()) &&
                Objects.equals(getAddress(), music.getAddress()) &&
                Objects.equals(getArtist(), music.getArtist());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), getArtist(), getYear());
    }

    @Override
    public String toString() {
        return "Music{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                '}';
    }
}
