package client.checkers;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateChecker extends Checker{
    final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * The method that validates the field.
     * @param localDateTime, numberOfRow
     * @return isValidate
     */
    @Override
    public boolean check(String localDateTime, int numberOfRow) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            LocalDateTime parsedLocalDateTime = LocalDateTime.parse(localDateTime, dateTimeFormatter);
            return true;
        } catch (DateTimeParseException ex) {
            System.out.println("Невозможно произвести парсинг поля 'localDateTime', типы несовместимы." +
                    " Строка:" + numberOfRow);
            return false;
        }
    }

    /**
     * The method that validates the field.
     * @param localDateTime
     * @return isValidate
     */
    @Override
    public boolean check(String localDateTime) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            LocalDateTime parsedLocalDateTime = LocalDateTime.parse(localDateTime, dateTimeFormatter);
            return true;
        } catch (DateTimeParseException ex) {
            System.out.println("Невозможно произвести парсинг поля 'localDateTime', типы несовместимы.");
            return false;
        }
    }
}
