package gate365.infonam.com.model;

public class HomeItem {
    private int mIcon;
    private String mTitle;

    public HomeItem(int icon, String title) {
        this.mIcon = icon;
        this.mTitle = title;
    }

    public int getIcon() {
        return mIcon;
    }

    public String getTitle() {
        return mTitle;
    }
}
