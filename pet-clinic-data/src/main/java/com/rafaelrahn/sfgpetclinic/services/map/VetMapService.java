package com.rafaelrahn.sfgpetclinic.services.map;

import com.rafaelrahn.sfgpetclinic.model.Speciality;
import com.rafaelrahn.sfgpetclinic.model.Vet;
import com.rafaelrahn.sfgpetclinic.services.SpecialtyService;
import com.rafaelrahn.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialityService;

    public VetMapService(SpecialtyService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (!object.getSpecialties().isEmpty()) {
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(specialty);
                    specialty.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
