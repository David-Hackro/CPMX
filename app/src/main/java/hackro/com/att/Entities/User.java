package hackro.com.att.Entities;

import hackro.com.att.Interfaces.InterfaceValues;

/**
 * Created by hackro on 2/01/16.
 */
public class User implements InterfaceValues {


    private String name;
    private String email;
    private String photo;


    public User(String name, String email, String photo) {
        this.name = name;
        this.email = email;
        this.photo = photo;
    }

    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
