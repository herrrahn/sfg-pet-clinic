package com.rafaelrahn.sfgpetclinic.repositories;

import com.rafaelrahn.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
