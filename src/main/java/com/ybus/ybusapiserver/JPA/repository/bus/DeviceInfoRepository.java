package com.ybus.ybusapiserver.JPA.repository.bus;

import com.ybus.ybusapiserver.JPA.Entity.bus.Device;
import com.ybus.ybusapiserver.JPA.Entity.bus.DeviceInfo;
import com.ybus.ybusapiserver.JPA.QueryDslCustom.DeviceInfoRepositoryCustom;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceInfoRepository extends JpaRepository<DeviceInfo, Long>, DeviceInfoRepositoryCustom {
    DeviceInfo getDeviceInfoByDeviceSeq(Device device);

    DeviceInfo getByDeviceSeq(Long deviceSeq);

    @Override
    @EntityGraph(attributePaths = {"deviceSeq"})
    List<DeviceInfo> findAll();
}
