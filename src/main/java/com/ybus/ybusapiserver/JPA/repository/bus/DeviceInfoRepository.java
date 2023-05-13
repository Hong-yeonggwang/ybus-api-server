package com.ybus.ybusapiserver.JPA.repository.bus;

import com.ybus.ybusapiserver.JPA.Entity.bus.DeviceInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceInfoRepository extends JpaRepository<DeviceInfo, Long> {
}
