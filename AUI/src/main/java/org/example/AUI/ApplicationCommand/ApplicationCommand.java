package org.example.AUI.ApplicationCommand;

import jakarta.transaction.SystemException;
import org.example.AUI.entity.Car;
import org.example.AUI.entity.Mechanic;
import org.example.AUI.service.CarDefaultService;
import org.example.AUI.service.MechanicDefaultService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final CarDefaultService carDefaultService;
    private final MechanicDefaultService mechanicDefaultService;

    public ApplicationCommand(
            CarDefaultService carDefaultService,
            MechanicDefaultService mechanicDefaultService
    ){
        this.carDefaultService = carDefaultService;
        this.mechanicDefaultService = mechanicDefaultService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true){
            System.out.println("Type:" +
                    "\n" + "get_mechanics to see all mechanics" +
                    "\n" + "get_cars to see all cars" +
                    "\n" + "add_car to see all car" +
                    "\n" + "delete_car to delete car" +
                    "\n" + "quit to quit");
            command = scanner.next();
            switch (command.toLowerCase()){
                case "get_mechanics" -> {
                    mechanicDefaultService.findAll().forEach(m -> System.out.println(m.toString()));
                }
                case "get_cars" -> {
                    carDefaultService.findAll().forEach(c -> System.out.println(c.toString()));
                }
                case "add_car" -> {
                    UUID vin = UUID.randomUUID();
                    System.out.println("Enter brand:");
                    String brand = scanner.next();
                    System.out.println("Enter year of leaving car");
                    int year = scanner.nextInt();
                    System.out.println("Enter month of leaving car");
                    int month = scanner.nextInt();
                    System.out.println("Enter day of leaving car");
                    int day = scanner.nextInt();;
                    ArrayList<Mechanic> mechanics = new ArrayList<Mechanic>(mechanicDefaultService.findAll());
                    System.out.println("Enter number of mechanic:");
                    for (int i = 0; i<mechanics.size(); i+=1) {
                        System.out.println(i + ". " +mechanics.get(i).getName());
                    }
                    int numberOfMechanic = scanner.nextInt();

                    Car car = Car.builder()
                            .vin(vin)
                            .brand(brand)
                            .firstDay(LocalDate.of(year,month,day))
                            .mechanic(mechanics.get(numberOfMechanic))
                            .build();
                    carDefaultService.create(car);

                }
                case "delete_car" -> {
                    try {
                        System.out.println("Enter car's vin");
                        UUID uuid = UUID.fromString(scanner.next());
                        carDefaultService.delete(uuid);
                    }
                    catch (NoSuchElementException e){
                        System.out.println("Not found");
                    }
                }
                case "quit" -> {
                    break main_loop;
                }
            }
        }
        try {
            System.exit(0);
        }catch (SecurityException e){
            System.out.println(e.getMessage());
        }
    }
}
