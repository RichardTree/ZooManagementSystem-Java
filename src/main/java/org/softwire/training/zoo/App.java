package org.softwire.training.zoo;

import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.Elephant;
import org.softwire.training.zoo.models.Guineafowl;
import org.softwire.training.zoo.models.Keeper;
import org.softwire.training.zoo.models.LargeAnimal;
import org.softwire.training.zoo.models.Lion;
import org.softwire.training.zoo.models.Rabbit;
import org.softwire.training.zoo.models.SmallAnimal;
import org.softwire.training.zoo.models.Zebra;
import org.softwire.training.zoo.services.FeedingScheduler;
import org.softwire.training.zoo.services.GroomingScheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.softwire.training.zoo.services.MuckScheduler;

public class App {
    public static void main(String[] args) {
        List<LargeAnimal> largeAnimals = Arrays.asList(
                new Lion(LocalDate.of(2010, 4, 28)),
                new Lion(LocalDate.of(2012, 5, 11)),
                new Zebra(LocalDate.of(2008, 12, 1)),
                new Elephant(LocalDate.of(2010,12,3))
        );
        List<SmallAnimal> smallAnimals = Arrays.asList(
                new Rabbit(LocalDate.of(2014, 1, 1)),
                new Guineafowl(LocalDate.of(2019,10, 2))
        );
        List<Animal> animals = new ArrayList<>();
        animals.addAll(largeAnimals);
        animals.addAll(smallAnimals);

        Keeper<LargeAnimal> largeAnimalKeeper = new Keeper<>(largeAnimals);
        Keeper<SmallAnimal> smallAnimalKeeper = new Keeper<>(smallAnimals);

        List<Keeper<? extends Animal>> keepers = Arrays.asList(largeAnimalKeeper, smallAnimalKeeper);

        Rabbit babyRabbit = new Rabbit(LocalDate.now());
        smallAnimalKeeper.startLookingAfter(babyRabbit);

        FeedingScheduler feedingScheduler = FeedingScheduler.getInstance();
        GroomingScheduler groomingScheduler = GroomingScheduler.getInstance();
        MuckScheduler muckingScheduler = MuckScheduler.getInstance();


        feedingScheduler.assignFeedingJobs(keepers);
        groomingScheduler.assignGroomingJobs(keepers);
        muckingScheduler.assignMuckJobs(keepers);
        animals.forEach(System.out::println);

    }
}
