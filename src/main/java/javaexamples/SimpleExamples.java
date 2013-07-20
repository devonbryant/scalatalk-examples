package javaexamples;

import java.util.ArrayList;
import java.util.List;

public class SimpleExamples {
    
    public Person older(Person a, Person b) {
        if (a.getAge() >= b.getAge())
            return a;
        else
            return b;
    }
    
    public void eldersExample() {
        final Person jon = new Person("Jon", "Snow", 14);
        final Person arya = new Person("Arya", "Stark", 9);
        Person elder = older(jon, arya);
        
        System.out.println("elder = " + elder);
    }
    
    public void namesExample() {
        List<Person> characters = new ArrayList<Person>();
        characters.add(new Person("Robb", "Stark", 14));
        characters.add(new Person("Jon", "Snow", 14));
        characters.add(new Person("Arya", "Stark", 9));

        List<String> starks = new ArrayList<String>();
        for (Person character : characters) {
            if (character.getSurname().equals("Stark")) {
                starks.add(character.getFirst() + " " + character.getSurname());
            }
        }
        
        System.out.println("starks = " + starks);
    }

    public static void main(String[] args) {
        SimpleExamples examples = new SimpleExamples();
        examples.eldersExample();
        examples.namesExample();
    }

}
