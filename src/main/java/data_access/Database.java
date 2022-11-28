package data_access;

import interface_adapters.User_search_IA.UserRetriever;
import use_cases.user_registration_use_cases.UserExists;
import use_cases.user_registration_use_cases.UserCreator;

public abstract class Database implements UserCreator, UserRetriever, UserExists {
}
