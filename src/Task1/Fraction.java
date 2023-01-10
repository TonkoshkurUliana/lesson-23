package Task1;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Fraction {

    private String name;
    private ArrayList<Deputy> fraction;

    Scanner sc = new Scanner(System.in);

    public Fraction(String name) {
        this.name = name;
        this.fraction = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Fraction setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<Deputy> getFraction() {

        return fraction;
    }

    public Fraction setFruction(ArrayList<Deputy> fruction) {
        this.fraction = fruction;
        return this;
    }


    Supplier<Deputy> infoOfDeputy = () -> {
        System.out.println("Введіть ім'я: ");
        String name = sc.next();
        System.out.println("Введіть прізвище: ");
        String surname = sc.next();
        Random r = new Random();
        int weight = r.nextInt(100 - 50);
        int hight = r.nextInt(190 - 150);
        int age = r.nextInt(55 - 22);
        System.out.print("Взятки брав: ");
        boolean bribeman = sc.nextBoolean();
        if (bribeman) {
            System.out.print("Скільки?: ");
            int growthInt = sc.nextInt();
            return new Deputy(weight, hight, surname, name, age, bribeman, growthInt);
        }
        return new Deputy(weight, hight, surname, name, age, bribeman, 0);
    };

    public void addDeputy() {
        Deputy deputyInfo = infoOfDeputy.get();
        fraction.add(deputyInfo);
    }

    public void removeDeputy() {
        System.out.print("Введіть ім'я депутата:");
        String name = sc.next();

        Predicate<Deputy> findName = deputy -> deputy.getName().equalsIgnoreCase(name);
        Optional<Deputy> deputyFound = fraction.stream().filter(findName).findFirst();

        if (deputyFound.isPresent()) {
            fraction.remove(deputyFound.get());
        }
    }

    public void allDeputyFraction() {
        fraction.forEach(d -> System.out.println(d));
    }

    public void deleteAllDeputy() {
        fraction.removeAll(fraction);
    }

    public Supplier<Deputy> getInfoOfDeputy() {
        return infoOfDeputy;
    }

    void showAllBribeTaker() {
        List<Deputy> bribeTakers = fraction.stream().filter(Deputy::getBribeMan).collect(Collectors.toList());
        bribeTakers.forEach(System.out::println);
    }

    void theBiggestBribeTaker() {
        Comparator<Deputy> deputyBiggestBribe = (deputy1, deputy2) ->
                (deputy1.getBribe() > deputy2.getBribe()) ? 1 : (deputy1.getBribe() == deputy2.getBribe()) ? 0 : 1;

        Optional<Deputy> theBiggestBribeTaker = fraction.stream().filter(Deputy::getBribeMan).max(deputyBiggestBribe);

        if (theBiggestBribeTaker.isPresent()) {
            System.out.println("The biggest bribe taker is " + theBiggestBribeTaker.get().toString());
        } else {
            System.out.println("Faction have not bribe takers");
        }
    }


}
