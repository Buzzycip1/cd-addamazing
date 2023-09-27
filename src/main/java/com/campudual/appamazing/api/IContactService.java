package com.campudual.appamazing.api;

import com.campudual.appamazing.model.dto.ContactDto;


import java.util.List;

public interface IContactService {

    ContactDto queryContact(ContactDto contactDTO);
    List<ContactDto> queryAllContact();
    int insertContact(ContactDto contactDTO);
    int updateContact(ContactDto contactDTO);
    int deleteContact(ContactDto contactDTO);








}
