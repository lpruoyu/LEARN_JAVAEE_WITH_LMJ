package programmer.lp.service;

public interface UserService1 {
    boolean login(String username, String password);
    boolean register(String username, String password, String pswdConfirm);
    void run(int count);
}