package com.czl.test.db;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class UserController {
        @RequestMapping("/hello")
        public String hello() {
            return "hello";
        }

}
