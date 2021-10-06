package com.n5_qlsv.repository;

import com.n5_qlsv.entity.ChiTietLopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CTLHPRepository extends JpaRepository<ChiTietLopHocPhan, Long> {
}
