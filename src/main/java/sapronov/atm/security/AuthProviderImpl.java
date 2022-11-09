package sapronov.atm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


//AuthProvider realize different authentications Oath2, JWT etc.
//provide XML
@Component
public class AuthProviderImpl implements AuthenticationProvider {
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService service;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        System.out.println(username);
        System.out.println(password);

        UserDetails u = service.loadUserByUsername(username);

        if (!encoder.matches(u.getPassword(), password)) {
            throw new BadCredentialsException("Invalid credentials.");
        }

        return new UsernamePasswordAuthenticationToken(username, password, u.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
