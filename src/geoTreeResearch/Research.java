package geoTreeResearch;

import java.util.ArrayList;

public class Research{
    private ArrayList<Node> tree;
    private ArrayList<String> result;

    public Research(GeoTree geoTree) {
        this.tree = geoTree.getTree();
        this.result = new ArrayList<>();
    }

    public ArrayList<String> spendRelationships(Person p, Relationship re) {
        for (Node t : this.tree) {
            if (t.getPersonFirst().getName() == p.getName() && t.getRelationship() == re) {
                this.result.add(t.getPersonSecond().getName());
            }
        }
        return this.result;
    }

    public ArrayList<String> spendGender(Person.Gender gender){
        for (Node t : this.tree){
            if(t.getPersonFirst().getGender() == gender && !this.result.contains(t.getPersonFirst().getName())){
                this.result.add(t.getPersonFirst().getName());
            }
        }
        return this.result;
    }

    @Override
    public String toString() {
        return String.format(String.valueOf(this.result));
    }

//    public void print(){
//        for(String i : this.result){
//            System.out.println(i);
//        }
//    } // Не работает раз: строка 67 Main - вопрос

//    public String print() {
//        return String.format(String.valueOf(this.result));
//    } // Не работает два: строка 67 Main - вопрос
}
