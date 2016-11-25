package ca.ucalgary.farmersmarketapp;

import java.util.ArrayList;

/**
 * Created by Whoosp on 2016-11-25.
 */

public class employee {
    String firstName;
    String lastName;
    ArrayList <String> Roles;

    public employee (String fName, String lName){
        firstName = fName;
        lastName = lName;
        Roles = new ArrayList<String>();
    }

    public void addRole(String role){
        if (!Roles.contains(role)){
            Roles.add(role);
        }
    }

    public void deleteRole(String role){
        if (Roles.contains(role)){
            Roles.remove(role);
        }
        /* TROLOLOLOLOLOLOL Array list has better methods :)
        int temp = 0;
        boolean found = false;
        for (int i = 0 ; i < Roles.size(); i++){
            if (Roles.get(i).equals(role)){
                temp = i;
                found = true;
            }
        }
        if (found){
            Roles.remove(temp);
        }
*/
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public ArrayList<String> getRoles(){
        return Roles;
    }

}
