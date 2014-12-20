package andyang.tw.gsondemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andyang on 14/12/20.
 */
public class ListAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater inflater;
    public List<Employees> employeeses;

    public ListAdapter(Context context, List<Employees> employeeses) {
        this.context = context;
        this.employeeses = employeeses;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return employeeses.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listitems, null);
            holder.firstName = (TextView) convertView.findViewById(R.id.tv_first_name);
            holder.lastName = (TextView) convertView.findViewById(R.id.tv_last_name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.firstName.setText(employeeses.get(position).getFirstName());
        holder.lastName.setText(employeeses.get(position).getLastName());

        return convertView;
    }

    class ViewHolder{
        TextView firstName;
        TextView lastName;
    }
}
