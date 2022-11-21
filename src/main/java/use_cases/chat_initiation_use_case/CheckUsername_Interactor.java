package use_cases.chat_initiation_use_case;


import data_access.UserDatabase;

/**
 * CheckUsernameInteractor responsible checking if a username exist in our userdata base
 */


public class CheckUsername_Interactor {

    final UserDatabase db;

    public CheckUsername_Interactor(UserDatabase db){
        this.db = db;
    }

    //checking if the username exist in username database via function UserExists(username).
     public boolean checkusername(String username){
         if(!(db.UserExists(username))){
             return false;
         }
         return true;
        }
     }
