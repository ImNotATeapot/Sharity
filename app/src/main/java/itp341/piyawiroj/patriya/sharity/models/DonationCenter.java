package itp341.piyawiroj.patriya.sharity.models;

import android.location.Address;

import java.util.Arrays;

public class DonationCenter {

    public static String EXTRA_POSITION = "Sharity_extra_donation_center_position";
    public static String EXTRA_LOCATION = "Sharity_extra_donation_center_location";
    public static String EXTRA_LATITUDE = "Sharity_extra_donation_center_latitude";
    public static String EXTRA_LONGITUDE = "Sharity_extra_donation_center_longitude";

    private String name;
    private Address address;
    private BusinessHour hours;
    private String notice;
    private String description;
    private String[] acceptedItems;
    private String[] notAcceptedItems;
    private String phoneNumber;
    private String email;
    private String website;
    private String instructions;
    private Address[] otherLocations;
    private String acceptedItemsDetails;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public DonationCenter() {
    }

    @Override
    public String toString() {
        return "DonationCenter{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", opening=" + hours +
                ", notice='" + notice + '\'' +
                ", description='" + description + '\'' +
                ", acceptedItems=" + Arrays.toString(acceptedItems) +
                ", notAcceptedItems=" + Arrays.toString(notAcceptedItems) +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", instructions='" + instructions + '\'' +
                ", otherLocations=" + Arrays.toString(otherLocations) +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BusinessHour getHours() {
        return hours;
    }

    public void setHours(BusinessHour hours) {
        this.hours = hours;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getAcceptedItems() {
        return acceptedItems;
    }

    public void setAcceptedItems(String[] acceptedItems) {
        this.acceptedItems = acceptedItems;
    }

    public String[] getNotAcceptedItems() {
        return notAcceptedItems;
    }

    public void setNotAcceptedItems(String[] notAcceptedItems) {
        this.notAcceptedItems = notAcceptedItems;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Address[] getOtherLocations() {
        return otherLocations;
    }

    public void setOtherLocations(Address[] otherLocations) {
        this.otherLocations = otherLocations;
    }

    public String getAcceptedItemsDetails() {
        return acceptedItemsDetails;
    }

    public void setAcceptedItemsDetails(String acceptedItemsDetails) {
        this.acceptedItemsDetails = acceptedItemsDetails;
    }
}
