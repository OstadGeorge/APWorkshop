package ir.ac.aut.ceit.APWorkshop;


import java.util.ArrayList;

/**
 * MusicManager Class
 *
 * @author Mohammad Ali Heydari
 * @version 0.1
 */
public class MusicManager {

    private ArrayList<MusicCollection> categories;

    public MusicManager() {
        this.categories = new ArrayList<>();
    }

    public ArrayList<MusicCollection> getCategories() {
        return categories;
    }

    public void addCategory(MusicCollection musicCollection) {
        categories.add(musicCollection);
    }

    public MusicCollection getCategory(int index) throws Exception {
        if(index < 0 || index >= categories.size()) {
            throw new Exception("index is out of range");
        }
        return categories.get(index);
    }

    public MusicCollection getCategory(String name) throws Exception {
        for(MusicCollection musicCollection : categories) {
            if(musicCollection.getName().equals(name)) {
                return musicCollection;
            }
        }
        throw new Exception("category not found!");
    }
}
