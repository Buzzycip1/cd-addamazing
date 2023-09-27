package com.campudual.appamazing.service;

import com.campudual.appamazing.api.IContactService;
import com.campudual.appamazing.model.Contact;
import com.campudual.appamazing.model.dao.ContactDao;
import com.campudual.appamazing.model.dto.ContactDto;
import com.campudual.appamazing.model.dto.dtomapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ContactService")
@Lazy
public class ContactService implements IContactService {

    @Autowired
    private ContactDao contactDao;


    @Override
    public ContactDto queryContact(ContactDto contactDTO) {

        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        Contact finalContact = this.contactDao.getReferenceById(contact.getId());
        return ContactMapper.INSTANCE.toDTO(finalContact);
    }

    @Override
    public List<ContactDto> queryAllContact() {
        return ContactMapper.INSTANCE.toDTOList(this.contactDao.findAll());
    }

    @Override
    public int insertContact(ContactDto contactDTO) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO); //genera un nuevo contacto  sin id
        Contact contact1 = this.contactDao.saveAndFlush(contact); // cuando se guarda en la  BD y devuelve un id
        return contact.getId();
    }

    @Override
    public int updateContact(ContactDto contactDTO) {
        return this.insertContact(contactDTO);
    }

    @Override
    public int deleteContact(ContactDto contactDTO) {
        int id = contactDTO.getId();
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        contactDao.delete(contact);
        return id;
    }
}
