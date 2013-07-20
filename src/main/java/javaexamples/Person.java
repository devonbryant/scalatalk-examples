package javaexamples;

public class Person {
    private final String first;
    private final String surname;
    private final int age;

    public Person(String first, String surname, int age) {
        this.first = first;
        this.surname = surname;
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (first == null) {
            if (other.first != null)
                return false;
        } else if (!first.equals(other.first))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        return true;
    }

    public String toString() {
        return "Person [first=" + first + ", surname=" + surname + ", age="
                + age + "]";
    }
}
