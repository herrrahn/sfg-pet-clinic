package com.rafaelrahn.sfgpetclinic.bootstrap;

import com.rafaelrahn.sfgpetclinic.model.*;
import com.rafaelrahn.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        if (petTypeService.findAll().isEmpty()) {
            loadData();
        }
    }

    private void loadData() {
        PetType petType = new PetType();
        petType.setName("Cat");
        PetType savePetTypeCat = petTypeService.save(petType);

        PetType petType2 = new PetType();
        petType2.setName("Dog");
        PetType savePetTypeDog = petTypeService.save(petType2);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("Maria");
        owner1.setLastName("Lura");
        owner1.setAddress("Rua Pirulito Rosa 123");
        owner1.setCity("Blumenau");
        owner1.setCity("123 3212 344");

        Pet mariasPet = new Pet();
        mariasPet.setPetType(savePetTypeCat);
        mariasPet.setName("Laura");
        mariasPet.setOwner(owner1);
        mariasPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mariasPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Matilda");
        owner2.setLastName("Lontra");
        owner2.setAddress("Rua Chambinho Puro 9");
        owner2.setCity("Pomerode");
        owner2.setCity("987 37624 344");

        Pet matildasPet = new Pet();
        matildasPet.setPetType(savePetTypeDog);
        matildasPet.setName("Otavio");
        matildasPet.setOwner(owner2);
        matildasPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(matildasPet);

        ownerService.save(owner2);

        Visit visit = new Visit();
        visit.setPet(matildasPet);
        visit.setDate(LocalDate.now());
        visit.setDescription("Gatinho");
        visitService.save(visit);

        System.out.println("Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Leoncio");
        vet1.setLastName("Lupresto");
        vet1.getSpecialties().add(savedRadiology);
        vet1.getSpecialties().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Carlos");
        vet2.setLastName("Caramujo");
        vet2.getSpecialties().add(savedDentistry);
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets loaded");
    }
}
