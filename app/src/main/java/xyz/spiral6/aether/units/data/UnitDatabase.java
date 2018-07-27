package xyz.spiral6.aether.units.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.huma.room_for_asset.RoomAsset;

@Database(entities = {UnitEntity.class}, version = 2)
public abstract class UnitDatabase extends RoomDatabase {
    public abstract UnitDAO UnitDAO();

    private static UnitDatabase INSTANCE;

    public static UnitDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (UnitDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = RoomAsset.databaseBuilder(context.getApplicationContext(),
                            UnitDatabase.class, "Main.db").allowMainThreadQueries() //TODO: Disable allowMainThreadQueries() once multithreading/async support is added.
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}