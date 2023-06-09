package humanAndPet;

import java.util.Random;

public abstract class Pet {
    private String name;
    private boolean isHungry;
    private String[] names = new String[]{"Голди", "Зайка", "Гром", "Реми", "Пятнышко", "Молния", "Тайсон", "Джек",
            "Вольт"};

    abstract void moveTo(Human human);

    abstract void damage(Human human);

    enum State {
        isSleeping,
        isNotSleeping
    }

    private State state;

    /**
     * Общий приватный конструктор для класса.
     *
     * @param name     имя
     * @param isHungry статус: голодный или нет
     * @param state    статус: спит или нет
     */
    private Pet(String name, boolean isHungry, State state) {
        if (name.isEmpty()) {
            Random random = new Random();
            this.name = names[random.nextInt(0, names.length)];
        } else {
            this.name = name;
        }
        this.isHungry = isHungry;
        this.state = state;
    }

    /**
     * Публичный переопределенный конструктор класса. Есть возможность задать произвольное имя.
     *
     * @param name имя
     */
    public Pet(String name) {
        this(name, false, State.isNotSleeping);
    }

    /**
     * Публичный переопределенный конструктор класса. Без аргументов.
     */
    public Pet() {
        this("");
    }

    public String getName() {
        return name;
    }

    public boolean getHungry() {
        return isHungry;
    }

    public State getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeFood() {
        if (this.isHungry) {
            this.isHungry = false;
        }
    }

    private void gettingHungry(State state) {
        if (this.state == State.isSleeping) {
            isHungry = true;
        }
    }

    public void changeState() {
        if (this.state == State.isNotSleeping) {
            this.state = State.isSleeping;
            gettingHungry(this.state);
        } else {
            this.state = State.isNotSleeping;
        }
    }

    @Override
    public String toString() {
        return "У нас есть питомец " + name + ". Это " + this.getClass().getSimpleName() + ". Питомец голоден? Ответ: "
                + this.isHungry + ". Питомец спит? Ответ: " + this.state + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pet)) {
            return false;
        }
        Pet pet = (Pet) obj;
        return pet.name.equals(this.name) && pet.getClass() == this.getClass();
    }
}
