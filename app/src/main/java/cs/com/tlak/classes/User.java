package cs.com.tlak.classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String gender;
    private boolean lastUser;

    public User(String name, String gender, boolean lastUser) {
        this.name = name;
        this.gender = gender;
        this.lastUser = lastUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isLastUser() {
        return lastUser;
    }

    public void setLastUser(boolean lastUser) {
        this.lastUser = lastUser;
    }
}
