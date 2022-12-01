package interface_adapters.user_search_IA;

/**
 * Implemented interface to invert the dependency of UI on the inner layers
 */
public interface UserPresenter {
    String showProfile(String username);
}
