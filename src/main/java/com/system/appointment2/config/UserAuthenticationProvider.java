package com.system.appointment2.config;

import com.system.appointment2.model.JobSeeker;
import com.system.appointment2.repo.JobSeekerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAuthenticationProvider  implements AuthenticationProvider {
    @Autowired
    private JobSeekerRepo jobSeekerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username=authentication.getName();
        String pwd=authentication.getCredentials().toString();

        List<JobSeeker> jobSeekers= (List<JobSeeker>) jobSeekerRepo.findByEmail(username);
        if(jobSeekers.size() > 0){
            if(passwordEncoder.matches(pwd, jobSeekers.get(0).getPassword())){
                List<GrantedAuthority> authorities=new ArrayList<>();
                return new UsernamePasswordAuthenticationToken(username,pwd);
            }else {
                throw new BadCredentialsException("Invalid password.");
            }
        }else {
            throw new BadCredentialsException("Invalid email");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
    //me class eka wadak naa
}
