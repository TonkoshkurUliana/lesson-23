package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class VerhovnaRada extends Exception {
    List<Fraction> goverment = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    Supplier<Fraction> getFraction = () -> {
        System.out.println("Введіть ім'я фракції: ");
        String fractionName = sc.next();
        return new Fraction(fractionName);
    };

    public void addFraction() {
        goverment.add(getFraction.get());
    }

    public void removeFraction() throws Exception {
        Optional<Fraction> findFaction = findFaction();
        if (findFaction.isPresent()) {
            goverment.remove(findFaction.get());
        } else {
            System.out.println("Faction is not found!");
        }
    }

    public void allFraction() {
        goverment.forEach(g -> System.out.println(g.getName()));
    }

    public void thisFraction() throws Exception {
        Optional<Fraction> findFaction = findFaction();
        if (findFaction.isPresent()) {
            findFaction.get().allDeputyFraction();
        } else {
            throw new Exception("The fuction isn't true");
        }
    }

    public void addDeputyToFraction() throws Exception {
        Optional<Fraction> findFaction = findFaction();
        if (findFaction.isPresent()) {
            findFaction.get().addDeputy();
        } else {
            throw new Exception("The fuction isn't true");
        }
    }

    public void removeDeputyFromFraction() throws Exception {
        Optional<Fraction> findFaction = findFaction();
        if (findFaction.isPresent()) {
            findFaction.get().removeDeputy();
        } else {
            System.out.println("Faction is not found!");
        }
    }

    public void biggestBribeDeputy() {
        Optional<Fraction> factionFound = findFaction();
        if (factionFound.isPresent()) {
            factionFound.get().theBiggestBribeTaker();
        } else {
            System.out.println("Faction is not found!");
        }
    }

    public void allBribeDeputy() {
        Optional<Fraction> factionFound = findFaction();
        if (factionFound.isPresent()) {
            factionFound.get().showAllBribeTaker();
        } else {
            System.out.println("Faction is not found!");
        }
    }

    public void cleanFraction() throws Exception {
        Optional<Fraction> findFaction = findFaction();
        if (findFaction.isPresent()) {
            findFaction.get().deleteAllDeputy();
        } else {
            throw new Exception("The fuction isn't true");
        }
    }
    Optional<Fraction> findFaction() {
        Fraction factionInfo = getFraction.get();
        Predicate<Fraction> isEqualFactionName = faction1 -> faction1.getName().equalsIgnoreCase(factionInfo.getName());
        Optional<Fraction> factionFound = goverment.stream().filter(isEqualFactionName).findFirst();
        return factionFound;
    }
}