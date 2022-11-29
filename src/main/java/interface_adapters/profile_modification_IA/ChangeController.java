package interface_adapters.profile_modification_IA;

/**
 * To make a change to User entity, report if successful.
 */
public interface ChangeController {
    boolean reportChange(String username, String password, String feature, String newFeature);
    }
