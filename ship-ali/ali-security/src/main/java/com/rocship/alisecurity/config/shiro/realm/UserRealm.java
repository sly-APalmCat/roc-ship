package com.rocship.alisecurity.config.shiro.realm;/**
 * Description: <br/>
 * date: 2020/12/21 11:43<br/>
 *
 * @version
 */

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * ClassName: UserRealm <br/>
 * Description: <br/>
 * date: 2020/12/21 11:43<br/>
 * @author 15438<br />
 */
@Component
public class UserRealm extends AuthorizingRealm {




    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {






        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
