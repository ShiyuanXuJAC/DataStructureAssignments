
package day01carssorted;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Day01CarsSorted {

  static ArrayList<Car> parking = new ArrayList<>();

  static void readDataFromFile() throws Exception {
    parking.clear();
    Scanner sc = new Scanner(new File("cars.txt"));
    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String carFields[] = line.split(";");
      Car car = new Car();
      car.setMakeModel(carFields[0].trim());
      car.setEngineSizeL(Double.parseDouble(carFields[1].trim()));
      car.setProdYear(Integer.parseInt(carFields[2].trim()));
      parking.add(car);
    }
  }

  static void printCars() {
    for (Car car : parking) {
      System.out.println(car.toString());
    }
  }

  public static void main(String[] args) {

    try {
      readDataFromFile();
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Print Cars:");
    printCars();

    System.out.println("\nSorted by makeModel using Comparable<Car>:");
    Collections.sort(parking);
    printCars();

    System.out.println("\nSorted by enginSizeL using Comparator<Car>:");
    Comparator<Car> enginSizeLComparator = Comparator.comparingDouble(car -> car.getEngineSizeL());
    Collections.sort(parking, enginSizeLComparator);
    printCars();

    System.out.println("\nSorted by prodYear using lambda:");
    parking.sort((car1, car2) -> car1.getProdYear() - car2.getProdYear());
    printCars();
    
    System.out.println("\nSorted by prodYear then makeModel (using lambda):");
    parking.sort(Comparator.comparingInt((Car car) -> car.getProdYear()).thenComparing(car -> car.getMakeModel()));
    printCars();
  }

}
