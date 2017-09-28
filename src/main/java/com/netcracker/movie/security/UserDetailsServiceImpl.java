//package com.netcracker.movie.security;
//
//import com.netcracker.movie.model.User;
//import com.netcracker.movie.resopitory.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service("userDetailsService")
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private UserRepository userRepository;
//    private Converter<User, UserDetails> userUserDetailsConverter;
//
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Autowired
//    @Qualifier(value = "userToUserDetails")
//    public void setUserUserDetailsConverter(Converter<User, UserDetails> userUserDetailsConverter) {
//        this.userUserDetailsConverter = userUserDetailsConverter;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return null;
//    }
//}
