package com.n5_qlsv.repository;

import com.n5_qlsv.entity.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, Long> {
}
