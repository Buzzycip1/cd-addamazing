package com.campudual.appamazing.model.dao;


import com.campudual.appamazing.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ContactDao extends JpaRepository< Contact, Integer> {


}
