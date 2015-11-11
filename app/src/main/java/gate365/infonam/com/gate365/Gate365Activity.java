package gate365.infonam.com.gate365;

import android.os.Bundle;

public class Gate365Activity extends TimeToolbar {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate365);
        getWidgets();
        setEvents();
    }

    @Override
    protected void setTime() {
        super.setTime();
    }

    @Override
    protected void getWidgets() {
        createToolbar();
    }

    @Override
    protected void setEvents() {

    }
}

