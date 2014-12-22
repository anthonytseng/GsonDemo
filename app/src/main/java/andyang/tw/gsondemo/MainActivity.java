package andyang.tw.gsondemo;

import android.util.Log;
import android.widget.ListView;

import java.io.InputStream;
import java.util.List;

import andyang.tw.gsondemo.adapter.ListAdapter;
import andyang.tw.gsondemo.model.Employees;
import andyang.tw.gsondemo.parser.EmployeesParser;


public class MainActivity extends BaseActivity {

    private ListView lv;
    private ListAdapter adapter;
    private List<Employees> employees;
    private EmployeesParser parser;
    private String TAG = MainActivity.class.getName();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViewById() {
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void doExtra() {
        String json = getAssetJson();
        parser = new EmployeesParser();
        employees = parser.jsonToObject(json);
        adapter = new ListAdapter(getApplicationContext(), employees);
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
