package andyang.tw.gsondemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import andyang.tw.gsondemo.R;
import andyang.tw.gsondemo.model.Employees;

/**
 * Created by andyang on 14/12/20.
 */
public class ListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    public List<Employees> employees;

    public ListAdapter(Context context, List<Employees> employeeses) {
        this.context = context;
        this.employees = employeeses;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int position) {
        return employees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listitems, null);
            holder.firstName = (TextView) view.findViewById(R.id.tv_first_name);
            holder.lastName = (TextView) view.findViewById(R.id.tv_last_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.firstName.setText(employees.get(position).getFirstName());
        holder.lastName.setText(employees.get(position).getLastName());

        return view;
    }

    class ViewHolder {
        TextView firstName;
        TextView lastName;
    }
}
