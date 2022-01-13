package programmer.lp.old.service;

public interface UserService {
    boolean login(String username, String password);
    boolean register(String username, String password, String pswdConfirm);
}