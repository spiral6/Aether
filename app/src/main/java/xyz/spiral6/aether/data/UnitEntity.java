package xyz.spiral6.aether.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "UnitAttributes", primaryKeys = {"DisplayName", "Epithet"})
public class UnitEntity{
    private String Name;
    @NonNull
    private String DisplayName;
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

    public String getLegendaryHP() {
        return LegendaryHP;
    }

    public String getLegendaryATK() {
        return LegendaryATK;
    }

    public String getLegendarySPD() {
        return LegendarySPD;
    }

    public String getLegendaryDEF() {
        return LegendaryDEF;
    }

    public String getLegendaryRES() {
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

    public void setLegendaryHP(String legendaryHP) {
        LegendaryHP = legendaryHP;
    }

    public void setLegendaryATK(String legendaryATK) {
        LegendaryATK = legendaryATK;
    }

    public void setLegendarySPD(String legendarySPD) {
        LegendarySPD = legendarySPD;
    }

    public void setLegendaryDEF(String legendaryDEF) {
        LegendaryDEF = legendaryDEF;
    }

    public void setLegendaryRES(String legendaryRES) {
        LegendaryRES = legendaryRES;
    }
}
