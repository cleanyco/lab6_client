package client.checkers;

/**
 * Checker class needed to check 'floor' fields.
 */
public class FloorChecker extends Checker {

    @Override
    public boolean check(String floor, int numberOfRow) {
        try {
            Long parsedFloor = Long.parseLong(floor);
            if (parsedFloor < 0) {
                System.out.println("Поле 'floor' не может быть меньше нуля. Строка: " + numberOfRow);
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Невозможно произвести парсинг поля 'floor', типы несовместимы. Строка: " + numberOfRow);
            return false;
        }
    }

    /**
     * The method that validates the field.
     * @param floor
     * @return isValidate
     */
    @Override
    public boolean check(String floor) {
        try {
            Long parsedFloor = Long.parseLong(floor);
            if (parsedFloor < 0) {
                System.out.println("Поле 'floor' не может быть меньше нуля.");
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Невозможно произвести парсинг поля 'floor', типы несовместимы.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Класс " + this.getClass().getSimpleName() +
                " используется для проверки поля 'floor'" +
                " в объекте типа 'Flat'.";
    }
}
