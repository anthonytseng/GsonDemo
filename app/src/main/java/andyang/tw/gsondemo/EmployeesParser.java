package andyang.tw.gsondemo;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andyang on 14/12/20.
 */
public class EmployeesParser {

    public List<Employees> jsonToObject(String json) {
        List<Employees> employees = new ArrayList<Employees>();
        Gson gson = new Gson();
        Type type = new TypeToken<List<Employees>>() {
        }.getType();
        try {
            employees = gson.fromJson(json, type);
            return employees;
        } catch (Exception e) {
            Log.e("EmployeesParser", e.toString());
        }
        return employees;

    }
}
