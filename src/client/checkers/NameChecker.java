package client.checkers;

/**
 * Checker class needed to check 'name' fields.
 *
 */
public class NameChecker extends Checker {

    @Override
    public boolean check(String name, int numberOfRow) {
        if (name.isEmpty()) {
            System.out.println("Поле Name не может являться пустой строкой. Строка: " + numberOfRow);
            return false;
        } else if (name == null) {
            System.out.println("Поле Name не может быть равно null. Строка: " + numberOfRow);
            return false;
        } else {
            String regexForNumbers = "^\\d+$";
            String regexForNonLetters = "^[\\W_]+$";

            if ((name.matches(regexForNumbers)) | (name.matches(regexForNonLetters))) {
                System.out.println("Имя не может состоять из одних цифр/специальных символов. Строка: " + numberOfRow);
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * The method that validates the field.
     * @param name
     * @return isValidate
     */
    @Override
    public boolean check(String name) {
        if (name.isEmpty()) {
            System.out.println("Поле Name не может являться пустой строкой.");
            return false;
        } else if (name == null) {
            System.out.println("Поле Name не может быть равно null.");
            return false;
        } else {
            String regexForNumbers = "^\\d+$";
            String regexForNonLetters = "^[\\W_]+$";

            if ((name.matches(regexForNumbers)) | (name.matches(regexForNonLetters))) {
                System.out.println("Имя не может состоять из одних цифр/специальных символов.");
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public String toString() {
        return "Класс " + this.getClass() +
                " используется для проверки поля 'name' " +
                " в объекте типа 'Flat'/'House'.";
    }
}
