package cn.hutool.core.clone;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultCloneTest {

	@Test
	public void clone0() {
		Car oldCar = new Car();
		oldCar.setId(1);
		oldCar.setWheelList(Stream.of(new Wheel("h")).collect(Collectors.toList()));

		Car newCar = oldCar.clone0();
		assertEquals(oldCar.getId(), newCar.getId());
		assertEquals(oldCar.getWheelList(), newCar.getWheelList());

		newCar.setId(2);
		assertNotEquals(oldCar.getId(), newCar.getId());
		newCar.getWheelList().add(new Wheel("s"));

		assertNotSame(oldCar, newCar);

	}

	@Data
	static class Car implements DefaultCloneable<Car> {
		private Integer id;
		private List<Wheel> wheelList;
	}

	@Data
	@AllArgsConstructor
	static class Wheel {
		private String direction;
	}

}


