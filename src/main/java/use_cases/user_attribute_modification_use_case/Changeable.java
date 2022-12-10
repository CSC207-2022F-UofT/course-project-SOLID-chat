package use_cases.user_attribute_modification_use_case;
/**
 * User entity must implement this to change a feature.
 */
public interface Changeable {
    void changeFeature(String feature, String newFeature);
}
