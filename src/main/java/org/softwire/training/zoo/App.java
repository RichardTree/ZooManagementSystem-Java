package org.softwire.training.zoo;

import org.softwire.training.zoo.models.Rabbit;
import org.softwire.training.zoo.services.Animals;
import org.softwire.training.zoo.services.AssignJobs;

import java.time.LocalDate;
import org.softwire.training.zoo.services.Keepers;

public class App {
    public static void main(String[] args) {


        Rabbit babyRabbit = new Rabbit(LocalDate.now());
        Keepers.getInstance().getSmallAnimalKeeper().startLookingAfter(babyRabbit);

        AssignJobs.getInstance().assignJobs();
        Animals.getInstance().getListOfAllAnimals().forEach(System.out::println);

    }
}
