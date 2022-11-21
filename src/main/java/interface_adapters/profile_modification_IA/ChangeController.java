package interface_adapters.profile_modification_IA;

/**
 * To make a change to User entity.
 */
public interface ChangeController {
    public boolean reportChange(String username, String password, String feature, String newFeature);
    }
