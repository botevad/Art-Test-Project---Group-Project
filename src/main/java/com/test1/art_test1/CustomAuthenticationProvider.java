package com.test1.art_test1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Property of CODIX SA
 * Date: 4/15/2020 Time: 9:04 PM
 * <p>
 * TODO: WRITE THE DESCRIPTION HERE
 *
 * @author lparvov
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private final SecurityAuthService securityAuthService;

    public CustomAuthenticationProvider(SecurityAuthService securityAuthService) {
        this.securityAuthService = securityAuthService;
    }


    @Override
    public Authentication authenticate(Authentication auth)
            throws AuthenticationException {
        String username = auth.getName();
        String password = auth.getCredentials()
                .toString();

        return securityAuthService.getAuth(username, password);

    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
