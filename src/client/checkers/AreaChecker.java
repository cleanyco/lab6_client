package client.checkers;

/**
 * Checker class needed to check 'area' fields.
 */
public class AreaChecker extends Checker {

    @Override
    public boolean check(String area, int numberOfRow) {
        try {
            Long parsedArea = Long.parseLong(area);
            if ((parsedArea < 0) | (parsedArea > 605)) {
                System.out.println("Поле 'area' не может быть меньше 0/больше 605. Строка: " + numberOfRow);
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Невозможно произвести парсинг поля 'area', типы несовместимы. Строка: " + numberOfRow);
            return false;
        }
    }

    /**
     * The method that validates the field.
     * @param area
     * @return isValidate
     */
    @Override
    public boolean check(String area) {
        try {
            Long parsedArea = Long.parseLong(area);
            if ((parsedArea < 0) | (parsedArea > 605)) {
                System.out.println("Поле 'area' не может быть меньше 0/больше 605.");
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Невозможно произвести парсинг поля 'area', типы несовместимы.");
            return false;
        }
    }
    @Override
    public String toString() {
        return "Класс " + this.getClass().getSimpleName() +
                " используется для проверки поля 'area'" +
                " в объекте типа 'Flat'.";
    }
}
