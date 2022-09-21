package client.util;

import client.checkers.*;
import client.util.exceptions.IncorrectInputInScriptException;
import client.util.exceptions.WrongAnswerException;
import data.Coordinates;
import data.Flat;
import data.House;
import data.Transport;

import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FlatRecorder {
    ArrayList<Checker> checkerList = new ArrayList<>();
    private Scanner userScanner;
    private boolean fileMode;

    public FlatRecorder(Scanner userScanner) {
        this.userScanner = userScanner;
        this.fileMode = false;
    }

    /**
     * Method used to get userScanner
     * @return userScanner
     */
    public Scanner getUserScanner() {
        return userScanner;
    }

    /**
     * Method used to set userScanner
     *
     */
    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    {
        checkerList.add(new NameChecker());
        checkerList.add(new CoordinatesChecker());
        checkerList.add(new AreaChecker());
        checkerList.add(new NumberOfRoomsChecker());
        checkerList.add(new FloorChecker());
        checkerList.add(new NumberOfBathroomsChecker());
        checkerList.add(new TransportChecker());
        checkerList.add(new HouseChecker());
    }

    /**
     * Method used to set fileMode
     */
    public void setFileMode() {
        fileMode = true;
    }

    /**
     * Method used to set userMode
     */
    public void setUserMode() {
        fileMode = false;
    }

    /**
     * Method used to record 'name'
     * @return name
     */
    public String recordName() {
        String name;
        while (true) {
            try {
                if (!fileMode) {
                    System.out.println("Введите поле 'name'.");
                }
                name = userScanner.nextLine().trim();
                if (checkerList.get(0).check(name)) {
                    break;
                } else {
                    if (!fileMode) {
                        System.out.println("Попробуйте еще раз.");
                    } else {
                        System.out.println("В скрипте неверно указано поле 'name'. Завершаем работу...");
                        System.exit(0);
                    }
                }
            } catch (NoSuchElementException ex) {
                System.out.println("Некорректный ввод имени. | Была введена комбинация CTRL+D.");
                System.out.println("Завершение работы программы.");
                System.exit(-1);
            } catch (IllegalArgumentException ex) {
                System.out.println("Непредвиденная ошибка. Завершение работы программы.");
                System.exit(-1);
            }
        }
        return name;
    }

    /**
     * Method used to record 'Coordinates'
     * @return Coordinates
     */
    public Coordinates recordCoordinates() {
        String coordinateX;
        String coordinateY;
        Coordinates coordinates = new Coordinates();
        while (true) {
            try {
                if (!fileMode) {
                    System.out.println("Введите координату 'X', затем координату 'Y'.");
                }
                coordinateX = userScanner.nextLine().trim();
                coordinateY = userScanner.nextLine().trim();
                if (checkerList.get(1).check(coordinateX, coordinateY)) {
                    coordinates.setX((Double.parseDouble(coordinateX)));
                    coordinates.setX((Double.parseDouble(coordinateY)));
                    break;
                } else {
                    if (!fileMode) {
                        System.out.println("Попробуйте еще раз.");
                    } else {
                        System.out.println("В скрипте неверно указано поля 'coordinates'. Завершаем работу...");
                        System.exit(0);
                    }
                }
            } catch (NoSuchElementException ex) {
                System.out.println("Некорректный ввод. | Была введена комбинация CTRL+D.");
                System.out.println("Завершение работы программы.");
                System.exit(-1);
            } catch (IllegalArgumentException ex) {
                System.out.println("Непредвиденная ошибка. Завершение работы программы.");
                System.exit(-1);
            }
        }
        return coordinates;
    }

    /**
     * Method used to record 'area'
     * @return area
     */
    public Long recordArea() {
        String area;
        while (true) {
            try {
                if (!fileMode) {
                    System.out.println("Введите поле 'area'.");
                }
                area = userScanner.nextLine().trim();
                if (checkerList.get(2).check(area)) {
                    break;
                } else {
                    if (!fileMode) {
                        System.out.println("Попробуйте еще раз.");
                    } else {
                        System.out.println("В скрипте неверно указано поле 'area'. Завершаем работу...");
                        System.exit(0);
                    }
                }
            } catch (NoSuchElementException ex) {
                System.out.println("Некорректный ввод. | Была введена комбинация CTRL+D.");
                System.out.println("Завершение работы программы.");
                System.exit(-1);
            } catch (IllegalArgumentException ex) {
                System.out.println("Непредвиденная ошибка. Завершение работы программы.");
                System.exit(-1);
            }
        }
        return Long.parseLong(area);
    }

    /**
     * Method used to record 'numberOfRooms'
     * @return numberOfRooms
     */
    public Integer recordNumberOfRooms() {
        String numberOfRooms = null;
        while (true) {
            try {
                if (!fileMode) {
                    System.out.println("Введите поле 'numberOfRooms'.");
                }
                numberOfRooms = userScanner.nextLine().trim();
                if (checkerList.get(3).check(numberOfRooms)) {
                    break;
                } else {
                    if (!fileMode) {
                        System.out.println("Попробуйте еще раз.");
                    } else {
                        System.out.println("В скрипте неверно указано поле 'numberOfRooms'. Завершаем работу...");
                        System.exit(0);
                    }
                }
            } catch (NoSuchElementException ex) {
                System.out.println("Некорректный ввод. | Была введена комбинация CTRL+D.");
                System.out.println("Завершение работы программы.");
                System.exit(-1);
            } catch (IllegalArgumentException ex) {
                System.out.println("Непредвиденная ошибка. Завершение работы программы.");
                System.exit(-1);
            }
        }
        return Integer.parseInt(numberOfRooms);
    }

    /**
     * Method used to record 'floor'
     * @return floor
     */
    public Long recordFloor() {
        String floor;
        while (true) {
            try {
                if (!fileMode) {
                    System.out.println("Введите поле 'floor'.");
                }
                floor = userScanner.nextLine().trim();
                if (checkerList.get(4).check(floor)) {
                    break;
                } else {
                    if (!fileMode) {
                        System.out.println("Попробуйте еще раз.");
                    } else {
                        System.out.println("В скрипте неверно указано поле 'floor'. Завершаем работу...");
                        System.exit(0);
                    }
                }
            } catch (NoSuchElementException ex) {
                System.out.println("Некорректный ввод. | Была введена комбинация CTRL+D.");
                System.out.println("Завершение работы программы.");
                System.exit(-1);
            } catch (IllegalArgumentException ex) {
                System.out.println("Непредвиденная ошибка. Завершение работы программы.");
                System.exit(-1);
            }
        }
        return Long.parseLong(floor);
    }

    /**
     * Method used to record 'numberOfBathrooms'
     * @return numberOfBathrooms
     */
    public long recordNumberOfBathrooms() {
        String numberOfBathrooms;
        while (true) {
            try {
                if (!fileMode) {
                    System.out.println("Введите поле 'numberOfBathrooms'.");
                }
                numberOfBathrooms = userScanner.nextLine().trim();
                if (checkerList.get(5).check(numberOfBathrooms)) {
                    break;
                } else {
                    if (!fileMode) {
                        System.out.println("Попробуйте еще раз.");
                    } else {
                        System.out.println("В скрипте неверно указано поле 'numberOfBathrooms'. Завершаем работу...");
                        System.exit(0);
                    }
                }
            } catch (NoSuchElementException ex) {
                System.out.println("Некорректный ввод. | Была введена комбинация CTRL+D.");
                System.out.println("Завершение работы программы.");
                System.exit(-1);
            } catch (IllegalArgumentException ex) {
                System.out.println("Непредвиденная ошибка. Завершение работы программы.");
                System.exit(-1);
            }
        }
        return Long.parseLong(numberOfBathrooms);
    }

    /**
     * Method used to record 'Transport'
     * @return Transport
     */
    public Transport recordTransport() {
        String transport;
        Transport transportToRecord;
        while (true) {
            try {
                if (!fileMode) {
                    System.out.println("Введите поле 'transport'.");
                    System.out.println("Доступные варианты: " +
                            "FEW, NONE, NORMAL, ENOUGH.");
                }
                transport = userScanner.nextLine().trim();
                if (checkerList.get(6).check(transport)) {
                    transportToRecord = Transport.valueOf(transport);
                    break;
                } else {
                    if (!fileMode) {
                        System.out.println("Попробуйте еще раз.");
                    } else {
                        System.out.println("В скрипте неверно указано поле 'Transport'. Завершаем работу...");
                        System.exit(0);
                    }
                }
            } catch (NoSuchElementException ex) {
                System.out.println("Некорректный ввод. | Была введена комбинация CTRL+D.");
                System.out.println("Завершение работы программы.");
                System.exit(-1);
            } catch (IllegalArgumentException ex) {
                System.out.println("Непредвиденная ошибка. Завершение работы программы.");
                System.exit(-1);
            }
        }
        return transportToRecord;
    }

    /**
     * Method used to record 'House'
     * @return House
     */
    public House recordHouse() {
        String houseName;
        String houseYear;
        String houseNumberOfFloors;
        String houseNumberOfFlatsOnFloor;
        String houseNumberOfLifts;
        House house = new House();
        while (true) {
            try {
                if (!fileMode) {
                    System.out.println("Введите поля для объекта типа 'House' в следующем порядке:" +
                            " houseName," +
                            " houseYear," +
                            " houseNumberOfFloors," +
                            " houseNumberOfFlatsOnFloor," +
                            " houseNumberOfLifts.");
                }
                houseName = userScanner.nextLine().trim();
                houseYear = userScanner.nextLine().trim();
                houseNumberOfFloors = userScanner.nextLine().trim();
                houseNumberOfFlatsOnFloor = userScanner.nextLine().trim();
                houseNumberOfLifts = userScanner.nextLine().trim();
                if (checkerList.get(7).check(
                        houseName,
                        houseYear,
                        houseNumberOfFloors,
                        houseNumberOfFlatsOnFloor,
                        houseNumberOfLifts)
                ) {
                    house.setName(houseName);
                    house.setYear(Long.parseLong(houseYear));
                    house.setNumberOfFloors(Long.parseLong(houseNumberOfFloors));
                    house.setNumberOfFlatsOnFloor(Long.parseLong(houseNumberOfFlatsOnFloor));
                    house.setNumberOfLifts(Long.parseLong(houseNumberOfLifts));
                    break;
                } else {
                    if (!fileMode) {
                        System.out.println("Попробуйте еще раз.");
                    } else {
                        System.out.println("В скрипте неверно указано поля 'house'. Завершаем работу...");
                        System.exit(0);
                    }
                }
            } catch (NoSuchElementException ex) {
                System.out.println("Некорректный ввод. | Была введена комбинация CTRL+D.");
                System.out.println("Завершение работы программы.");
                System.exit(-1);
            } catch (IllegalArgumentException ex) {
                System.out.println("Непредвиденная ошибка. Завершение работы программы.");
                System.exit(-1);
            }
        }
        return house;
    }

    public Flat recordFlat() {
        return new Flat(
                recordName(),
                recordCoordinates(),
                LocalDateTime.now(),
                recordArea(),
                recordNumberOfRooms(),
                recordFloor(),
                recordNumberOfBathrooms(),
                recordTransport(),
                recordHouse());
    }
    /**
     * Method used to ask questions in update command
     * @return answer (true/false)
     */
    public boolean askQuestion(String question) throws IncorrectInputInScriptException{
        String finalQuestion = question + " (+/-):";
        String answer;
        while (true) {
            try {
                System.out.println(finalQuestion);
                answer = userScanner.nextLine().trim();
                if (!answer.equals("+") && !answer.equals("-")) throw new WrongAnswerException();
                break;
            } catch (NoSuchElementException exception) {
                System.out.println("Некорректный ввод. | Была введена комбинация CTRL+D.");
                System.out.println("Завершение работы программы.");
                if (fileMode) throw new IncorrectInputInScriptException();
                System.exit(-1);
            } catch (WrongAnswerException exception) {
                System.out.println("Ответ должен быть представлен знаками '+' или '-'.");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                System.out.println("Непредвиденная ошибка.");
                System.exit(0);
            }
        }
        return (answer.equals("+")) ? true : false;
    }
}
