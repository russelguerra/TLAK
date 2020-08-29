package cs.com.tlak.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import cs.com.tlak.classes.User;

@Dao
public interface daoComm {
    @Query("SELECT * FROM User")
    List<User> getAccounts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAccount(User... User);

    @Query("SELECT * FROM User WHERE name = :name")
    List<User> getUser(String name);

    @Query("UPDATE User SET lastUser = :value WHERE name = :name")
    void updateLastUser(boolean value, String name);

    @Query("SELECT * FROM User WHERE lastUser = 1")
    List<User> getLastUser();

    @Query("DELETE FROM User WHERE id = :id")
    void deleteUser(int id);

    @Query("UPDATE User SET name = :name, gender = :gender WHERE id = :id")
    void updateUser(String name, String gender, int id);
}
