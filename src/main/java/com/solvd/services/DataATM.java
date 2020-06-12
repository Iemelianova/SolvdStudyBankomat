package com.solvd.services;

import com.solvd.pojo.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DataATM {

    private final static Logger LOGGER = LogManager.getLogger(DataATM.class);
    private Scanner sc = new Scanner(System.in);
    ServicesATM servicesATM = new ServicesATM();
    Validation validation = new Validation();


    public void getInputData() {

        LOGGER.info("Login to the program");

        System.out.println("================================================================");
        System.out.print("Enter user: ");
        servicesATM.login = sc.next();

        validation.loginValidate(servicesATM);

        System.out.print("Enter path: ");
        servicesATM.path = sc.next();
        Transaction transaction = servicesATM.workwithJson.JsonReader(servicesATM.path + ".json");

        chooseAction();

    }


    public void chooseAction() {
        System.out.println("================================================================");
        System.out.println("Display balance: D");
        System.out.println("Withdraw funds:  W");

        String choosing = sc.next();
        choosing = choosing.toUpperCase();
        switch (choosing) {
            case ("D"):
                servicesATM.displayBalance();
                break;
            case ("W"):
                servicesATM.withdrawFunds();
                break;
            default:
                chooseAction();
                break;
        }
    }


    public void reproduceSubmenu() {
        System.out.println("================================================================");
        System.out.println("To display balance:               D");
        System.out.println("To change the source data, enter: С");
        System.out.println("Exit<-----------------------------E");

        String action = sc.next();
        action = action.toUpperCase();
        switch (action) {
            case ("D"):
                servicesATM.displayBalance();
                break;
            case ("C"):
                getInputData();
                break;
            case ("E"):
                sc.close();
                exit();
            default:
                reproduceSubmenu();
                break;
        }


    }

    public void exit() {
        System.out.println("================================================================");
        System.out.println("Thank you for using application");
        LOGGER.info("Work completed!!!");
        System.out.println("================================================================");
        System.exit(0);
    }


}
