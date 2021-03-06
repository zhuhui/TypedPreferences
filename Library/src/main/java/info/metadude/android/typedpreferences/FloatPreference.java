package info.metadude.android.typedpreferences;

import android.content.SharedPreferences;

/**
 * A wrapper class for a float preference.
 */
public class FloatPreference implements TypedPreference<Float> {

    protected final SharedPreferences mPreferences;
    protected final String mKey;
    protected final float mDefaultValue;
    public static final float DEFAULT_VALUE_VALUE = 0f;

    /**
     * Constructs a {@code float} preference for the given key
     * having the default value set to {@code 0} available.
     */
    public FloatPreference(final SharedPreferences preferences, final String key) {
        this(preferences, key, DEFAULT_VALUE_VALUE);
    }

    /**
     * Constructs a {@code float} preference for the given key
     * having the default value available.
     */
    public FloatPreference(final SharedPreferences preferences, final String key, float defaultValue) {
        mPreferences = preferences;
        mKey = key;
        mDefaultValue = defaultValue;
    }

    /**
     * Returns the stored {@code float} value if it exists
     * or the default value.
     */
    public Float get() {
        return mPreferences.getFloat(mKey, mDefaultValue);
    }

    /**
     * Returns {@code true} if some value is stored for
     * this preference, otherwise {@code false}.
     */
    public boolean isSet() {
        return mPreferences.contains(mKey);
    }

    /**
     * Stores the given {@code float} value.
     */
    public void set(Float value) {
        mPreferences.edit().putFloat(mKey, value).commit();
    }

    /**
     * Removes this preference setting.
     */
    public void delete() {
        mPreferences.edit().remove(mKey).commit();
    }

}
