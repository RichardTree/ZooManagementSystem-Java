package org.softwire.training.zoo.services;

import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.Keeper;

import java.util.List;

public class FeedingScheduler {
    private static FeedingScheduler instance = new FeedingScheduler();

    private FeedingScheduler() {
    }

    public static FeedingScheduler getInstance() {
        return instance;
    }

    public void assignFeedingJobs(List<Keeper<? extends Animal>> keepers) {
        keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(keeper::feed));
    }
}
