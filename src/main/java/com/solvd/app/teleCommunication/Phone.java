package com.solvd.app.teleCommunication;

import com.solvd.app.exceptions.MissPellingException;
import com.solvd.app.exceptions.PhoneDoesNotExistException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Phone {
    // Phone Class
    // Features: Consists of multiple things but for now number
    private String number;
    private TAppCategory.App activeApp;
    private HashMap<String,Integer> contacts;

    public Phone() {
        this.number = null;
        this.activeApp = TAppCategory.CLEAR.defaultApp();
        this.contacts = new HashMap<>();
    }

    public TAppCategory.App getActiveApp() {
        return activeApp;
    }

    public void setActiveApp(TAppCategory.App activeApp) {
        this.activeApp = activeApp;
    }

    public void addToContact(MDatabase mDatabase,String fullName) throws PhoneDoesNotExistException {
        this.activeApp = TAppCategory.MESSAGE.showSubOptions().get(1);
        if (mDatabase.search(fullName)) {
            contacts.put(fullName, Integer.valueOf(mDatabase.info().get(fullName)));
        } else {
            throw new PhoneDoesNotExistException("Indicated User is not registered in the database");
        }
    }

    public void calculate() throws MissPellingException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("U can choose any action: ");
        System.out.println("-Addition");
        System.out.println("-Multiplication");
        System.out.println("-Division");
        System.out.println("-Subtraction");
        System.out.println("-Percentage");
        String answer = scanner.nextLine();
        switch (answer.toLowerCase()) {
            case "addition":
                this.activeApp = TAppCategory.CALCULATOR.showSubOptions().get(0);
                String[] add = scanner.nextLine().split(",");
                Arrays.stream(add)
                        .mapToInt(Integer::parseInt)
                .reduce(Integer::sum)
                        .ifPresent((x) -> System.out.println("Answer is: " + x));
                break;

            case "multiplication":
                this.activeApp = TAppCategory.CALCULATOR.showSubOptions().get(3);
                String[] mul = scanner.nextLine().split(",");
                Arrays.stream(mul)
                        .mapToInt(Integer::parseInt)
                        .reduce((x,y) -> x * y)
                        .ifPresent((x) -> System.out.println("Answer is: " + x));
                break;

            case "division":
                this.activeApp = TAppCategory.CALCULATOR.showSubOptions().get(2);
                String[] div = scanner.nextLine().split(",");
                Arrays.stream(div)
                        .mapToInt(Integer::parseInt)
                        .reduce((x,y) -> x / y)
                        .ifPresent((x) -> System.out.println("Answer is: " + x));
                break;

            case "subtraction":
                this.activeApp = TAppCategory.CALCULATOR.showSubOptions().get(1);
                String[] sub = scanner.nextLine().split(",");
                Arrays.stream(sub)
                        .mapToInt(Integer::parseInt)
                        .reduce((x,y) -> x - y)
                        .ifPresent((x) -> System.out.println("Answer is: " + x));
                break;

            case "percentage":
                this.activeApp = TAppCategory.CALCULATOR.showSubOptions().get(4);
                System.out.println("Number: ");
                double number = scanner.nextDouble();
                System.out.println("Percentage: ");
                double percentage = scanner.nextDouble();
                System.out.println("Answer is: " + (number * percentage) / 100 );

            default:
                throw new MissPellingException("Indicated thing is not in options");
        }
    }

    public void calendar() throws MissPellingException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You can choose From Options: ");
        System.out.println("-Day");
        System.out.println("-Month");
        System.out.println("-Year");
        System.out.println("-Number");
        String answer = scanner.nextLine();
        LocalDate current;

        switch (answer.toLowerCase()) {
            case "day":
                this.activeApp = TAppCategory.CALENDAR.showSubOptions().get(0);
                current = LocalDate.now();
                System.out.println("Day: " + current.getDayOfWeek());
                break;

            case "month":
                this.activeApp = TAppCategory.CALENDAR.showSubOptions().get(1);
                current = LocalDate.now();
                System.out.println("Month: " + current.getMonth());
                break;

            case "year":
                this.activeApp = TAppCategory.CALENDAR.showSubOptions().get(2);
                current = LocalDate.now();
                System.out.println("Year: " + current.getYear());
                break;

            case "number":
                this.activeApp = TAppCategory.CALENDAR.showSubOptions().get(3);
                current = LocalDate.now();
                System.out.println("Number: " + current.getDayOfMonth());
                break;

            default:
                throw new MissPellingException("Indicated thing is not in options");
        }
    }

    public HashMap<String, Integer> getContacts() {
        return contacts;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String newNumber) {
        this.number = newNumber;
    }
}
