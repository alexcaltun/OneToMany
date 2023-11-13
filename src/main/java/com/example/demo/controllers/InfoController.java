package com.example.demo.controllers;

import com.example.demo.models.Info;
import com.example.demo.models.User;
import com.example.demo.repositories.InfoRepository;
import com.example.demo.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.function.Supplier;

@RestController
public class InfoController {

    @Autowired
    InfoRepository infoRepository;
    @Autowired
    UserRepository userRepository;


    @GetMapping("/getInfo")
    public List<Info> getAllInfo()
    {
        return infoRepository.findAll();
    }

    @GetMapping("/getInfo/{id}")
    public Optional<Info> getInfoById(@PathVariable Long id)
    {
        return infoRepository.findById(id);
    }



    @PostMapping("/addInfo")
    public void addInfo(@RequestBody Info info)
    {
        infoRepository.save(info);
    }

    @PutMapping("/addQuantity/{userId}/{type}/{quantity}")
    public void addQuantityByUserIdAndType(@PathVariable Long userId, @PathVariable String type, @PathVariable float quantity)
    {
        User user = userRepository.findById(userId)
               .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        for (Info info : user.getInfo()) {
            if (info.getType().equalsIgnoreCase(type))
            {
                info.setQuantity( info.getQuantity() + quantity);
                infoRepository.save(info);
                break;
            }

        }
    }

}



