package com.ProjetSpring.ProjetSpring.Service;
import com.ProjetSpring.ProjetSpring.CarRepository;
import com.ProjetSpring.ProjetSpring.model.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public void saveCar(Car car) {
		this.carRepository.save(car);
	}

	@Override
	public Car getCarById(long id) {
		Optional<Car> optionalCar = carRepository.findById((int) id);
		Car car = null;
		if (optionalCar.isPresent()) {
			car = optionalCar.get();
		} else {
			throw new RuntimeException("Car not found for id : " + id);
		}
		return car;
	}
	@Override
	public void deleteCarById(long id) {
		this.carRepository.deleteById((int) id);
		
	}

	@Override
	public Page<Car> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
				Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
		return this.carRepository.findAll(pageable);
	}
}
