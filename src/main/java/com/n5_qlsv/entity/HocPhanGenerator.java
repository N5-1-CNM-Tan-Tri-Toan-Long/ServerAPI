package com.n5_qlsv.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class HocPhanGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String q = "SELECT hp.maHocPhan FROM HocPhan hp";
        Stream<String> id = session.createQuery(q, String.class).stream();
        Long max = id.map(o -> o.replace("422", "")).mapToLong(Long::parseLong).max().orElse(0L);
        return "422" + String.format("%07d", max + 1);
    }
}
