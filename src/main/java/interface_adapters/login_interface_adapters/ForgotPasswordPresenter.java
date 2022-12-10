package interface_adapters.login_interface_adapters;

import screens.user_registration_screen.ViewHelper;
import use_cases.user_login_use_cases.RetrieveEmail;
import use_cases.user_registration_use_cases.ISendVerificationCode;

import java.util.Random;

public class ForgotPasswordPresenter {
    private final UserLoginPresenter loginPresenter;
    private final RetrieveEmail retrieveEmail;
    private final ISendVerificationCode sendVerificationCode;
    private String username;
    private String email;

    private final int code = new Random().nextInt(1341234);

    public ForgotPasswordPresenter(UserLoginPresenter loginPresenter, RetrieveEmail retrieveEmail, ISendVerificationCode
                                   sendVerificationCode){
        this.loginPresenter = loginPresenter;
        this.retrieveEmail = retrieveEmail;
        this.sendVerificationCode = sendVerificationCode;
    }

    public void allowLogin(int code){
        if(code == this.code){
            loginPresenter.setLoginCredentials(username);
            //Has to be changed, as tryLogin will only work with password
            loginPresenter.tryLoginNoPassword();
        }else{
            //TODO: have this take in a view object, that will output this message, so that this will only be a presenter
            ViewHelper.simpleMessage("Wrong verification code, try again", 250);
        }
    }
    public void tryGetEmail(){
        this.email = retrieveEmail.getEmail(this.username);
        if(this.email != null){
            sendVerificationCode.sendVerificationCode(email, code);
        }
    }

    public void setUsername(String username){
        this.username = username;
        this.tryGetEmail();
    }
}
