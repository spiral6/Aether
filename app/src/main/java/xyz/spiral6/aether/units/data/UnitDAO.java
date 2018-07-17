package xyz.spiral6.aether.units.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface UnitDAO {
    @Query("SELECT * FROM UnitAttributes WHERE DisplayName LIKE :name LIMIT 3")
    List<UnitEntity> find(String name);
}
