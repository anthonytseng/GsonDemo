package andyang.tw.gsondemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andyang on 14/12/20.
 */
public class Employees {

    @SerializedName("firstName")
    String firstName;
    @SerializedName("lastName")
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    class aaa {

    }
}
