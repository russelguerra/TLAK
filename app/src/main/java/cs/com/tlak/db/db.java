package cs.com.tlak.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import cs.com.tlak.classes.User;

@Database(entities = {User.class,}, version = 1, exportSchema = false)
public abstract class db extends RoomDatabase {
    public abstract daoComm com();
}
