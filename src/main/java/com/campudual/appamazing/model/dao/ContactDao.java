package com.campudual.appamazing.model.dao;


import com.campudual.appamazing.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO es la capa que permite el  acceso entre el modelo creado y las bases de datos

public interface ContactDao extends JpaRepository< Contact, Integer> {


}
