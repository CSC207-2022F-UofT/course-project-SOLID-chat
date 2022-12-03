package interface_adapters.user_search_IA;
import entities.user_entities.User;
import java.util.List;
/**
 * allows for the User Database (whatever type it may be) to present all its users in a list format.
 */
public interface IRetrieveList {
    List<User> getList();
}
