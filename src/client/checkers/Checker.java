package client.checkers;

/**
 * Base class checker from which other checkers are inherited.
 */

public class Checker {

    public Checker() {
    }

    public boolean check(String variableToRecord) {
        System.out.println("Данный метод испольузется для переопределения в классах-потомках.");
        return false;
    }

    public boolean check(String variableToRecord, String variableToRecord2) {
        System.out.println("Данный метод испольузется для переопределения в классах-потомках.");
        return false;
    }

    public boolean check(String csvString, int numberOfRow) {
        System.out.println("Данный метод испольузется для переопределения в классах-потомках.");
        return false;
    }

    public boolean check(String csvString1, String csvString2, int numberOfRow) {
        System.out.println("Данный метод испольузется для переопределения в классах-потомках.");
        return false;
    }

    public boolean check(String csvString1, String csvString2, String csvString3, String csvString4,
                         String csvString5) {
        System.out.println("Данный метод испольузется для переопределения в классах-потомках.");
        return false;
    }

    public boolean check(String csvString1, String csvString2, String csvString3, String csvString4,
                         String csvString5, int numberOfRow) {
        System.out.println("Данный метод испольузется для переопределения в классах-потомках.");
        return false;
    }

    @Override
    public String toString() {
        return "Класс " + this.getClass().getSimpleName() +
                " используется для наследования от него " +
                " классов-чекеров.";
    }
}
