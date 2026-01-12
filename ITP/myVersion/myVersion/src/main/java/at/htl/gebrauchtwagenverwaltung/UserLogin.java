package at.htl.gebrauchtwagenverwaltung;

public class UserLogin {
    private int U_ID;
    private String username;
    private String password;
    private String email;
    private boolean adminRights;

    public UserLogin() {
    }

    public UserLogin(int u_ID, String username, String password, String email, boolean adminRights) {
        U_ID = u_ID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.adminRights = adminRights;
    }

    public int getU_ID() {
        return U_ID;
    }

    public void setU_ID(int u_ID) {
        U_ID = u_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdminRights() {
        return adminRights;
    }

    public void setAdminRights(boolean adminRights) {
        this.adminRights = adminRights;
    }
}
