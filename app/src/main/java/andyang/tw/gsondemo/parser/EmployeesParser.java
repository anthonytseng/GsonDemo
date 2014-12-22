package andyang.tw.gsondemo.parser;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import andyang.tw.gsondemo.model.Employees;

/**
 * Created by andyang on 14/12/20.
 */
public class EmployeesParser {

    private static final String TAG = EmployeesParser.class.getName();

    private Gson gson = new Gson();

    public List<Employees> jsonToObject(String json) {
        List<Employees> employees = new ArrayList<Employees>();
        Type type = new TypeToken<List<Employees>>() {
        }.getType();
        try {
            employees = gson.fromJson(json, type);
            return employees;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return employees;

    }
}
