package BusinnesEntity;
public class UserBE extends ClientBE {
    private String Code;
    private String Name;
    private String LastnameP;
    private String LastnameM;
    private int UserState;
    
    public UserBE() {
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastnameP() {
        return LastnameP;
    }

    public void setLastnameP(String LastnameP) {
        this.LastnameP = LastnameP;
    }

    public String getLastnameM() {
        return LastnameM;
    }

    public void setLastnameM(String LastnameM) {
        this.LastnameM = LastnameM;
    }

    public int getCodeState() {
        return UserState;
    }

    public void setCodeState(int CodeState) {
        this.UserState = CodeState;
    }   
}
