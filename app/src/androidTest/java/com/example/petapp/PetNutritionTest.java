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
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

//Tests if the pet nutrition activity can be reached.
public class PetNutritionTest {
    @Rule
    public ActivityTestRule<PetNutrition> mActivityTestRule = new ActivityTestRule<PetNutrition>(PetNutrition.class);

    private PetNutrition mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        assertNotNull(mActivity.findViewById(R.id.food_img_1));
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}
