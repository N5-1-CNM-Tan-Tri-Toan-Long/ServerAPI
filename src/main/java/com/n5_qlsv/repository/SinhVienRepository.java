package com.n5_qlsv.repository;

import com.n5_qlsv.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
}