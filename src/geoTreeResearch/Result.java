package geoTreeResearch;

import humanAndPet.Interface.Printable;

import java.util.ArrayList;

public class Result implements Printable {
    private ArrayList<String> result;

    public Result(GeoTree tree, Person p, Relationship re){
        System.out.printf("%s - это %s для: \n", p.getName(), re);
        this.result = new Research(tree).spendRelationships(p, re);
    }

    public Result (GeoTree tree, Person.Gender gender) {
        System.out.printf("Выводим всех %s: \n", gender);
        this.result = new Research(tree).spendGender(gender);
    }

    @Override
    public void print() {
        System.out.println(this.result);
    }
}
