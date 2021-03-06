package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class StringPreferenceTest extends AbstractPreferenceTest {

    protected final String mTestValue = "Hello World";
    protected final String mDefaultValue = "Empty";

    @Before @Override
    public void beforeEach() {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        mPreference = new StringPreference(sharedPreferences, PREFERENCES_KEY, mDefaultValue);
    }

    @Test @Override
    public void expect_Preference_To_BeInitialized() throws Exception {
        assertNotNull(mPreference);
    }

    @Test @Override
    public void expect_Preference_To_EqualDefaultValue() throws Exception {
        final SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(Robolectric.application);
        StringPreference preference = new StringPreference(sharedPreferences, PREFERENCES_KEY);
        assertEquals(preference.get(), StringPreference.DEFAULT_VALUE_VALUE);
    }

    @Test @Override
    public void expect_Preference_To_BeSet() throws Exception {
        ((StringPreference) mPreference).set(mTestValue);
        assertTrue(mPreference.isSet());
    }

    @Test @Override
    public void expect_Preference_To_EqualDefaultValue_BeforeBeingSet() throws Exception {
        assertEquals(mPreference.get(), mDefaultValue);
        assertNotEquals(mPreference.get(), mTestValue);
    }

    @Test @Override
    public void expect_Preference_To_EqualValue() throws Exception {
        ((StringPreference) mPreference).set(mTestValue);
        assertEquals(mPreference.get(), mTestValue);
    }

    @Test @Override
    public void expect_Preference_NotTo_EqualValue() throws Exception {
        ((StringPreference) mPreference).set("Something else");
        assertNotEquals(mPreference.get(), mTestValue);
    }

    @Test @Override
    public void expect_Preference_To_BeUnset() throws Exception {
        ((StringPreference) mPreference).set(mTestValue);
        mPreference.delete();
        assertNotEquals(mPreference.get(), mTestValue);
    }

}
