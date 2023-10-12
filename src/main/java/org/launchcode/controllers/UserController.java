package org.launchcode.controllers;

import org.launchcode.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.openmbean.CompositeData;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @GetMapping
    public String displayUsers(Model model) {
        model.addAttribute("users", UserData.getAll());
    }
    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("name", user.getUsername());
        model.addAttribute("email", user.getEmail());

        if (user.getPasscode().equals(verify)) {
            user.setDate(String.valueOf(ZonedDateTime.now(ZoneId.systemDefault())));
            UserData.add(user);
            return "user/index";
        }

        model.addAttribute("error", "Passwords do not match.");
        return "user/add";
    }
}
