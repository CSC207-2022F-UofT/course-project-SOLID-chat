package PresentersControllersGateways;
import UseCases.UserRetriever;
public class UserLoginGateway {
    public UserRetriever database;

    String credential;
    String password;
    public UserLoginGateway(String credential, String password, UserRetriever database){
        this.database = database;
        this.credential = credential;
        this.password = password;
    }

}
