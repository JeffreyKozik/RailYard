import java.util.*;

/**
 * Represents a railyard which consists of classification yards and tracks within the classification yard
 * @author Jeffrey Kozik
 */
public class RailYard<T extends Comparable<? super T>>{
  
  /** stores the inputted railyard array, each entry in the array represents a classification yard and the number in each entry is how many tracks are in each classification yard */
  private int[] inputRailYard;
  /** stores the railyard array list, each entry is another array list representing a classification yard and each classification yard stores linked lists representing tracks */
  private ArrayList<ArrayList<LinkedList<T>>> railYard; 
  
  /**
   * Creates a RailYard with the indicated inputted railyard array and transforms the inputted array into the railYard
   * @param inputRailYard The RailYard's inputted railyard array
   */
  public RailYard(int ... inputRailYard){
    this.inputRailYard = inputRailYard;
    if(inputRailYard[0] == 0){
      inputRailYard[0] = 1;
    }
    railYard = new ArrayList<ArrayList<LinkedList<T>>>(inputRailYard.length);
    /**
     * Creates an array list inside each railYard entry. These array lists represent classification yards
     * Each iteration the loop does this until all of railYard is filled. The length of each array list is determined by how many tracks are in each classification yard
     */
    for(int i = 0; i < inputRailYard.length; i++){
      railYard.add(new ArrayList<LinkedList<T>>(inputRailYard[i]));
      /**
       * Creates a linked list inside each railYard entry's entry. These linked lists represent tracks
       * Each iteration the loop does this until all of the railYard's entries are full.
       */
      for(int j = 0; j < this.inputRailYard[i]; j++){
        railYard.get(i).add(new LinkedList<T>());
      }
    }
    this.railYard = railYard;
  }
  
  /**
   * Transforms a classification yard into a train.
   * @param train The train to be merged into
   * @param currentClassificationYard The current classification yard that is being transformed
   */
  public void merge(T[] train, int currentClassificationYard){
    /** The amount of elements that have been removed from the current classification yard */
    int elementsRemoved = 0;
    /** The track that currently has the lowest first number */
    int currentLowestTrack = 0;
    /** The element to compare the current lowest track's element with */
    T elementToBeComparedTo;
    /**
     * Goes through all of the current classification yard until all elements have been removed
     * Each iteration it compares all of the tracks first elements and removes the element that is the lowest from the track and adds it to the end of the train
     */
    while(elementsRemoved < train.length){
      currentLowestTrack = 0;
      /**
       * Determines where to begin the comparisons from.
       * Each iteration it determines if the current lowest track is empty and if the track exists; if both of these are true, the current lowest track is incremented by one.
       */
      while((currentLowestTrack < inputRailYard[currentClassificationYard]) && (railYard.get(currentClassificationYard).get(currentLowestTrack).isEmpty())){
        currentLowestTrack++;
      }
      /**
       * Runs through each track to determine the element that is smallest. Runs through until the first element of all tracks have been considered.
       * Each iteration the current lowest track is compared with the next element it can be compared to. Whichever is smaller becomes the current lowest track.
       */
      for(int i = 0; i < inputRailYard[currentClassificationYard] - 1; i++){
        elementToBeComparedTo = null;
        /** represents the potential location of the next track whose first element exists and can be compared to the current lowest track's first element */
        int trackToBeComparedTo = currentLowestTrack + 1;
        /**
         * Determines which track's first element to compare to.
         * Each iteration it determines if the track to be compared to is empty and if the track exists; if both of these are true, the track to be compared to is incremented by one
         */
        while((trackToBeComparedTo < inputRailYard[currentClassificationYard]) && (railYard.get(currentClassificationYard).get(trackToBeComparedTo).isEmpty())){
          trackToBeComparedTo++;
        }
        /* If the track to be compared to exists, the element to be compared to is the first element of that track */
        if(trackToBeComparedTo < inputRailYard[currentClassificationYard]){
          elementToBeComparedTo = railYard.get(currentClassificationYard).get(trackToBeComparedTo).getFirst();
        }
        /* If the element ot be compared to exists and if it is less than the current lowest track's first element, the new current lowest track becomes the track to be compared to */
        if(elementToBeComparedTo != null){
          if(elementToBeComparedTo.compareTo(railYard.get(currentClassificationYard).get(currentLowestTrack).getFirst()) < 0){
            currentLowestTrack = trackToBeComparedTo;
          }
        }
      }
      /** The current lowest track, which has now been determined to be the lowest track in that iteration is removed from its track, added to the train, and incremented by one */
            System.out.println(Arrays.toString(train));
      train[elementsRemoved++] = railYard.get(currentClassificationYard).get(currentLowestTrack).removeFirst();
      System.out.println(Arrays.toString(train));
    }
  }
  
  /**
   * Transforms a classification yard into a train.
   * @param train The train to be merged into
   * @param currentClassificationYard The current classification yard that is being transformed
   * @param size The size or length of the train that was inputted
   */
  public void merge(LinkedList<T> train, int currentClassificationYard, int size){
    /** The amount of elements that have been removed from the current classification yard */
    int elementsRemoved = 0;
    /** The track that currently has the lowest first number */
    int currentLowestTrack = 0;
    /** The element to compare the current lowest track's element with */
    T elementToBeComparedTo;
    /**
     * Goes through all of the current classification yard until all elements have been removed
     * Each iteration it compares all of the tracks first elements and removes the element that is the lowest from the track and adds it to the end of the train
     */
    for(int z = 0; z < size; z++){
      currentLowestTrack = 0;
      /**
       * Determines where to begin the comparisons from.
       * Each iteration it determines if the current lowest track is empty and if the track exists; if both of these are true, the current lowest track is incremented by one.
       */
      while((currentLowestTrack < inputRailYard[currentClassificationYard]) && (railYard.get(currentClassificationYard).get(currentLowestTrack).isEmpty())){
        currentLowestTrack++;
      }
      /**
       * Runs through each track to determine the element that is smallest. Runs through until the first element of all tracks have been considered.
       * Each iteration the current lowest track is compared with the next element it can be compared to. Whichever is smaller becomes the current lowest track.
       */
      for(int i = 0; i < inputRailYard[currentClassificationYard] - 1; i++){
        elementToBeComparedTo = null;
        /** represents the potential location of the next track whose first element exists and can be compared to the current lowest track's first element */
        int trackToBeComparedTo = currentLowestTrack + 1;
        /**
         * Determines which track's first element to compare to.
         * Each iteration it determines if the track to be compared to is empty and if the track exists; if both of these are true, the track to be compared to is incremented by one
         */
        while((trackToBeComparedTo < inputRailYard[currentClassificationYard]) && (railYard.get(currentClassificationYard).get(trackToBeComparedTo).isEmpty())){
          trackToBeComparedTo++;
        }
        /* If the track to be compared to exists, the element to be compared to is the first element of that track */
        if(trackToBeComparedTo < inputRailYard[currentClassificationYard]){
          elementToBeComparedTo = railYard.get(currentClassificationYard).get(trackToBeComparedTo).getFirst();
        }
        /* If the element ot be compared to exists and if it is less than the current lowest track's first element, the new current lowest track becomes the track to be compared to */
        if(elementToBeComparedTo != null){
          if(elementToBeComparedTo.compareTo(railYard.get(currentClassificationYard).get(currentLowestTrack).getFirst()) < 0){
            currentLowestTrack = trackToBeComparedTo;
          }
        }
      }
      /** The current lowest track, which has now been determined to be the lowest track in that iteration is removed from its track, added to the train, and incremented by one */
      train.add(railYard.get(currentClassificationYard).get(currentLowestTrack).removeFirst());
    }
  }
  
  /* Sorts the train using the cycle sort method by taking the train through the railYard.
   * @param train The train, an array of comparable objects to be sorted.
   */
  public void cycleSort(T[] train){
    if(train.length != 0){
      /**
       * Goes through each classification yard in the rail yard until all of them have been gone through. 
       * Each time it cycle sorts the train and merges the train back together.
       */
      for(int currentClassificationYard = 0; currentClassificationYard < inputRailYard.length; currentClassificationYard++){
        /** Keeps track of the current track the last train component has been on */
        int currentTrack = 0;
        /* Adds the first component of the train to the first track */
        railYard.get(currentClassificationYard).get(0).add(train[0]);
        /**
         * Goes through every component of the train from first to last and determines which track it should be added to depending on its relationship with the previous component
         * Each time the component is compared to the prior one - if greater than or equal to it's added to the end of the same track as the prior one; current track remains the same
         * If less than and if the next track exists it's added to the end of that track; current track is incremented
         * If less than and the next track doesn't exist it's added to the end of the first track; current track becomes 0
         */
        for(int i = 1; i < train.length; i++){
          if(train[i].compareTo(train[i-1]) >= 0){
            railYard.get(currentClassificationYard).get(currentTrack).add(train[i]);
          }
          else if(train[i].compareTo(train[i-1]) < 0){
            if(currentTrack < this.inputRailYard[currentClassificationYard] - 1){
              railYard.get(currentClassificationYard).get(++currentTrack).add(train[i]);
            }
            else{
              currentTrack = 0;
              railYard.get(currentClassificationYard).get(currentTrack).add(train[i]);
            }
          }
        }
        merge(train, currentClassificationYard);
      }
    }
  }
  
  /* Sorts the train using the cycle sort method by taking the train through the railYard.
   * @param train The train, a linked list of comparable objects to be sorted.
   */
  public void cycleSort(LinkedList<T> train){
    /**
     * Goes through each classification yard in the rail yard until all of them have been gone through. 
     * Each time it cycle sorts the train and merges the train back together.
     */
    for(int currentClassificationYard = 0; currentClassificationYard < inputRailYard.length; currentClassificationYard++){
      /** The size of the inputted train. This has to be determined manually because otherwise memory and time is being wasted */
      int size = 0;
      /** The previous component in the train. This starts as the first element of the train because there is nothing before that */
      T previousComponent = train.getFirst();
      /** Whether or not the first component has been iterated through or not. This way the program doesn't 'double count' the first element */
      boolean notFirstComponent = false;
      /** Keeps track of the current track the last train component has been on */
      int currentTrack = 0;
      /* Adds the first component of the train to the first track */
      railYard.get(currentClassificationYard).get(0).add(train.getFirst());
      /**
       * Goes through every component of the train from first to last and determines which track it should be added to depending on its relationship with the previous component
       * Each time the component is compared to the prior one - if greater than or equal to it's added to the end of the same track as the prior one; current track remains the same
       * If less than and if the next track exists it's added to the end of that track; current track is incremented
       * If less than and the next track doesn't exist it's added to the end of the first track; current track becomes 0
       */
      Iterator<T> trainIterator = train.iterator();
      while(trainIterator.hasNext()){
        size++;
        /** Stores the current value in the iteration */
        T currentComponent = trainIterator.next();
        /** If the first component has already been gone through then the loop continues as normal. If it hasn't been gone through then the logic is skipped */
        if(notFirstComponent){
        if(currentComponent.compareTo(previousComponent) >= 0){
          railYard.get(currentClassificationYard).get(currentTrack).add(currentComponent);
        }
        else if(currentComponent.compareTo(previousComponent) < 0){
          if(currentTrack < this.inputRailYard[currentClassificationYard] - 1){
            railYard.get(currentClassificationYard).get(++currentTrack).add(currentComponent);
          }
          else{
            currentTrack = 0;
            railYard.get(currentClassificationYard).get(currentTrack).add(currentComponent);
          }
        }
          previousComponent = currentComponent;
        }
        else{
          notFirstComponent = true;
        }
      }
      train = new LinkedList<T>();
      merge(train, currentClassificationYard, size);
    }
    System.out.println(train);
  }
  
  /* Sorts the train using the closest sort method by taking the train through the railYard.
   * @param train The train, an array of comparable objects to be sorted.
   */
  public void closestSort(T[] train){
    if(train.length != 0){
      /** Stores the track whose last element is currently the closest in value to the train element it's being compared to, while also being less than the train element
        * It is initialized at -1 because no track is the -1st track. This allows the program to determine how to change this value accordingly
        */
      int currentClosestTrack = -1;
      /** Stores the track whose last element is definitively the closest in value to the train element it's compared to, while also being less than the train element */
      int finalClosestTrack = 0;
      /** Stores the track whose last element is the lowest in value if no track's last element has been smaller than the train element
        * It is initialized at -1 because no track is the -1st track. This allows the program to determine how to change this value accordingly
        */
      int maybeClosestTrack = -1;
      /** Stores whether any track's last element has been lower than the train element it is being compared to yet */
      boolean itsEqual = false;
      boolean noneAreLower = true;
      /**
       * Goes through each classification yard in the rail yard until all of them have been gone through. 
       * Each time it cycle sorts the train and merges the train back together.
       */
      for(int currentClassificationYard = 0; currentClassificationYard < inputRailYard.length; currentClassificationYard++){
        /* Adds the first component of the train to the first track */
        railYard.get(currentClassificationYard).get(0).add(train[0]);
        /**
         * Goes through every component of the train from first to last and determines which track it should be added to depending on it's relationship with track's last elements
         * Each time the component is compared to each track's last element
         * It is put on the end of the track whose last element is the biggest while still being less than or equal to it 
         * If no such track exists it is put on an empty track
         * If no empty track is available, it is added to the end of the track whose last element is the lowest 
         */
        for(int i = 1; i < train.length; i++){
          currentClosestTrack = -1;
          finalClosestTrack = 0;
          maybeClosestTrack = -1;
          noneAreLower = true;
          itsEqual = false;
          /** The current track whose last element is being compared to the train component */
          int comparedToTrack = 0;
          /**
           * Goes through every track until reaching the end or finding a track whose last component equals the train component and determines which track to add the componenet to
           * Each time the component is compared to a tracks last element and conditionals determine how exactly to treat that situation. 
           */
          for(; comparedToTrack < inputRailYard[currentClassificationYard] && !itsEqual; comparedToTrack++){
            /**
             * First of all the train component is only going to be compared to a track that isn't empty because empty tracks have no last element to be compared to
             * If the track is empty the loop is simply iterated again
             * If the track isn't empty the rest of the logic proceeds
             */
            if(!(railYard.get(currentClassificationYard).get(comparedToTrack).isEmpty())){
              /** If none are lower is true meaning that no elements have been found less than or equal to the train component, then the following logic proceeds */
              if(noneAreLower){
                /** 
                 * If maybe closest track is -1, meaning this is the first track to be compared to, maybeClosestTrack is automatically set to the current track because
                 * since it is the only track seen so far it has to be the lowest one
                 */
                if(maybeClosestTrack == -1){
                  maybeClosestTrack = comparedToTrack;
                }
                /*
                 * Otherwise, if this isn't the first track to be compared to, the current track's last element is compared to what was previously thought to be the
                 * lowest of any tracks last elements. If the current track's is lower then it becomes the new maybeClosestTrack as it is now thought of as the lowest 
                 * of any tracks last elements.
                 */
                else if(railYard.get(currentClassificationYard).get(comparedToTrack).getLast().compareTo(railYard.get(currentClassificationYard).get(maybeClosestTrack).getLast()) < 0){
                  maybeClosestTrack = comparedToTrack;
                }
              }
              /* If a track's last element that is lower than the train component has already been determined to exist, the following 2 else ifs are carried forward */
              /**
               * If the current track's last element is equal to the train component we already know nothing can get any closer in equailty, so the final closest track is
               * set to the current track
               */
              if(railYard.get(currentClassificationYard).get(comparedToTrack).getLast().compareTo(train[i]) == 0){
                finalClosestTrack = comparedToTrack;
                itsEqual = true;
              }
              /* If the current track's last element isn't equal to the train component, then if it is less than the train component the nested if statements are performed */
              if(railYard.get(currentClassificationYard).get(comparedToTrack).getLast().compareTo(train[i]) < 0){
                noneAreLower = false;
                /**
                 * If this is the first track whose last element is less than the train component, then this has to be the track whose element is the biggest while still
                 * being less than the train component so the currentClosestTrack is set to be it
                 */
                if(currentClosestTrack == -1){
                  currentClosestTrack = comparedToTrack;
                }
                /* Otherwise if this isn't the first track in that scenario, then if it is greater than the previous closest one it becomes the new closest one */
                else if(railYard.get(currentClassificationYard).get(comparedToTrack).getLast().compareTo(railYard.get(currentClassificationYard).get(currentClosestTrack).getLast()) > 0){
                  currentClosestTrack = comparedToTrack;
                }
              }
            }
          }
          finalClosestTrack = currentClosestTrack;
          /* If after going through all of the tracks none of their last elements are less than or equal to the train component, the following logic is evaluated */
          if(noneAreLower){
            /* Our final determination on the track to put the train component on is the track whose last element is the lowest */
            finalClosestTrack = maybeClosestTrack;
            /* However, our final determination changes if there is an empty track that we can put the train component on */
            /**
             * Goes through every track to see which ones are empty. The last one that is empty becomes the final closest track
             * Each iteration the next track is evaluated
             */
            for(int k = 0; k < inputRailYard[currentClassificationYard]; k++){
              /* If a track is empty, that means that the train component can go there so that is what we set final closest track to be */
              if(railYard.get(currentClassificationYard).get(k).isEmpty()){
                finalClosestTrack = k;
              }
            }
          }
          railYard.get(currentClassificationYard).get(finalClosestTrack).add(train[i]);
          System.out.println(railYard);
        }
        merge(train, currentClassificationYard);
      }
    }
  }
  
  /* Sorts the train using the closest sort method by taking the train through the railYard.
   * @param train The train, an array of comparable objects to be sorted.
   */
  public void closestSort(LinkedList<T> train){
    /** Stores the track whose last element is currently the closest in value to the train element it's being compared to, while also being less than the train element
      * It is initialized at -1 because no track is the -1st track. This allows the program to determine how to change this value accordingly
    */
    int currentClosestTrack = -1;
    /** Stores the track whose last element is definitively the closest in value to the train element it's compared to, while also being less than the train element */
    int finalClosestTrack = 0;
    /** Stores the track whose last element is the lowest in value if no track's last element has been smaller than the train element
      * It is initialized at -1 because no track is the -1st track. This allows the program to determine how to change this value accordingly
    */
    int maybeClosestTrack = -1;
    boolean itsEqual = false;
    /** Stores whether any track's last element has been lower than the train element it is being compared to yet */
    boolean noneAreLower = true;
    /**
     * Goes through each classification yard in the rail yard until all of them have been gone through. 
     * Each time it cycle sorts the train and merges the train back together.
     */
    for(int currentClassificationYard = 0; currentClassificationYard < inputRailYard.length; currentClassificationYard++){
      /* Adds the first component of the train to the first track */
      railYard.get(currentClassificationYard).get(0).add(train.getFirst());
      /** The size of the inputted train. This has to be determined manually because otherwise memory and time is being wasted */
      int size = 0;
      /** Whether or not the first component has been iterated through or not. This way the program doesn't 'double count' the first element */
      boolean notFirstComponent = false;
      /** Keeps track of the current track the last train component has been on */
      int currentTrack = 0;
      /**
       * Goes through every component of the train from first to last and determines which track it should be added to depending on its relationship with the previous component
       * Each time the component is compared to the prior one - if greater than or equal to it's added to the end of the same track as the prior one; current track remains the same
       * If less than and if the next track exists it's added to the end of that track; current track is incremented
       * If less than and the next track doesn't exist it's added to the end of the first track; current track becomes 0
       */
      Iterator<T> trainIterator = train.iterator();
      while(trainIterator.hasNext()){
        size++;
        /** Stores the current value on the iterator */
        T currentComponent = trainIterator.next();
        currentClosestTrack = -1;
        finalClosestTrack = 0;
        maybeClosestTrack = -1;
        noneAreLower = true;
        itsEqual = false;
        /** The current track whose last element is being compared to the train component */
        int comparedToTrack = 0;
        /**
         * Goes through every track until reaching the end or finding a track whose last component equals the train component and determines which track to add the componenet to
         * Each time the component is compared to a tracks last element and conditionals determine how exactly to treat that situation. 
         */
        if(notFirstComponent){
          /**
           * Goes through every component of the train from first to last and determines which track it should be added to depending on it's relationship with track's last elements
           * Each time the component is compared to each track's last element
           * It is put on the end of the track whose last element is the biggest while still being less than or equal to it 
           * If no such track exists it is put on an empty track
           * If no empty track is available, it is added to the end of the track whose last element is the lowest 
           */
          for(; comparedToTrack < inputRailYard[currentClassificationYard] && !itsEqual; comparedToTrack++){
            /**
             * First of all the train component is only going to be compared to a track that isn't empty because empty tracks have no last element to be compared to
             * If the track is empty the loop is simply iterated again
             * If the track isn't empty the rest of the logic proceeds
             */
            if(!(railYard.get(currentClassificationYard).get(comparedToTrack).isEmpty())){
              /** If none are lower is true meaning that no elements have been found less than or equal to the train component, then the following logic proceeds */
              if(noneAreLower){
                /** 
                 * If maybe closest track is -1, meaning this is the first track to be compared to, maybeClosestTrack is automatically set to the current track because
                 * since it is the only track seen so far it has to be the lowest one
                 */
                if(maybeClosestTrack == -1){
                  maybeClosestTrack = comparedToTrack;
                }
                /*
                 * Otherwise, if this isn't the first track to be compared to, the current track's last element is compared to what was previously thought to be the
                 * lowest of any tracks last elements. If the current track's is lower then it becomes the new maybeClosestTrack as it is now thought of as the lowest 
                 * of any tracks last elements.
                 */
                else if(railYard.get(currentClassificationYard).get(comparedToTrack).getLast().compareTo(railYard.get(currentClassificationYard).get(maybeClosestTrack).getLast()) < 0){
                  maybeClosestTrack = comparedToTrack;
                }
              }
              /* If a track's last element that is lower than the train component has already been determined to exist, the following 2 else ifs are carried forward */
              /**
               * If the current track's last element is equal to the train component we already know nothing can get any closer in equailty, so the final closest track is
               * set to the current track
               */
              if(railYard.get(currentClassificationYard).get(comparedToTrack).getLast().compareTo(currentComponent) == 0){
                finalClosestTrack = comparedToTrack;
                itsEqual = true;
              }
              /* If the current track's last element isn't equal to the train component, then if it is less than the train component the nested if statements are performed */
              if(railYard.get(currentClassificationYard).get(comparedToTrack).getLast().compareTo(currentComponent) < 0){
                noneAreLower = false;
                /**
                 * If this is the first track whose last element is less than the train component, then this has to be the track whose element is the biggest while still
                 * being less than the train component so the currentClosestTrack is set to be it
                 */
                if(currentClosestTrack == -1){
                  currentClosestTrack = comparedToTrack;
                }
                /* Otherwise if this isn't the first track in that scenario, then if it is greater than the previous closest one it becomes the new closest one */
                else if(railYard.get(currentClassificationYard).get(comparedToTrack).getLast().compareTo(railYard.get(currentClassificationYard).get(currentClosestTrack).getLast()) > 0){
                  currentClosestTrack = comparedToTrack;
                }
              }
            }
          }
          finalClosestTrack = currentClosestTrack;
          /* If after going through all of the tracks none of their last elements are less than or equal to the train component, the following logic is evaluated */
          if(noneAreLower){
            /* Our final determination on the track to put the train component on is the track whose last element is the lowest */
            finalClosestTrack = maybeClosestTrack;
            /* However, our final determination changes if there is an empty track that we can put the train component on */
            /**
             * Goes through every track to see which ones are empty. The last one that is empty becomes the final closest track
             * Each iteration the next track is evaluated
             */
            for(int k = 0; k < inputRailYard[currentClassificationYard]; k++){
              /* If a track is empty, that means that the train component can go there so that is what we set final closest track to be */
              if(railYard.get(currentClassificationYard).get(k).isEmpty()){
                finalClosestTrack = k;
              }
            }
          }
          railYard.get(currentClassificationYard).get(finalClosestTrack).add(currentComponent);
        }
        else{
          notFirstComponent = true;
        }
      }
      train = new LinkedList<T>();
      merge(train, currentClassificationYard, size);
    }
    System.out.println(train);
  }
  
  public static <T extends Comparable<? super T>> void main(String[] args){
    try{
      String method;
      method = args[0];
      int classificationYards = Integer.parseInt(args[1]);
      int[] inputRailYard = new int[classificationYards];
      int i = 2;
      for(int j = 0; j < classificationYards; i++, j++){
        inputRailYard[j] = Integer.parseInt(args[i]);
      }
      int trainLength = args.length - i++;
      LinkedList<T> train = new LinkedList<T>();
      for(; i < args.length; i++){
        train.add((T)args[i]);
      }
      RailYard<T> r = new RailYard<T>(inputRailYard);
      if(method.equals("cycle")){
        r.cycleSort(train);
      }
      if(method.equals("closest")){
        r.closestSort(train);
      }
    }
    catch (NumberFormatException e){
      System.out.println("Please check to make sure that you have entered the correct number of classification yards for the size of your rail yard." +
                         "Additionally make sure that all of your train cars are the same type. Thank you!");
    }
  }
}