package org.dongguri.reactsearchformdemo.controller;

import org.dongguri.reactsearchformdemo.service.SearchFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SearchFormController {

    @Autowired
    SearchFormService searchFormService;

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, the time at the server is now " + new Date() + "\n";
    }

    @PostMapping("/re-index")
    public ResponseEntity reIndex() throws Exception{
        return ResponseEntity.ok().body(searchFormService.reIndex());
    }
}
