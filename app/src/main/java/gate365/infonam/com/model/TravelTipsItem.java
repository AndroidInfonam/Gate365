package gate365.infonam.com.model;

/**
 * Created by thang.cai on 11/12/2015.
 */
public class TravelTipsItem {
    private int countryFlag;
    private String countryName;
    private int flightState;
    private int iconNext;

    public TravelTipsItem(int countryFlag, String countryName, int flightState, int iconNext) {
        this.countryFlag = countryFlag;
        this.countryName = countryName;
        this.flightState = flightState;
        this.iconNext = iconNext;
    }

    public int getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(int countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getFlightState() {
        return flightState;
    }

    public void setFlightState(int flightState) {
        this.flightState = flightState;
    }

    public int getIconNext() {
        return iconNext;
    }

    public void setIconNext(int iconNext) {
        this.iconNext = iconNext;
    }
}
