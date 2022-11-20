package interface_adapters.user_registration_interface_adapters;

import use_cases.user_login_use_case.UserCreator;

public class UserRegistrationGateway {
    private String username;
    private String password;
    private String email;
    private boolean userExists = false;
    private int code;
    private UserCreator database;

    private String preference;

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setUserExists(boolean userExists) {
        this.userExists = userExists;
    }

    public boolean isUserExists() {
        return userExists;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code){
        this.code = code;
    }

    public void setDatabase(UserCreator database) {
        this.database = database;
    }

    public UserCreator getDatabase(){
        return this.database;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
