package use_cases.user_registration_use_cases;

import use_cases.user_registration_use_cases.ISendVerificationCode;

public class PhoneDelivery implements ISendVerificationCode {
    public void sendVerificationCode(String phoneNumber, int code){
        /*TODO: When this is implemented properly, the verification code will be sent to phone number specified by
        *  String phoneNumber*/
        System.out.println("Verification code sent to " + phoneNumber);
    }
}
