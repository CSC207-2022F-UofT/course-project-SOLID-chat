package data_access;

import interface_adapters.user_search_IA.UserRetriever;
import use_cases.user_registration_use_cases.UserExists;
import use_cases.user_registration_use_cases.UserCreator;

public interface Database extends UserCreator, UserRetriever, UserExists {
}
