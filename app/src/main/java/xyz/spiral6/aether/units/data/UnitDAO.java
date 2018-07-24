package xyz.spiral6.aether.units.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import java.util.List;
@Dao
public interface UnitDAO {
    @Query("SELECT DisplayName FROM UnitAttributes")
    public List<String> getUnitList();

    /*@Query("SELECT rowid as _id FROM UnitAttributes WHERE DisplayName LIKE :name LIMIT 3")
    public Cursor getUnitListCursor(String name);*/

    @Query("SELECT * FROM UnitAttributes WHERE DisplayName = :DisplayName LIMIT 1 ")
    public UnitEntity getUnit(String DisplayName);
}
