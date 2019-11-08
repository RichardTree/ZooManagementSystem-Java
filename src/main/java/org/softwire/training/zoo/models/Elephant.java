package org.softwire.training.zoo.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Elephant extends AbstractAnimal implements LargeAnimal, CanBeGroomed, CanHaveMuckSweptOut {

  private LocalDateTime lastGroomed;
  private LocalDateTime lastSwept;

  public Elephant(LocalDate dateOfBirth) {
    super(dateOfBirth);
  }

  @Override
  public void groom() {
    lastGroomed = LocalDateTime.now();
  }

  @Override
  public void sweepMuck() {
    lastSwept = LocalDateTime.now();
  }
}
