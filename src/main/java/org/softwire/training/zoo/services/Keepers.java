package org.softwire.training.zoo.services;

import java.util.Arrays;
import java.util.List;
import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.Keeper;
import org.softwire.training.zoo.models.LargeAnimal;
import org.softwire.training.zoo.models.SmallAnimal;

public class Keepers {

  private static Keepers instance;

  Keeper<LargeAnimal> largeAnimalKeeper = new Keeper<>(Animals.getInstance().getLargeAnimals());
  Keeper<SmallAnimal> smallAnimalKeeper = new Keeper<>(Animals.getInstance().getSmallAnimals());

  public List<Keeper<? extends Animal>> getKeepers() {
    return keepers;
  }

  public void setKeepers(
      List<Keeper<? extends Animal>> keepers) {
    this.keepers = keepers;
  }

  List<Keeper<? extends Animal>> keepers = Arrays.asList(largeAnimalKeeper, smallAnimalKeeper);

  public static Keepers getInstance() {
    if (instance == null) {
      instance = new Keepers();
    }
    return instance;
  }

  public Keeper<LargeAnimal> getLargeAnimalKeeper() {
    return largeAnimalKeeper;
  }

  public void setLargeAnimalKeeper(
      Keeper<LargeAnimal> largeAnimalKeeper) {
    this.largeAnimalKeeper = largeAnimalKeeper;
  }

  public Keeper<SmallAnimal> getSmallAnimalKeeper() {
    return smallAnimalKeeper;
  }

  public void setSmallAnimalKeeper(
      Keeper<SmallAnimal> smallAnimalKeeper) {
    this.smallAnimalKeeper = smallAnimalKeeper;
  }
}
