package com.ybus.ybusapiserver.JPA.repository.bus;

import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Override
    @EntityGraph(attributePaths = {"locations"})
    List<Device> findAll();

    Device getByDeviceSeq(Long deviceSeq);

}
