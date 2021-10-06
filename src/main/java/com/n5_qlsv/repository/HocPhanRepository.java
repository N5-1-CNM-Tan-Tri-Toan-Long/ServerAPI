package com.n5_qlsv.repository;

import com.n5_qlsv.entity.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {
}
