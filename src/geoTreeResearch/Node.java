package geoTreeResearch;

import geoTreeResearch.Interface.Printable;

import java.util.SortedMap;

public class Node implements Printable {
    private Person personFirst;
    private Person personSecond;
    private Relationship relationship;

    public Node(Person personFirst, Relationship relationship, Person personSecond) {
        this.personFirst = personFirst;
        this.personSecond = personSecond;
        this.relationship = relationship;
    }

    public Person getPersonFirst() {
        return personFirst;
    }

    public Person getPersonSecond() {
        return personSecond;
    }

    public Relationship getRelationship() {
        return relationship;
    }

//    @Override
//    public String toString() {
//        return String.format("%s - это %s для %s", personFirst.getName(), this.relationship, personSecond.getName());
//    }

    public void print(){
        System.out.printf("%s - это %s для %s.\n", personFirst.getName(), this.relationship, personSecond.getName());
    }

}
