package com.n5_qlsv.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class SinhVienGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String q = "SELECT sv.maSV FROM SinhVien sv";
        Stream<String> id = session.createQuery(q, String.class).stream();
        Long max = id.map(o -> o.replace("180", "")).mapToLong(Long::parseLong).max().orElse(0L);
        return "180" + String.format("%05d", max + 1);
    }
}
