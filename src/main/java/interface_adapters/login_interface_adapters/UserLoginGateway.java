package interface_adapters.login_interface_adapters;
import interface_adapters.User_search_IA.UserRetriever;
public class UserLoginGateway {
    public UserRetriever database;

    String credential;
    String password;
    public UserLoginGateway(String credential, String password, UserRetriever database){
        this.database = database;
        this.credential = credential;
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
    public String getCredential(){
        return this.credential;
    }
    public UserRetriever getDatabase(){
        return this.database;
    }

}
