package org.softwire.training.zoo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.Elephant;
import org.softwire.training.zoo.models.Guineafowl;
import org.softwire.training.zoo.models.LargeAnimal;
import org.softwire.training.zoo.models.Lion;
import org.softwire.training.zoo.models.Rabbit;
import org.softwire.training.zoo.models.SmallAnimal;
import org.softwire.training.zoo.models.Zebra;

public class Animals {

  private static Animals instance;

    List<LargeAnimal> largeAnimals = Arrays.asList(
        new Lion(LocalDate.of(2010, 4, 28)),
        new Lion(LocalDate.of(2012, 5, 11)),
        new Zebra(LocalDate.of(2008, 12, 1)),
        new Elephant(LocalDate.of(2010, 12, 3))
    );
    List<SmallAnimal> smallAnimals = Arrays.asList(
        new Rabbit(LocalDate.of(2014, 1, 1)),
        new Guineafowl(LocalDate.of(2019, 10, 2))
    );

  public static Animals getInstance() {
    if (instance == null) {
      instance = new Animals();
    }
    return instance;
  }

  public List<LargeAnimal> getLargeAnimals() {
    return largeAnimals;
  }

  public void setLargeAnimals(List<LargeAnimal> largeAnimals) {
    this.largeAnimals = largeAnimals;
  }

  public List<SmallAnimal> getSmallAnimals() {
    return smallAnimals;
  }

  public void setSmallAnimals(List<SmallAnimal> smallAnimals) {
    this.smallAnimals = smallAnimals;
  }

  public List<Animal> getListOfAllAnimals() {
    List<Animal> animals = new ArrayList<>();
    animals.addAll(smallAnimals);
    animals.addAll(largeAnimals);
    return animals;
  }
}
