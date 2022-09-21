package client.checkers;

/**
 * Checker class needed to check 'numberOfBathrooms' fields.
 */
public class NumberOfBathroomsChecker extends Checker {

    @Override
    public boolean check(String numberOfBathrooms, int numberOfRow) {
        try {
            long parsedNumberOfBathrooms = Long.parseLong(numberOfBathrooms);
            if (parsedNumberOfBathrooms < 0) {
                System.out.println("Поле 'numberOfBathrooms' не может быть меньше нуля. Строка: " + numberOfRow);
                return false;
            } else return true;
        } catch (IllegalArgumentException ex) {
            System.out.println("Невозможно произвести парсинг поля 'numberOfBathrooms', типы несовместимы. Строка: " + numberOfRow);
            return false;
        }
    }

    /**
     * The method that validates the field.
     * @param numberOfBathrooms
     * @return isValidate
     */
    @Override
    public boolean check(String numberOfBathrooms) {
        try {
            long parsedNumberOfBathrooms = Long.parseLong(numberOfBathrooms);
            if (parsedNumberOfBathrooms < 0) {
                System.out.println("Поле 'numberOfBathrooms' не может быть меньше нуля.");
                return false;
            } else return true;
        } catch (IllegalArgumentException ex) {
            System.out.println("Невозможно произвести парсинг поля 'numberOfBathrooms', типы несовместимы.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Класс " + this.getClass().getSimpleName() +
                " используется для проверки поля 'numberOfBathrooms'" +
                " в объекте типа 'Flat'.";
    }
}
