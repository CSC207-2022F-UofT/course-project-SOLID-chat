package interface_adapters.User_search_IA;

// UI implements this interface to invert the dependency of UI on the inner layers
public interface UserPresenter {
    String showProfile(String username);
}