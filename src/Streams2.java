import java.util.*;
import java.util.stream.Stream;

public class Streams2 {
    public static void main(String[] args) {

        int maxAge = 90;
        int minAge = 18;
        String[] names = new String[] {"Андрей", "Николай", "Владимир", "Константин", "Максим",
                "Александр", "Брайн", "Вильям", "Джеймс", "Джон", "Дональд", "Итан", "Кеннет",
                "Кристофер", "Майкл", "Марк", "Пол", "Стивен", "Том", "Эдвард"};

        /**
         *  Generating a list of persons with random age
         */
        ArrayList<Person> personList = new ArrayList<>();
        Stream.iterate(0, n -> n + 1).limit(100)
                .map(n -> names[(int) (Math.random() * names.length)])
                .forEach(str -> personList.add(new Person(str, (int) (Math.random() * (maxAge - minAge + 1) + minAge))));

        personList.forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));

        // Choosing a name of target person randomly
        String targetName = names[(int) (Math.random() * names.length)];

        /**
         * First attempt
         */
        long personCount = personList.stream()
                .filter(person -> person.getName().equals(targetName))
                .count();
        int ageSum = personList.stream()
                .filter(person -> person.getName().equals(targetName))
                .mapToInt(Person::getAge).sum();
        double midAge = ((double) ageSum) / personCount;

        printResult(targetName, midAge);

        /**
         * Second attempt after "Practical Exercises" reading
         */
        midAge = personList.stream()
                .filter(person -> person.getName().equals(targetName))
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        printResult(targetName, midAge);

    }

    public static void printResult(String name, double age) {
        System.out.printf("\nСредний возраст персон с именем \"%s\" составляет %.2f года(лет)."
                , name, age);
    }
}
