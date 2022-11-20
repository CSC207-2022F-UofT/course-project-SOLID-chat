package data_access;

import interface_adapters.IRetrieveList;
import interface_adapters.user_registration_interface_adapters.UserExists;
import entities.user_entities.*;
import entities.user_entities.UserFactory;
import use_cases.user_login_use_case.UserCreator;
import interface_adapters.UserRetriever;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class UserDatabase implements UserExists, UserRetriever, UserCreator, IRetrieveList {
    File accounts;
    List<User> accountList;
    public UserDatabase(){
        this.accounts = new File("TestUserDatabase3.csv");
        this.accountList = this.getList();
    }
    public UserDatabase(File accounts){
        if(!accounts.exists()){
            try {
                accounts.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.accounts = accounts;
        this.accountList = this.getList();
    }
    @Override
    public boolean UserExists(String username, String email) {
        for(User user: this.accountList){
            if(user.getUsername().equals(username) || user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    // Creates a new user with a username and password, and an email address
    // The order is username, password, email address, verification status, status
    //
    @Override
    public void createUser(String username, String password, String email, String type){
        User newUser = UserFactory.BirthUser(username, password, email, type);
        this.accountList.add(newUser);
        try(FileOutputStream fileOut = new FileOutputStream(accounts)){
            try(ObjectOutputStream out = new ObjectOutputStream(fileOut)){
                out.writeObject(this.accountList);
                out.close();
                fileOut.close();
            }catch(Exception e){
                System.out.println("Error");
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }

    @Override
//  To be edited to get user from the array format rather than the serialized format.
    public User getUser(String username) {
        User ans = null;
        for (int i = 0; i < (this.getList().size()); i++) {
            if (this.getList().get(i).getUsername().equals(username)) {
                ans = this.getList().get(i);
            }
        }
        return ans;
    }

    //Returns an ArrayList with the users that is extracted from the file, so that other objects can use this list.
    @Override
    public List<User> getList() {
        List<User> users = new ArrayList<>();
        try(FileInputStream fileIn = new FileInputStream(accounts);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {

            users = (ArrayList<User>) in.readObject();
            return users;
        }catch(EOFException e){
            return users;
            } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
