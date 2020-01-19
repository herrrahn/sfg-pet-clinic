package com.rafaelrahn.sfgpetclinic.services;

import com.rafaelrahn.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findBylastName(String lastName);
}
