package humanAndPet;

import java.util.ArrayList;

public class House {
    private Human human;
    private ArrayList<Pet> pets = new ArrayList<>();

    public House(Human human) {
        this.human = human;
    }

    public Human getHuman() {
        return human;
    }

    public ArrayList<Pet> getPets() {
        return this.pets;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public ArrayList<Pet> addPet(Pet pet) {
        if (!this.pets.contains(pet)) {
            this.pets.add(pet);
        }
        return this.pets;
    }

    private int checkInHouse(String petName) {
        int i = 0;
        for (Pet pet : this.pets) {
            if (pet.getName().equals(petName)) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.pets.size() == 0) {
            System.out.printf("В доме нет животных.");
            return true;
        }
        return false;
    }

    public Pet findInHouse(String petName) {
        Pet pet = null;
        int check = checkInHouse(petName);
        if (check == -1) {
            System.out.printf("В доме нет такого питомца!");
        } else {
            pet = this.pets.get(check);
        }
        return pet;
    }


    public void print() {
        if (this.pets.size() != 0) {
            System.out.printf("В доме человека есть вот такие питомцы: \n");
            for (Pet pet : this.pets) {
                System.out.printf("%s с именем %s.\n", pet.getClass().getSimpleName(), pet.getName());
            }
        }
    }
}



