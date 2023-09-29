package com.campudual.appamazing.controller;


import com.campudual.appamazing.api.IContactService;
import com.campudual.appamazing.model.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private IContactService contactService;

    @GetMapping
    public String testController() {
        return "Product controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name) {
        return "Product controller works, " + name + "!";
    }

    @GetMapping(value = "/testMethod")
    public String testControllerMethod() {
        return "Product controller method works!";
    }

    @PostMapping(value = "/get")
    public ContactDto queryContact(@RequestBody ContactDto contact) {
        return this.contactService.queryContact(contact);
    }

    @GetMapping(value = "/getAll")
    public List<ContactDto> queryAllContact() {
        return this.contactService.queryAllContact();
    }

    @PostMapping(value = "/add")
    public int insertContact(@RequestBody ContactDto contact) {
        return this.contactService.insertContact(contact);
    }

    @PutMapping(value = "/update")
    public int updateContacts(@RequestBody ContactDto contact) {
        return this.contactService.updateContact(contact);
    }

    @DeleteMapping(value = "/delete")
    public int deleteContact(@RequestBody ContactDto contact) {
        return this.contactService.deleteContact(contact);
    }

}
