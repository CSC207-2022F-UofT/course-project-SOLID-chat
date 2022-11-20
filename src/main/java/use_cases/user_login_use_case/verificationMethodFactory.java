package use_cases.user_login_use_case;

public class verificationMethodFactory {
    String credential;
    String type;
    int code;
    ISendVerificationCode mailMan;
    public verificationMethodFactory(String credential, String type, int code){
        this.code = code;
        this.credential = credential;
        this.type = type;
        if(type.equals("Phone")){
            mailMan = new PhoneDelivery();
        } else if (type.equals("Email")){
            mailMan = new EmailDelivery();
        }
    }
    public void deliverCode(){
        mailMan.sendVerificationCode(credential, code);
    }
}
