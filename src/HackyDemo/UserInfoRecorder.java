package HackyDemo;

import com.sun.istack.internal.NotNull;

/**
 * Created by FLK on 8/17/18.
 */
public class UserInfoRecorder {

    private UserInfo userInfos;

    public void setUserInfo(@NotNull UserInfo userInfos){
        this.userInfos = userInfos;
    }

    public String getUserFirstName(){
        return userInfos != null ? userInfos.getFirstName() : null;
    }

    public String getUserLastName(){
        return userInfos != null ? userInfos.getLastName() : null;
    }

    public String getExtraInfo(){
        return userInfos != null ? userInfos.getExtraInfo() : null;
    }


    //Is that right ?

    public String getCellphoneNum(){
        if(userInfos == null || userInfos.getExtraInfo() == null) return null;

        String extraInfo = userInfos.getExtraInfo();

        String[] extraInfos = extraInfo.split(",");

        return extraInfos.length > 0 ? extraInfos[extraInfos.length - 1] : null;
    }

}
