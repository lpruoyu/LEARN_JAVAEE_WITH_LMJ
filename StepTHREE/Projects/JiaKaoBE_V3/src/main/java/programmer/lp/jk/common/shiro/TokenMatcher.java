package programmer.lp.jk.common.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

@Slf4j
public class TokenMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        log.debug("TokenMatcher - doCredentialsMatch - {} {}", token, info);
        // 不用做匹配密码的判断，我们并不是处理“登录”操作，只是用来《鉴权》
        return true;
    }
}
