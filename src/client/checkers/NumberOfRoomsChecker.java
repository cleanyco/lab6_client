package client.checkers;

/**
 * Checker class needed to check 'numberOfRooms' fields.
 */
public class NumberOfRoomsChecker extends Checker {

    @Override
    public boolean check(String numberOfRooms, int numberOfRow) {
        try {
            Integer parsedNumberOfRooms = Integer.parseInt(numberOfRooms);
            if (parsedNumberOfRooms < 0) {
                System.out.println("Поле 'numberOfRooms' не может быть меньше нуля. Строка: " + numberOfRow);
                return false;
            }
            return true;
        } catch (IllegalArgumentException ex) {
            System.out.println("Невозможно произвести парсинг поля 'numberOfRooms', типы несовместимы. Строка: " + numberOfRow);
            return false;
        }
    }

    /**
     * The method that validates the field.
     * @param numberOfRooms
     * @return isValidate
     */
    @Override
    public boolean check(String numberOfRooms) {
        try {
            Integer parsedNumberOfRooms = Integer.parseInt(numberOfRooms);
            if (parsedNumberOfRooms < 0) {
                System.out.println("Поле 'numberOfRooms' не может быть меньше нуля.");
                return false;
            }
            return true;
        } catch (IllegalArgumentException ex) {
            System.out.println("Невозможно произвести парсинг поля 'numberOfRooms', типы несовместимы.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Класс " + this.getClass().getSimpleName() +
                " используется для проверки поля 'numberOfRooms'" +
                " в объекте типа 'Flat'.";
    }
}
