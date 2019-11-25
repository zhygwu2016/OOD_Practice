package HackyDemo;

/**
 * Created by FLK on 8/17/18.
 */
public class UserInfo {

    private String firstName;
    private String lastName;

    //Currently, the extraInfo should looks like address + cellphone number
    //Like "3375 Scott Blvd,123-456-7890"
    private String extraInfo;

    public UserInfo(final String firstName, final String lastName, final String extraInfo){
        this.firstName = firstName;
        this.lastName = lastName;
        this.extraInfo = extraInfo;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getExtraInfo(){
        return extraInfo;
    }
}
