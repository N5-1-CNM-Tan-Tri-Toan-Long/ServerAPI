package com.n5_qlsv.repository;

import com.n5_qlsv.entity.HocPhan;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, String> {
}
