package org.softwire.training.zoo.services;

import java.util.List;
import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.CanHaveMuckSweptOut;
import org.softwire.training.zoo.models.Keeper;



public class MuckScheduler {

  private static MuckScheduler instance;

  private MuckScheduler() {
  }

  public static MuckScheduler getInstance() {
    if (instance == null) {
      instance = new MuckScheduler();
    }
    return instance;
  }

  public void assignMuckJobs(List<Keeper<? extends Animal>> keepers) {
    keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(animal -> {
      if (animal instanceof CanHaveMuckSweptOut) {
        keeper.sweepMuck((CanHaveMuckSweptOut) animal);
      }
    }));
  }

}
