package cz.uhk.mois.edoras.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import cz.uhk.mois.edoras.domain.User;
import cz.uhk.mois.edoras.model.UserAuthDTO;

@RestController
public class UserController
{

    @PostMapping("/api/users/authenticate")
    public ResponseEntity<User> authenticate(@RequestBody UserAuthDTO userAuthDTO)
    {
        if ("test".equals(userAuthDTO.getUsername()))
        {
            // OK
            User user = new User();

            user.setToken("xxx-token");

            return new ResponseEntity(user, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
        }

    }
}
