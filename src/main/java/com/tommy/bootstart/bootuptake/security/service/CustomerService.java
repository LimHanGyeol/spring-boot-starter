package com.tommy.bootstart.bootuptake.security.service;

import com.tommy.bootstart.bootuptake.security.domain.Customer;
import com.tommy.bootstart.bootuptake.security.domain.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

/**
 * Section3. Spring Boot 활용
 * Spring Security
 */
@Service
public class CustomerService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer create(String username, String password) {
        Customer customer = new Customer(username, passwordEncoder.encode(password));
        return customerRepository.save(customer);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customerByUsername = customerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        String customerName = customerByUsername.getUsername();
        String customerPassword = customerByUsername.getPassword();
        return new User(customerName, customerPassword, authorities());
    }

    private Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
