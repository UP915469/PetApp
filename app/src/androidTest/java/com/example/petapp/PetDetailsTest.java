package com.example.petapp;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class PetDetailsTest {
    @Rule
    public ActivityTestRule<PetDetails> mActivityTestRule = new ActivityTestRule<PetDetails>(PetDetails.class);

    private PetDetails mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(PetNutrition.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        assertNotNull(mActivity.findViewById(R.id.nutrition_btn));

        onView(withId(R.id.nutrition_btn)).perform(scrollTo()).perform(click());

        Activity petNutrition = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        assertNotNull(petNutrition);

        petNutrition.finish();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}