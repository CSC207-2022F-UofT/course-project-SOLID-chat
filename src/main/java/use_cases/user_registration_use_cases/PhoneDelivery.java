package use_cases.user_registration_use_cases;

/**
 * Class that represents Phone verification. Currently unimplemented
 * */
public class PhoneDelivery implements ISendVerificationCode {
    /**
     * The function that is supposed to implement phone verification. Currently unimplemented
     * */
    public void sendVerificationCode(String phoneNumber, int code){
        /*TODO: When this is implemented properly, the verification code will be sent to phone number specified by
        *  String phoneNumber*/
        System.out.println("Verification code sent to " + phoneNumber);
    }
}
