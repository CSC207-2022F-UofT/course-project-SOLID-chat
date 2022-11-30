package use_cases.user_registration_use_cases;

public interface createMailMan {
    ISendVerificationCode getVerificationMethod(String type);
}
