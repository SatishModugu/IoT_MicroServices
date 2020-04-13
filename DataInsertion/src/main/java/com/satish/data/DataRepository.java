package com.satish.data;

import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<SensorData, Long> {
	SensorData findByDeviceID(String deviceID);
}
