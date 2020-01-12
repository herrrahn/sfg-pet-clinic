package com.rafaelrahn.sfgpetclinic.services;

import com.rafaelrahn.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findBylastName(String lastName);
    Owner findByid(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
