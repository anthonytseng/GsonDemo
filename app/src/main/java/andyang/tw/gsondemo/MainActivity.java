package andyang.tw.gsondemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;

import java.io.InputStream;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ListView lv;
    private ListAdapter adapter;
    private List<Employees> employeeses;
    private EmployeesParser parser;
    private String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        String json = getAssetJson();
        parser = new EmployeesParser();
        employeeses = parser.jsonToObject(json);
        adapter = new ListAdapter(getApplicationContext(), employeeses);
        lv.setAdapter(adapter);
    }

    public String getAssetJson() {
        try {
            InputStream stream = getAssets().open("employeesJson.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            String json = new String(buffer);
            return json;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return "";
    }
}
