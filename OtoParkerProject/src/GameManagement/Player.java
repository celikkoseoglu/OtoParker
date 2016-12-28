package GameManagement;

import java.util.ArrayList;

public class Player {
    private int numberOfStars;

    private String currentCarColor;
    private String currentCarWeapon;
    private double currentCarTurningRadius;

    private ArrayList<String> unlockedCarColors;
    private ArrayList<String> unlockedCarWeapons;
    private ArrayList<Double> unlockedCarTurningRadiuses;

    public Player(int numberOfStars, String currentCarColor, String currentCarWeapon, double currentCarTurningRadius, String[] unlockedCarColors, String[] unlockedCarWeapons, String[] unlockedCarTurningRadiuses) {
        this.numberOfStars = numberOfStars;
        this.currentCarColor = currentCarColor;
        this.currentCarWeapon = currentCarWeapon;
        this.currentCarTurningRadius = currentCarTurningRadius;

        this.unlockedCarColors = new ArrayList<>();
        this.unlockedCarWeapons = new ArrayList<>();
        this.unlockedCarTurningRadiuses = new ArrayList<>();

        for (String s : unlockedCarColors)
            this.unlockedCarColors.add(s);
        for (String s : unlockedCarWeapons)
            this.unlockedCarWeapons.add(s);
        for (String s : unlockedCarTurningRadiuses)
            this.unlockedCarTurningRadiuses.add(Double.parseDouble(s));
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(double val){numberOfStars += val;}

    public String getCurrentCarColor() {
        return currentCarColor;
    }

    public void setCurrentCarColor(String nc){currentCarColor = nc;}

    public String getCurrentCarWeapon() {
        return currentCarWeapon;
    }

    public void setCurrentCarWeapon(String nw){currentCarWeapon = nw;}

    public double getCurrentCarTurningRadius() {
        return currentCarTurningRadius;
    }

    public ArrayList<String> getUnlockedCarColors() {
        return unlockedCarColors;
    }

    public ArrayList<String> getUnlockedCarWeapons() {
        return unlockedCarWeapons;
    }

    public ArrayList<Double> getUnlockedCarTurningRadiuses() {
        return unlockedCarTurningRadiuses;
    }

    public void setCurrentCarTurningRadius(double currentCarTurningRadius) {
        this.currentCarTurningRadius = currentCarTurningRadius;
        System.out.println(currentCarTurningRadius);
    }
    public void changeCarColor(String nc){
        if (getNumberOfStars() >=  Prices.COLOR_COST && !(unlockedCarColors.contains(nc))){
            setNumberOfStars(-Prices.COLOR_COST);
            setCurrentCarColor(nc);
            unlockedCarColors.add(nc);
        }
    }
    public void increaseTR(){
        if (getNumberOfStars() >= Prices.TR_COST){
            setNumberOfStars(-Prices.TR_COST);
            setCurrentCarTurningRadius(getCurrentCarTurningRadius()+1);
            unlockedCarTurningRadiuses.add(getCurrentCarTurningRadius());
        }
    }
    public void changeWeapon(String nw){
        if (getNumberOfStars() >= Prices.WEAPON_COST && !(unlockedCarWeapons.contains(nw))){
            setNumberOfStars(-Prices.WEAPON_COST);
            setCurrentCarWeapon(nw);
            unlockedCarWeapons.add(nw);
        }
    }
}