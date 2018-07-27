package xyz.spiral6.aether.units.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface UnitDAO {
    @Query("SELECT SearchName FROM UnitAttributes")
    List<String> getUnitList();

    /*@Query("SELECT rowid as _id FROM UnitAttributes WHERE DisplayName LIKE :name LIMIT 3")
    public Cursor getUnitListCursor(String name);*/

    @Query("SELECT * FROM UnitAttributes WHERE SearchName = :SearchName LIMIT 1 ")
    UnitEntity getUnit(String SearchName);
}
