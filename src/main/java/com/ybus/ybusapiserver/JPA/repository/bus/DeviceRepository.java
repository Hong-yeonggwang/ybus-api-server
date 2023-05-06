package com.ybus.ybusapiserver.JPA.repository.bus;

import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

}
