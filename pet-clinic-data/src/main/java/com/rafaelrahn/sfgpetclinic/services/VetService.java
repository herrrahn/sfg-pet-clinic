package com.rafaelrahn.sfgpetclinic.services;

import com.rafaelrahn.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByid(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
