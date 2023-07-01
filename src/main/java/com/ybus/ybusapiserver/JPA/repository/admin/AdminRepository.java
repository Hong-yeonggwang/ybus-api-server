package com.ybus.ybusapiserver.JPA.repository.admin;

import com.ybus.ybusapiserver.JPA.Entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin getById(String id);
}
