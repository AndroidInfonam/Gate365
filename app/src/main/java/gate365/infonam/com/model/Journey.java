package gate365.infonam.com.model;

/**
 * Created by Neil.Tran on 11/22/2015.
 */
public class Journey {
    private int mPlanState;
    private String cityOfCountry;
    private int flightState;
    private int nextButon;

    public Journey(int planState, String cityOfCountry, int flightState, int nextButon) {
        setPlanState(planState);
        setCityOfCountry(cityOfCountry);
        setFlightState(flightState);
        setNextButon(nextButon);
    }

    public String getCityOfCountry() {
        return cityOfCountry;
    }

    public void setCityOfCountry(String cityOfCountry) {
        this.cityOfCountry = cityOfCountry;
    }

    public int getFlightState() {
        return flightState;
    }

    public void setFlightState(int flightState) {
        this.flightState = flightState;
    }

    public int getNextButon() {
        return nextButon;
    }

    public void setNextButon(int nextButon) {
        this.nextButon = nextButon;
    }

    public int getPlanState() {
        return mPlanState;
    }

    public void setPlanState(int planState) {
        this.mPlanState = planState;
    }
}
