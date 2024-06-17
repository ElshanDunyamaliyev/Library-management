//package com.example.Library.config;
//
//import com.example.Library.entity.User;
//import com.example.Library.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//
//
//    @Override
//    public Authentication authenticate(Authentication authentication){
//        String userName = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        List<User> users = userRepository.findByEmail(userName);
//
//        if(!users.isEmpty()){
//            User user = users.get(0);
//            boolean isEqual = passwordEncoder.matches(user.getPassword(),password);
//            if(isEqual){
//                List<GrantedAuthority> authorities = new ArrayList<>();
//                authorities.add(new SimpleGrantedAuthority(user.getRole()));
//                return new UsernamePasswordAuthenticationToken(userName, password, authorities);
//            }else{
//                throw new BadCredentialsException("Invalid password");
//            }
//        }else{
//            throw new BadCredentialsException("No user registered with this details");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//}
