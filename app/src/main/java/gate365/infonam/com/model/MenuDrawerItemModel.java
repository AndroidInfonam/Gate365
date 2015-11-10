package gate365.infonam.com.model;

/**
 * Created by Thoai Bui on 11/10/2015.
 */
public class MenuDrawerItemModel {
    public int icon;
    public String title;

    // Constructor.
    public MenuDrawerItemModel(String title, int icon) {

        this.icon = icon;
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public int getIcon(){
        return this.icon;
    }

}
