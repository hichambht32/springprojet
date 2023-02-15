package com.ProjetSpring.ProjetSpring.Service;
import java.util.List;
import com.ProjetSpring.ProjetSpring.model.Car;
import org.springframework.data.domain.Page;
 
public interface CarService {
    List<Car> getAllCars();
    void saveCar(Car car);
    Car getCarById(long id);
    void deleteCarById(long id);
    Page<Car> findPaginated(int pageNum, int pageSize,
                               String sortField,
                               String sortDirection);
}