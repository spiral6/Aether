package xyz.spiral6.aether.data;

import android.app.Application;

public class UnitRepository {
    private UnitDAO mUnitDao;
    UnitRepository(Application application){
        UnitDatabase db = UnitDatabase.getDatabase(application);
        mUnitDao = db.UnitDAO();
    }
}
