package com.api.restfulApi.Repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class NativeQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Object> nativeQueryExample(Long id){

        Query query = em.createNativeQuery("SELECT * FROM locadora.tb_user WHERE id = :id");
        query.setParameter("id", id);

        List<Object> objects = query.getResultList();
        return  objects;
    }
}
