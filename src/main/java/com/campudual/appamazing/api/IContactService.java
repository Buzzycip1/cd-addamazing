package com.campudual.appamazing.api;

import com.campudual.appamazing.model.dto.ContactDto;


import java.util.List;

public interface IContactService {

    ContactDto queryContact (ContactDto contact);
    List<ContactDto> queryAllContacts();
    int insertContact (ContactDto contact);
    int updateContact (ContactDto contact);
    int deleteContact (ContactDto contact);
}
