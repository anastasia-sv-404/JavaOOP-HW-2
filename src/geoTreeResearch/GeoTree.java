package geoTreeResearch;

import humanAndPet.Interface.Printable;

import java.util.ArrayList;

public class GeoTree implements Printable {
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return this.tree;
    }

//    public void append(Person p1, Relationship re1, Person p2, Relationship re2) {
//        if(p1.getFamily().contains(p2) && p2.getFamily().contains(p1)) {
//            tree.add(new Node(p1, re1, p2));
//            tree.add(new Node(p2, re2, p1));
//        } else{
//            System.out.printf("Нельзя установить отношения: персоны %s и %s принадлежат разным семьям.\n", p1.getName(), p2.getName());
//        }
//    }

        public void append(Family f1, Relationship re1, Family f2, Relationship re2) {
        if(f1.getFamily().contains(f2.getPerson()) && f2.getFamily().contains(f1.getPerson())) {
            tree.add(new Node(f1.getPerson(), re1, f2.getPerson()));
            tree.add(new Node(f2.getPerson(), re2, f1.getPerson()));
        } else{
            System.out.printf("Нельзя установить отношения: персоны %s и %s принадлежат разным семьям.\n",
                    f1.getPerson().getName(), f2.getPerson().getName());
        }
    }//С учетом ввода нового класса Семья - изменена логика метода. Для формирования отношений передаем не Персон,
    // а Семьи, принадлежащие Персонам, между которыми хотим установить отношения.


    public void print(){
        for (Node node: this.getTree()){
            node.print();
        }
        System.out.println();
    }
}
