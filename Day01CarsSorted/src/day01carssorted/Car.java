package day01carssorted;

public class Car implements Comparable<Car> {
  private String makeModel;
  private double engineSizeL;
  private int prodYear;

  @Override
  public int compareTo(Car otherCar) {
    return this.makeModel.compareTo(otherCar.makeModel);
  }
  public Car() {
  }

  public Car(String makeModel, double engineSizeL, int prodYear) {
    this.makeModel = makeModel;
    this.engineSizeL = engineSizeL;
    this.prodYear = prodYear;
  }

  public String getMakeModel() {
    return makeModel;
  }

  public void setMakeModel(String makeModel) {
    this.makeModel = makeModel;
  }

  public double getEngineSizeL() {
    return engineSizeL;
  }

  public void setEngineSizeL(double engineSizeL) {
    this.engineSizeL = engineSizeL;
  }

  public int getProdYear() {
    return prodYear;
  }

  public void setProdYear(int prodYear) {
    this.prodYear = prodYear;
  }

  @Override
  public String toString() {
    return "Car{" + "makeModel=" + makeModel + ", engineSizeL=" + engineSizeL + ", prodYear=" + prodYear + '}';
  }

}
