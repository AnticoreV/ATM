package sapronov.atm.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sapronov.atm.service.UserService;

import java.util.ArrayList;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    UserService userService = new UserService();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for(int i = 0; i < userService.getUsersCount(); i++){
            if(userService.findUser(i).getUser_name() == username){
                //new ArrayList : roles with permissions
                return new User(username, userService.findUser(i).getPassword(), new ArrayList<>());
            }
        }
        throw new UsernameNotFoundException(username);
    }
}