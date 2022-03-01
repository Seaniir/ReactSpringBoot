package com.example.test_sb.controller;

import com.example.test_sb.model.Friends;
import com.example.test_sb.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class cda {

    @Autowired
    private FriendsRepository friendsRepository;

    @GetMapping("/")
    public String Home(Model model) {
        model.addAttribute("friendsList", friendsRepository.findAll());
        return "home";
    }

    @GetMapping("/employees")
    public List<Friends> getAllEmployees()
    {
        return friendsRepository.findAll();
    }

    @PostMapping("/")
    public String Home(@Validated Friends friend, BindingResult bindResult, Model model)
    {
        friendsRepository.save(friend);
        model.addAttribute("friendsList", friendsRepository.findAll());
        return "home";
    }

    @PostMapping("/addfriend")
    public void AddFriend(@Validated Friends friend, BindingResult bindResult, Model model)
    {
        friendsRepository.save(friend);
    }

    @GetMapping("/about")
    public String About()
    {
        return "about";
    }

    @GetMapping("/contact")
    public String Contact()
    {
        return "contact";
    }
}
