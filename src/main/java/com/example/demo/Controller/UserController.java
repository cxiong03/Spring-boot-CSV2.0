package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@RestController
@RequestMapping(path = "/api/user/")

public class UserController {
    @GetMapping("csv")
    public String readCSV() {
        List<User> users = null;
        try {
             users = new CsvToBeanBuilder(
                    new FileReader("/Users/changxiong/Downloads/demo 3/src/main/resources/Users - Sheet1.csv"))
                    .withType(User.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!users.isEmpty()) {
            for(User user : users) {
                System.out.println(user.toString());
            }
            return "Our results are in the terminal!";
        } else {
            return "Error: Users not found";
        }
    }
}
