package pl.accenture;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {//vararg zamiast [] dac 3 raz ...
       //Strumienie
        /*Stream<String> myStringStream= Stream.of("ala","ma","kota");
        myStringStream.forEach(s-> System.out.println(s));
*/
        /*Stream.<String>builder()//trzeba okreslic typ(Stringi)
                .add("ala")
                .add("ma")
                .add("kota")
                .build()
                .filter((s)->s.equals("ala"))
                .forEach(s-> System.out.println(s));
*/
        Predicate<Person>nameStartsWithAPredicate=p->p.name.startsWith ("a");
        Predicate<Person>nameStartsWithoutOPredicate=p->p.name.contains("o".toUpperCase());
        Predicate<Person>ageBelow20Predicate=p->p.age<20;
        List<Person> people = Arrays.asList(
                new Person("alicja",12),
                new Person("Alicja",12),
                new Person("bartek",112),
                new Person("Bartek",11),
                new Person("adam",15)
        );

        //konwertowanie kolekcji do strumieni
        people.stream()
                .filter(nameStartsWithAPredicate.and(ageBelow20Predicate))
                .collect(Collectors.toList())
                .forEach (s-> System.out.println(s));//(System.out::println); zamiennik
        people.stream()
                .filter(nameStartsWithoutOPredicate.and(ageBelow20Predicate))
                .collect(Collectors.toList())
                .forEach (s-> System.out.println(s));//(System.out::println); zamiennik




    }



}
class Person{
    String name;
    int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }
}
