package org.softwire.training.zoo.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Zebra extends AbstractAnimal implements LargeAnimal, CanBeGroomed, CanHaveMuckSweptOut {

    private LocalDateTime lastGroomed;
    private LocalDateTime lastSwept;

    public Zebra(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    @Override
    public void groom() {
        lastGroomed = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}; Last Groomed {1}", super.toString(), lastGroomed);
    }

    @Override
    public void sweepMuck() {
        lastSwept = LocalDateTime.now();
    }
}
