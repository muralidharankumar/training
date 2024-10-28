package first;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private long id;
    private double price;
    private String brand;
    private String model;
    private double mileageInKM;
    private double rating;

}
