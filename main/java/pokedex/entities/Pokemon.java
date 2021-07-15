package pokedex.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pokemon {

    @Id
    private int dexNum;
    private String name;
    private String category;
    private String imageFile;
    private String type1;
    private String type2;

    public Pokemon(int dexNum, String name, String category, String imageFile, String type1, String type2) {
        this.dexNum = dexNum;
        this.name = name;
        this.category = category;
        this.imageFile = imageFile;
        this.type1 = type1;
        this.type2 = type2;
    }

    public Pokemon() {

    }

    public int getDexNum() {
        return dexNum;
    }

    public void setDexNum(int dexNum) {
        this.dexNum = dexNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }
}
