package programmer.lp.old.service.proxy;

import programmer.lp.old.service.UserService;

public class UserServiceProxy implements UserService {

    private final UserService target;
    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("日志-----------------------------------start");
        boolean result = target.login(username, password);
        System.out.println("日志-----------------------------------end");
        return result;
    }

}
