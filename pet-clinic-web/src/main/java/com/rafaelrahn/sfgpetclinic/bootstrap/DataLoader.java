package com.rafaelrahn.sfgpetclinic.bootstrap;

import com.rafaelrahn.sfgpetclinic.model.Owner;
import com.rafaelrahn.sfgpetclinic.model.PetType;
import com.rafaelrahn.sfgpetclinic.model.Vet;
import com.rafaelrahn.sfgpetclinic.services.OwnerService;
import com.rafaelrahn.sfgpetclinic.services.PetTypeService;
import com.rafaelrahn.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType petType = new PetType();
        petType.setName("Cat");
        PetType savePetTypeCat = petTypeService.save(petType);

        PetType petType2 = new PetType();
        petType2.setName("Dog");
        PetType savePetTypeDog = petTypeService.save(petType2);


        Owner owner1 = new Owner();
        owner1.setFirstName("Maria");
        owner1.setLastName("Lura");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Matilda");
        owner2.setLastName("Lontra");

        ownerService.save(owner2);

        System.out.println("Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Leoncio");
        vet1.setLastName("Lupresto");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Carlos");
        vet2.setLastName("Caramujo");

        vetService.save(vet2);

        System.out.println("Vets loaded");

    }
}
