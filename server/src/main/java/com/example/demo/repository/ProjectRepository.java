package com.example.demo.repository;

import com.example.demo.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@RepositoryRestResource
public interface ProjectRepository extends JpaRepository<Project, Long>, ProjectRepositoryCustom {
    // default implementation from JPA
    Project findByName(final String name);

    // this is to handle custom query
    @Repository
    class ProjectRepositoryImpl implements ProjectRepositoryCustom {
        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public List<Project> find(final String serachString) {
            final Query query = entityManager.createQuery("from Project p where p.name like :p1");
            query.setParameter("p1", "%" + serachString + "%");
            return query.getResultList();
        }
    }
}
