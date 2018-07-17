package xyz.spiral6.aether.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.huma.room_for_asset.RoomAsset;

@Database(entities = {UnitEntity.class}, version = 2)
public abstract class UnitDatabase extends RoomDatabase {
    public abstract UnitDAO UnitDAO();

    private static UnitDatabase INSTANCE;

    static UnitDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (UnitDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = RoomAsset.databaseBuilder(context.getApplicationContext(),
                            UnitDatabase.class, "Main.db")
                            .build();

                }
            }
        }
        return INSTANCE;
    }
}