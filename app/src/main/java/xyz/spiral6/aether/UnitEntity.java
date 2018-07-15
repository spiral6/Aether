package xyz.spiral6.aether;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "UnitAttributes")
public class UnitEntity{
    @PrimaryKey
    @NonNull
    private String Name;
    private String DisplayName;
    @PrimaryKey
    @NonNull
    private String Epithet;
    private String FlavorText;
    private String Series;
    private String MoveType;
    private String WeaponType;
    private String Color;
    private int BST;
    private String WeaponSkills;
    private String ASkills;
    private String BSkills;
    private String CSkills;
    private String AssistSkills;
    private String SpecialSkills;
    private String LegendaryElement;
    private String LegendaryHP;
    private String LegendaryATK;
    private String LegendarySPD;
    private String LegendaryDEF;
    private String LegendaryRES;
}
