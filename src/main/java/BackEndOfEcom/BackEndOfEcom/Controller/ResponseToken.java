package BackEndOfEcom.BackEndOfEcom.Controller;

public class ResponseToken {
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ResponseToken(String token) {
        this.token = token;
    }

    public ResponseToken() {
    }
}
