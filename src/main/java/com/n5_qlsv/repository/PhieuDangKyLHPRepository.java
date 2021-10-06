package com.n5_qlsv.repository;

import com.n5_qlsv.entity.PhieuDangKyLHP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PhieuDangKyLHPRepository extends JpaRepository<PhieuDangKyLHP, Long> {
}
