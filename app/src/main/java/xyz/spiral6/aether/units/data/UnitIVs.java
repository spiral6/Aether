package xyz.spiral6.aether.units.data;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UnitIVs {
    private ArrayList<ArrayList<Integer>> Level1IVs;
    private int Level1Weapon;
    private ArrayList<ArrayList<Integer>> Level40IVs;
    private int Level40Weapon;
    private ArrayList<String> recommendedIVs;
    private String rarity;
    private String unitName;

    public UnitIVs(Context c, String unitName, String rarity) throws IOException {
        this.unitName = unitName;
        this.rarity = rarity;
        Level1IVs = new ArrayList<>();
        Level40IVs = new ArrayList<>();
        recommendedIVs = new ArrayList<>();
        loadIVs(c);
    }

    @SuppressWarnings("IfCanBeSwitch")
    private void loadIVs(Context c) throws IOException{

        ArrayList<Integer> level1low = new ArrayList<>();
        ArrayList<Integer> level1neutral = new ArrayList<>();
        ArrayList<Integer> level1high = new ArrayList<>();

        ArrayList<Integer> level40low = new ArrayList<>();
        ArrayList<Integer> level40neutral = new ArrayList<>();
        ArrayList<Integer> level40high = new ArrayList<>();

        String filename = "";
        if(rarity.equals("threestar")){
            filename = "3star.json";
        }
        if(rarity.equals("fourstar")){
            filename = "4star.json";
        }
        if(rarity.equals("fivestar")){
            filename = "5star.json";
        }

        AssetManager am = c.getAssets();
        InputStream inputStream = am.open("IVs/" + unitName + "/" + filename);

        JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
        reader.beginObject();
        while(reader.hasNext()){
            String name = reader.nextName();
            if(name.equals("Level1")){
                reader.beginObject();
                while(reader.hasNext()){
                    String level1name = reader.nextName();
                    if(level1name.equals("minus")){
                        reader.beginArray();
                        while(reader.hasNext()){
                            level1low.add(reader.nextInt());
                        }
                        reader.endArray();
                    }
                    else if(level1name.equals("neutral")){
                        reader.beginArray();
                        while(reader.hasNext()){
                            level1neutral.add(reader.nextInt());
                        }
                        reader.endArray();
                    }
                    else if(level1name.equals("plus")){
                        reader.beginArray();
                        while(reader.hasNext()){
                            level1high.add(reader.nextInt());
                        }
                        reader.endArray();
                    }
                    else if(level1name.equals("weapon")){
                        Level1Weapon = reader.nextInt();
                    }
                    else{
                        reader.skipValue();
                    }
                }
                reader.endObject();
            }
            else if(name.equals("Level40")){
                reader.beginObject();
                while(reader.hasNext()){
                    String level40name = reader.nextName();
                    if(level40name.equals("minus")){
                        reader.beginArray();
                        while(reader.hasNext()){
                            level40low.add(reader.nextInt());
                        }
                        reader.endArray();
                    }
                    else if(level40name.equals("neutral")){
                        reader.beginArray();
                        while(reader.hasNext()){
                            level40neutral.add(reader.nextInt());
                        }
                        reader.endArray();
                    }
                    else if(level40name.equals("plus")){
                        reader.beginArray();
                        while(reader.hasNext()){
                            level40high.add(reader.nextInt());
                        }
                        reader.endArray();
                    }
                    else if(level40name.equals("weapon")){
                        Level40Weapon = reader.nextInt();
                    }
                    else{
                        reader.skipValue();
                    }
                }
                reader.endObject();
            }else if(name.equals("recommendations")){
                reader.beginArray();
                while(reader.hasNext()){
                    recommendedIVs.add(reader.nextString());
                }
                reader.endArray();
            }
            else{
                reader.skipValue();
            }
        }
        reader.endObject();
        reader.close();

        Level1IVs.add(level1low);
        Level1IVs.add(level1neutral);
        Level1IVs.add(level1high);

        Level40IVs.add(level40low);
        Level40IVs.add(level40neutral);
        Level40IVs.add(level40high);
    }

    public static boolean[] getRarities(Context c, String unitName) throws IOException {
        AssetManager am = c.getAssets();
        String[] rarities = am.list("IVs/" + unitName);

        boolean threestar = false;
        boolean fourstar = false;
        boolean fivestar = false;

        for (String rarity: rarities) {
            if(rarity.equals("3star.json")){
                threestar = true;
            }
            if(rarity.equals("4star.json")){
                fourstar = true;
            }
            if(rarity.equals("5star.json")){
                fivestar = true;
            }
        }
        return new boolean[]{threestar,fourstar,fivestar};
    }

    public ArrayList<ArrayList<Integer>> getLevel1IVs(){
        return Level1IVs;
    }

    public ArrayList<ArrayList<Integer>> getLevel40IVs(){
        return Level40IVs;
    }

    public ArrayList<ArrayList<Integer>> getLevel1IVsWithWeapon(){
        ArrayList<Integer> low = Level1IVs.get(0);
        ArrayList<Integer> neutral = Level1IVs.get(1);
        ArrayList<Integer> high = Level1IVs.get(2);

        int newlowatk = low.get(1) + Level1Weapon;
        low.remove(1);
        low.add(1,newlowatk);
        int newneutralatk = neutral.get(1) + Level1Weapon;
        neutral.remove(1);
        neutral.add(1,newneutralatk);
        int newhighatk = high.get(1) + Level1Weapon;
        high.remove(1);
        high.add(1,newhighatk);

        ArrayList<ArrayList<Integer>> newIVs = new ArrayList<>();
        newIVs.add(low);
        newIVs.add(neutral);
        newIVs.add(high);
        return newIVs;
    }

    public ArrayList<ArrayList<Integer>> getLevel40IVsWithWeapon(){
        ArrayList<Integer> low = Level40IVs.get(0);
        ArrayList<Integer> neutral = Level40IVs.get(1);
        ArrayList<Integer> high = Level40IVs.get(2);

        int newlowatk = low.get(1) + Level40Weapon;
        low.remove(1);
        low.add(1,newlowatk);
        int newneutralatk = neutral.get(1) + Level40Weapon;
        neutral.remove(1);
        neutral.add(1,newneutralatk);
        int newhighatk = high.get(1) + Level40Weapon;
        high.remove(1);
        high.add(1,newhighatk);

        ArrayList<ArrayList<Integer>> newIVs = new ArrayList<>();
        newIVs.add(low);
        newIVs.add(neutral);
        newIVs.add(high);
        return newIVs;
    }

    @SuppressWarnings("unused")
    public ArrayList<String> getRecommendedIVs() {
        return recommendedIVs;
    }
}
