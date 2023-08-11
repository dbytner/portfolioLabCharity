package pl.coderslab.charity.institution;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.category.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class InstitutionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Institution institution){
        entityManager.persist(institution);
    }

    public Institution find(long id){
        return entityManager.find(Institution.class ,id);
    }


    public void update(Institution institution){
        entityManager.merge(institution);
    }

    public void delete(Institution institution){
        entityManager.remove(entityManager.contains(institution) ? institution: entityManager.merge(institution));
    }

    public List<Category> findAllInstitutions(){
        return entityManager.createQuery("SELECT i FROM Institution i").getResultList();
    }
}
