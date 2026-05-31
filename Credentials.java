public class Credentials {
    String service;
    String username;
    String password;

    Credentials(String service, String username, String password){
        this.service = service;
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString(){
        return "Service: " + service +
            "\nUsername: " + username +
            "\nPassword: " + password;
    }
}
