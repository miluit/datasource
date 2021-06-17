package com.taotao.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/get")
    public String get() {
        return "run";
    }

    @GetMapping("/get/{id}")
    public String getId(@PathVariable("id") String id) {
        return " " + id;
    }

    @GetMapping("/get2")
    public String getId2(@RequestParam("id") String id) {
        return " " + id;
    }

   /* @GetMapping("/run")
    public String getRun() {
        return "devtools 成功";
    }*/

}
