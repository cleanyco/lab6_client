package client.checkers;

import data.Transport;

/**
 * Checker class needed to check 'transport' fields.
 */
public class TransportChecker extends Checker {

    @Override
    public boolean check(String transport, int numberOfRow) {
        try {
            Transport parsedTransport = Transport.valueOf(transport);
            if (parsedTransport == null) {
                System.out.println("Поле Transport не может быть равно null. Строка: " + numberOfRow);
                return false;
            }
            return true;
        } catch (IllegalArgumentException ex) {
            System.out.println("Указан несуществующий Enum. Строка: " + numberOfRow);
            return false;
        }
    }

    /**
     * The method that validates the field.
     * @param transport
     * @return isValidate
     */
    @Override
    public boolean check(String transport) {
        try {
            Transport parsedTransport = Transport.valueOf(transport);
            if (parsedTransport == null) {
                System.out.println("Поле Transport не может быть равно null.");
                return false;
            }
            return true;
        } catch (IllegalArgumentException ex) {
            System.out.println("Указан несуществующий Enum.");
            return false;
        }
    }


    @Override
    public String toString() {
        return "Класс " + this.getClass().getSimpleName() +
                " используется для проверки поля 'transport'" +
                " в объекте типа 'Flat'.";
    }
}
