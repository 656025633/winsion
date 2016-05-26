package baseapp.task.activity.preference;

import android.os.Bundle;
import android.os.PersistableBundle;

import baseapp.R;

/**
 * Created by Mr.ZCM on 2016/5/25.
 * QQ:656025633
 * Company:winsion
 * Version:1.0
 * explain:
 */
public class MyPeferenceActivity extends android.preference.PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        addPreferencesFromResource(R.xml.test);
    }
}
