public class User {
    private String username;
    private String password;
    private String role;
    private Branch branch;

    public User(String username, String password, String role, Branch branch) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.branch = branch;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public Branch getBranch() {
        return branch;
    }
}
