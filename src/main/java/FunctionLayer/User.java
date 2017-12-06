package FunctionLayer;

/**
 * The purpose of User is to...
 * @author AndersHC
 */
public class User {


    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String phone;
    private String username;
    private String email;
    private String password; // Should be hashed and all
    private String role;
    private String generated;


    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    

    public User( String username, String email, String password,String phone, String role, String generated ) {
        this.phone = phone;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.generated = generated;
        
    }

    public String getGenerated() {
        return generated;
    }

    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Username: " + username + "<br>Phone: " + phone + "<br>Email: " + email;
    }
    

}
