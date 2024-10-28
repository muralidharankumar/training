package first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarFinder {
    private List<Car> cars;

    public CarFinder(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * finds the suitable car based on customer provided inputs
     * Time Complexity : O(n)
     * Auxiliary Space : O(n) -> n is the number of cars that satisfy all filters
     *
     * @param maxPrice  maximum price, customer willing to pay and buy the car
     * @param minRating minimum rating, customer is expecting
     * @param brand     customer preferred brand, if nothing they will provide 'none'
     * @return suitable best cars
     */
    public List<Car> findSuitableCars(double maxPrice, double minRating, String brand) {
        return cars.stream()
                .filter(car -> car.getPrice() <= maxPrice)
                .filter(car -> car.getRating() >= minRating)
                .filter(car -> brand.equalsIgnoreCase("none") ||
                        car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        // Adding some sample cars
        carList.add(new Car(1, 20000, "Toyota", "Corolla", 15000, 4.5));
        carList.add(new Car(2, 30000, "Honda", "Civic", 12000, 4.7));
        carList.add(new Car(3, 15000, "Ford", "Fiesta", 25000, 4.0));
        carList.add(new Car(4, 25000, "Tesla", "Model 3", 8000, 4.9));

        CarFinder carFinder = new CarFinder(carList);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter max price: ");
        double maxPrice = scanner.nextDouble();

        System.out.print("Enter minimum rating: ");
        double minRating = scanner.nextDouble();

        System.out.print("Enter preferred brand (enter none if no specific brand): ");
        String brand = scanner.next();

        List<Car> suitableCars = carFinder.findSuitableCars(maxPrice, minRating, brand);

        if (suitableCars.isEmpty()) {
            System.out.println("No suitable cars found.");
        } else {
            System.out.println("Suitable cars found:");
            suitableCars.forEach(System.out::println);
        }

        scanner.close();
    }
}
