package si.tpo.fitin.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.validator.routines.EmailValidator;
import si.tpo.fitin.entities.User;
import si.tpo.fitin.model.LoginReq;
import si.tpo.fitin.model.RegistrationReq;
import si.tpo.fitin.repositories.UserRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public void register(@RequestBody RegistrationReq req) throws Exception{
        User user = new User();
        String username = req.getUsername();
        String email = req.getEmail();
        if(!userRepository.findByUsername(username).isPresent()) {
            if(!userRepository.findByEmail(email).isPresent()){
                //emailvalidator.getInstance(true) -> allow local adresses
                if(EmailValidator.getInstance(true).isValid(email)){
                    user.setUsername(username);
                    //validate email
                    user.setEmail(email);
                    user.setName(req.getName());
                    //encrypt password
                    user.setPassword(hashPassword(req.getPassword()));
                    user.setVip(false);
                    userRepository.save(user);
                }
                else{
                    throw new Exception("Invalid email format");
                }

            }
            else {
                throw new Exception("Email already exists");
            }

        }else{
            throw new Exception("Username already taken");
        }
    }

    @PostMapping("/login")
    public void register(@RequestBody LoginReq req) throws Exception{
        String username = req.getUsername();
        if(userRepository.findByUsername(username).isPresent()) {
            User user = userRepository.findByUsername(username).get();
            if(user.getPassword().equals(hashPassword(req.getPassword()))){
                return;
            }else{
                throw  new Exception("Wrong password");
            }

        }else{
            throw new Exception("Username doesn+t exist");
        }
    }

    public String hashPassword(String passwordToHash) throws Exception {
        String generatedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch (NoSuchAlgorithmException e){
            throw new Exception("Error while hasing password");
        }
        return generatedPassword;
    }

}
