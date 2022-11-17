import javax.mail.Session;
public class EmailDelivery implements ISendVerificationCode{
    public void sendVerificationCode(String email, int code){
        /*TODO: When this is implemented, the verification code will be sent to the email specified by String email*/
        System.out.println("Verification code sent to " + email);

    }
}
