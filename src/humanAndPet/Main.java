package humanAndPet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(); // Исходно: у питомца есть имя, он не голоден и не спит.
        // Имя может быть задано при создании экземпляра.
        Bird bird = new Bird();
        WaterTurtle waterTurtle = new WaterTurtle();
        Human human = new Human();// Исходно: у человека есть имя, и у него нет повреждений на коже.
        // Имя может быть задано при создании экземпляра.
        House house = new House(human); // Дом - это список питомцев указанного человека.

        house.addPet(cat);
        house.addPet(bird);
        house.addPet(waterTurtle);

        System.out.println(human);
//      System.out.println(cat);
//      System.out.println(bird);
//      System.out.println(waterTurtle);

        house.print();
        System.out.println();

        if (!house.isEmpty()) {
            getActionsWithPet(house, human);
        }
    }

    static void getActionsWithPet(House house, Human human) {
        Pet pet = null;
        boolean check = true;
        while (check) {
            System.out.printf("Введите имя питомца, с которым человек будет взаимодействовать: ");
            Scanner scanner = new Scanner(System.in);
            String petName = scanner.nextLine();
            pet = house.findInHouse(petName);
            if (pet != null) {
                check = false;
                System.out.printf("Питомец c именем %s найден.\n", petName);
            }
        }
        human.giveAnotherNameForPet(pet); // Меняем питомцу имя. В случае изменения - питомец нанесет урон человеку
//(разный в зависимости от типа Питомца).
        System.out.println();

        human.callPet(pet); //Человек позвал питомца. Питомец не спит. Если может ответить - отвечает.
//      Также питомец двигается в сторону человека - по-разному в зависимости от типа Питомца.
        human.giveFoodToPet(pet); // Человек пробует покормить питомца. Питомец не голоден.
        System.out.println();

        pet.changeState(); // Питомец уснул

        System.out.println("Питомец " + pet.getName() + " сейчас: " + pet.getState() +
                ". Питомец проголодался? Ответ: " + pet.getHungry());// Если питомец уснул, то он стал голодным.
        human.callPet(pet); // Человек разбудил питомца.
        System.out.println();
        human.giveFoodToPet(pet); // Человек покормил питомца.
    }
}
