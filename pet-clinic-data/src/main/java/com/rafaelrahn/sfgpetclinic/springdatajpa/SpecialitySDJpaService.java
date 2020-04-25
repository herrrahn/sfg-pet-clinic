package com.rafaelrahn.sfgpetclinic.springdatajpa;

import com.rafaelrahn.sfgpetclinic.model.Speciality;
import com.rafaelrahn.sfgpetclinic.model.Vet;
import com.rafaelrahn.sfgpetclinic.repositories.SpecialityRepository;
import com.rafaelrahn.sfgpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

public class SpecialitySDJpaService implements SpecialtyService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
