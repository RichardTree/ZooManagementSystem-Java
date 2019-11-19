package org.softwire.training.zoo.services;

import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.Keeper;

public class AssignJobs {

  private static AssignJobs instance;

  FeedingScheduler feedingScheduler = FeedingScheduler.getInstance();
  GroomingScheduler groomingScheduler = GroomingScheduler.getInstance();
  MuckScheduler muckingScheduler = MuckScheduler.getInstance();

  public static AssignJobs getInstance() {
    if (instance == null) {
      instance = new AssignJobs();
    }
    return instance;
  }

  public void assignJobs() {
    feedingScheduler.assignFeedingJobs(Keepers.getInstance().getKeepers());
    groomingScheduler.assignGroomingJobs(Keepers.getInstance().getKeepers());
    muckingScheduler.assignMuckJobs(Keepers.getInstance().getKeepers());
  }
}
