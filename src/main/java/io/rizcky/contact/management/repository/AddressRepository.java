package io.rizcky.contact.management.repository;

import io.rizcky.contact.management.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
