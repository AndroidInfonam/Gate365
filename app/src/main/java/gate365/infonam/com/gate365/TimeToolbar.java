package gate365.infonam.com.gate365;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by neil.tran on 11/10/2015.
 */
public abstract class TimeToolbar extends AppCompatActivity {

    //private Toolbar mToolbar;
    private TextView mToolbarTitle;
    private ImageView mLogoImage;
    private TextView mCurrentTimeTextView;
    private SimpleDateFormat mFormatTime;
    private DateFormat mDateFormat;
    private Calendar mCalendar;
    private Date mCurrentTime;

    // nav drawer title
    private TimerTask mTask;
    private Timer mTimer;

    protected void createToolbar() {
        //mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.titletool);
        mToolbarTitle.setText(R.string.title_toolbar);
        mLogoImage = (ImageView) findViewById(R.id.logoImage);
        mLogoImage.setImageResource(R.drawable._unicredit_icon);
        mCurrentTimeTextView = (TextView) findViewById(R.id.tvCurrentTime);
        setTime();
        //set auto update time title in 1 minus
        final Runnable setImageRunnable = new Runnable() {
            public void run() {
                setTime();
            }
        };
        mTask = new TimerTask() {
            public void run() {
                runOnUiThread(setImageRunnable);
            }
        };
        mTimer = new Timer();
        mTimer.schedule(mTask, 10000, 1000);
    }

    /*
     * set time title in actionbar
     */
    protected void setTime() {
        //get time zone
        mCalendar = Calendar.getInstance(Locale.getDefault());
        mCurrentTime = mCalendar.getTime();
        //format time hour and minus
        mDateFormat = new SimpleDateFormat("hh:mm a");
        mFormatTime = new SimpleDateFormat("E, MMM dd");
        //set time zone

        //mCalendar.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
        //mCalendar.setTimeZone(TimeZone.getDefault());

        //show time on text view
        mCurrentTimeTextView.setText(mFormatTime.format(mCurrentTime) + " - " + mDateFormat.format(mCurrentTime));
    }

    protected abstract void getWidgets();
    protected abstract void setEvents();
}
