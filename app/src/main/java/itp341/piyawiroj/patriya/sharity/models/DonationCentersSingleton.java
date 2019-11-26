package itp341.piyawiroj.patriya.sharity.models;

import android.content.Context;
import android.util.Pair;

import java.util.ArrayList;

// DonationCentersSingleton.get(this).getDonations()

public class DonationCentersSingleton {
    private static DonationCentersSingleton singleton;
    private ArrayList<DonationCenter> centers;
    private Context context;
    private ArrayList<Pair> donations; //<item, category>

    private DonationCentersSingleton(Context context) {
        this.context = context;
        centers = new ArrayList<>();
        setDonations();
    }

    public static DonationCentersSingleton get(Context context) {
        if (singleton == null) {
            singleton = new DonationCentersSingleton(context);
        }
        return singleton;
    }

    public ArrayList<Pair> getDonations() {
        return donations;
    }

    public void addCenter(DonationCenter center) {
        centers.add(center);
    }

    public ArrayList<DonationCenter> getCenters() {
        return centers;
    }

    private void setDonations() {
        TestCenters t = new TestCenters();
        centers = t.getCenters();

        donations = new ArrayList<>();
        //Clothing
        donations.add(new Pair("Underwear", "Clothing"));
        donations.add(new Pair("Bras", "Clothing"));
        donations.add(new Pair("Socks", "Clothing"));

        //Accessories
        donations.add(new Pair("Mittens", "Accessories"));
        donations.add(new Pair("Hats", "Accessories"));
        donations.add(new Pair("Gloves", "Accessories"));
        donations.add(new Pair("Caps", "Accessories"));
        donations.add(new Pair("Shoes", "Accessories"));

        //Emergency
        donations.add(new Pair("Tote bags", "Emergency Items"));
        donations.add(new Pair("Rolling luggage", "Emergency Items"));
        donations.add(new Pair("Sleeping bags", "Emergency Items"));
        donations.add(new Pair("Water bottles", "Emergency Items"));
        donations.add(new Pair("Tents", "Emergency Items"));
        donations.add(new Pair("Flashlights", "Emergency Items"));
        donations.add(new Pair("Sunscreen", "Emergency Items"));

        //Household
        donations.add(new Pair("Sheets", "Household Items"));
        donations.add(new Pair("Comforters", "Household Items"));
        donations.add(new Pair("Towels", "Household Items"));
        donations.add(new Pair("Pots and pans", "Household Items"));
        donations.add(new Pair("Utensils", "Household Items"));
        donations.add(new Pair("Vacuums", "Household Items"));
        donations.add(new Pair("Portable space heaters", "Household Items"));
        donations.add(new Pair("Cleaning supplies (new)", "Household Items"));

        //Personal Hygiene
        donations.add(new Pair("Toileteries", "Personal Hygiene"));
        donations.add(new Pair("Adult Diapers", "Personal Hygiene"));
        donations.add(new Pair("Sanitary Pads", "Personal Hygiene"));


        //Arts
        donations.add(new Pair("Knitting needles", "Arts"));
        donations.add(new Pair("Crochet hooks", "Arts"));
        donations.add(new Pair("Puzzles", "Arts"));
        donations.add(new Pair("Games", "Arts"));

        //Furniture

        //Books
    }
}
