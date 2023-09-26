package io.rizcky.contact.management.repository;

import io.rizcky.contact.management.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {
}
