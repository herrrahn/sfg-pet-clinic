package com.rafaelrahn.sfgpetclinic.repositories;

import com.rafaelrahn.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
