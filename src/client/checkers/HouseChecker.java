package client.checkers;

/**
 * Checker class needed to check 'House' fields.
 */
public class HouseChecker extends Checker {
    NameChecker nameChecker = new NameChecker();

    @Override
    public boolean check(String name, String year, String numberOfFloors, String numberOfFlatsOnFloor,
                         String numberOfLifts, int numberOfRow) {
        try {
            Long parsedYear = Long.parseLong(year);
            Long parsedNumberOfFloors = Long.parseLong(numberOfFloors);
            long parsedNumberOfFlatsOnFloor = Long.parseLong(numberOfFlatsOnFloor);
            long parsedNumberOfLifts = Long.parseLong(numberOfLifts);

            if (!(nameChecker.check(name, numberOfRow)) |
                    (parsedYear < 0) |
                    (parsedYear == null) |
                    (parsedNumberOfFloors == null) |
                    (parsedNumberOfFloors < 0) |
                    (parsedNumberOfFloors > 76) |
                    (parsedNumberOfFlatsOnFloor < 0) |
                    (parsedNumberOfLifts < 0)) {
                System.out.println("Неверны заданы поля для объекта типа 'House'. Строка: " + numberOfRow);
                return false;
            } else return true;
        } catch (IllegalArgumentException ex) {
            System.out.println("Невозможно произвести парсинг полей для объекта типа 'House'. Строка: " + numberOfRow);
            return false;
        }
    }

    /**
     * The method that validates the field.
     * @param name
     * @param year
     * @param numberOfFloors
     * @param numberOfFlatsOnFloor
     * @param numberOfLifts
     * @return isValidate
     */
    @Override
    public boolean check(String name, String year, String numberOfFloors, String numberOfFlatsOnFloor,
                         String numberOfLifts) {
        try {
            Long parsedYear = Long.parseLong(year);
            Long parsedNumberOfFloors = Long.parseLong(numberOfFloors);
            long parsedNumberOfFlatsOnFloor = Long.parseLong(numberOfFlatsOnFloor);
            long parsedNumberOfLifts = Long.parseLong(numberOfLifts);

            if (!(nameChecker.check(name)) |
                    (parsedYear < 0) |
                    (parsedYear == null) |
                    (parsedNumberOfFloors == null) |
                    (parsedNumberOfFloors < 0) |
                    (parsedNumberOfFloors > 76) |
                    (parsedNumberOfFlatsOnFloor < 0) |
                    (parsedNumberOfLifts < 0)) {
                System.out.println("Неверны заданы поля для объекта типа 'House'." );
                return false;
            } else return true;
        } catch (IllegalArgumentException ex) {
            System.out.println("Невозможно произвести парсинг полей для объекта типа 'House'." );
            return false;
        }
    }

    @Override
    public String toString() {
        return "Класс " + this.getClass().getSimpleName() +
                " используется для проверки полей" +
                " объекта типа 'House', который содержится" +
                " в объекте типа 'Flat'.";
    }
}
