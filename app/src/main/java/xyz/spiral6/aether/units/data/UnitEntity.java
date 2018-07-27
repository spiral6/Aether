package xyz.spiral6.aether.units.data;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;

@Entity(tableName = "UnitAttributes", primaryKeys = {"SearchName", "Epithet"})
public class UnitEntity implements Serializable{
    @NonNull
    private String Name;
    @NonNull
    private String DisplayName;
    @NonNull
    private String SearchName;
    @NonNull
    private String Epithet;
    @NonNull
    private String FlavorText;
    @NonNull
    private String Series;
    @NonNull
    private String MoveType;
    @NonNull
    private String WeaponType;
    @NonNull
    private String Color;
    @NonNull
    private int BST;
    private String WeaponSkills;
    private String ASkills;
    private String BSkills;
    private String CSkills;
    private String AssistSkills;
    private String SpecialSkills;
    private String LegendaryElement;
    @Nullable
    private Integer LegendaryHP;
    @Nullable
    private Integer LegendaryATK;
    @Nullable
    private Integer LegendarySPD;
    @Nullable
    private Integer LegendaryDEF;
    @Nullable
    private Integer LegendaryRES;

    public String getName() {
        return Name;
    }

    @NonNull
    public String getDisplayName() {
        return DisplayName;
    }

    @NonNull
    public String getEpithet() {
        return Epithet;
    }

    public String getFlavorText() {
        return FlavorText;
    }

    public String getSeries() {
        return Series;
    }

    public String getMoveType() {
        return MoveType;
    }

    public String getWeaponType() {
        return WeaponType;
    }

    public String getColor() {
        return Color;
    }

    public int getBST() {
        return BST;
    }
    public String getWeaponSkills() {
        return WeaponSkills;
    }
    public String getASkills() {
        return ASkills;
    }
    public String getBSkills() {
        return BSkills;
    }
    public String getCSkills() {
        return CSkills;
    }
    public String getAssistSkills() {
        return AssistSkills;
    }
    public String getSpecialSkills() {
        return SpecialSkills;
    }
    public String getLegendaryElement() {
        return LegendaryElement;
    }
    public Integer getLegendaryHP() {
        return LegendaryHP;
    }
    public Integer getLegendaryATK() {
        return LegendaryATK;
    }
    public Integer getLegendarySPD() {
        return LegendarySPD;
    }
    public Integer getLegendaryDEF() {
        return LegendaryDEF;
    }
    public Integer getLegendaryRES() {
        return LegendaryRES;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDisplayName(@NonNull String displayName) {
        DisplayName = displayName;
    }

    public void setEpithet(@NonNull String epithet) {
        Epithet = epithet;
    }

    public void setFlavorText(String flavorText) {
        FlavorText = flavorText;
    }

    public void setSeries(String series) {
        Series = series;
    }

    public void setMoveType(String moveType) {
        MoveType = moveType;
    }

    public void setWeaponType(String weaponType) {
        WeaponType = weaponType;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setBST(int BST) {
        this.BST = BST;
    }

    public void setWeaponSkills(String weaponSkills) {
        WeaponSkills = weaponSkills;
    }

    public void setASkills(String ASkills) {
        this.ASkills = ASkills;
    }

    public void setBSkills(String BSkills) {
        this.BSkills = BSkills;
    }

    public void setCSkills(String CSkills) {
        this.CSkills = CSkills;
    }

    public void setAssistSkills(String assistSkills) {
        AssistSkills = assistSkills;
    }

    public void setSpecialSkills(String specialSkills) {
        SpecialSkills = specialSkills;
    }

    public void setLegendaryElement(String legendaryElement) {
        LegendaryElement = legendaryElement;
    }

    public void setLegendaryHP(Integer legendaryHP) {
        LegendaryHP = legendaryHP;
    }

    public void setLegendaryATK(Integer legendaryATK) {
        LegendaryATK = legendaryATK;
    }

    public void setLegendarySPD(Integer legendarySPD) {
        LegendarySPD = legendarySPD;
    }

    public void setLegendaryDEF(Integer legendaryDEF) {
        LegendaryDEF = legendaryDEF;
    }

    public void setLegendaryRES(Integer legendaryRES) {
        LegendaryRES = legendaryRES;
    }

    @NonNull
    public String getSearchName() {
        return SearchName;
    }

    public void setSearchName(@NonNull String searchName) {
        SearchName = searchName;
    }
}
