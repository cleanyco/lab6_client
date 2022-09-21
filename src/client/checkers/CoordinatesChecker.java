package client.checkers;

/**
 * Checker class needed to check 'Coordinates' fields.
 */
public class CoordinatesChecker extends Checker {
    @Override
    public boolean check(String coordX, String coordY, int numberOfRow) {
        try {
            Double parsedCoordX = Double.parseDouble(coordX);
            float parsedCoordY = Float.parseFloat(coordY);

            if (parsedCoordX > 927) {
                System.out.println("Координата X не может быть больше 927. Строка: " + numberOfRow);
                return false;
            } else if (parsedCoordX == null) {
                System.out.println("Координата 'X' не может быть равна null. Строка: " + numberOfRow);
                return false;
            } else if (parsedCoordY > 24) {
                System.out.println("Координата 'Y' не может быть больше 24. Строка: " + numberOfRow);
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Невозможно произвести парсинг поля 'X'/'Y', типы несовместимы. Строка: " + numberOfRow);
            return false;
        }
    }

    /**
     * The method that validates the field.
     * @param coordX, coordY
     * @return isValidate
     */
    @Override
    public boolean check(String coordX, String coordY) {
        try {
            Double parsedCoordX = Double.parseDouble(coordX);
            float parsedCoordY = Float.parseFloat(coordY);

            if (parsedCoordX > 927) {
                System.out.println("Координата X не может быть больше 927.");
                return false;
            } else if (parsedCoordX == null) {
                System.out.println("Координата 'X' не может быть равна null.");
                return false;
            } else if (parsedCoordY > 24) {
                System.out.println("Координата 'Y' не может быть больше 24.");
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Невозможно произвести парсинг поля 'X'/'Y', типы несовместимы.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Класс " + this.getClass().getSimpleName() +
                " используется для проверки полей в объекте типа" +
                " 'Coordinates', который содержится" +
                " в объекте типа 'Flat'.";
    }


}
