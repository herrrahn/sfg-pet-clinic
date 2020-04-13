package com.rafaelrahn.sfgpetclinic.repositories;

import com.rafaelrahn.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
