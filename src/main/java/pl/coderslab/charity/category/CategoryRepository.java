package pl.coderslab.charity.category;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category category){
        entityManager.persist(category);
    }

    public Category find(long id){
        return entityManager.find(Category.class ,id);
    }


    public void update(Category category){
        entityManager.merge(category);
    }

    public void delete(Category category){
        entityManager.remove(entityManager.contains(category) ? category: entityManager.merge(category));
    }

    public List<Category> findAllCategories(){
        return entityManager.createQuery("SELECT c FROM Category c").getResultList();
    }

    public List<String> categoryNames(){
        return entityManager.createQuery("SELECT c.name FROM Category c").getResultList();
    }

}
