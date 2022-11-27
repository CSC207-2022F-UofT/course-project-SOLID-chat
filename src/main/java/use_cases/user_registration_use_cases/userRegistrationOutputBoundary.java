package use_cases.user_registration_use_cases;

import data_access.Database;

public interface userRegistrationOutputBoundary {
    void accountExistsMessage();
    void verificationSuccessMessage(String message);
    void registrationSuccessAction(Database database);

}
