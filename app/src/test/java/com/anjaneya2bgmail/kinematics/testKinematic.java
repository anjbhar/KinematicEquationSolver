package com.anjaneya2bgmail.kinematics;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

@RunWith(RobolectricTestRunner.class)
public class testKinematic {
    private MainActivity activity;

    @Before
    public void setup() {
    activity = Robolectric.setupActivity(MainActivity.class);
}

    @Test
    public void testKinematic1() {
        activity.time.setText("4.0");
        activity.ivelocity.setText("10.0");
        activity.fvelocity.setText("5.0");
        activity.solve.performClick();
        assertEquals(-1.25, activity.a);
        assertEquals(30.0, activity.d );
    }

    @Test
    public void testClear() {
        activity.time.setText("4.0");
        activity.ivelocity.setText("10.0");
        activity.fvelocity.setText("5.0");
        activity.clearBtn.performClick();
        assertNull(activity.d);
}
}