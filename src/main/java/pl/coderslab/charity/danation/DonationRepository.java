package pl.coderslab.charity.danation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class DonationRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Donation donation){
        entityManager.persist(donation);
    }

    public Donation find(long id){
        return entityManager.find(Donation.class ,id);
    }


    public void update(Donation donation){
        entityManager.merge(donation);
    }

    public void delete(Donation donation){
        entityManager.remove(entityManager.contains(donation) ? donation: entityManager.merge(donation));
    }

    public List<Donation> findAllDonations() {
        return entityManager.createQuery("SELECT d FROM Donation d").getResultList();
    }

    public BigDecimal quantityOfBags(){
        Query query = entityManager.createNativeQuery("SELECT sum(quantity) from donation");
        List<BigDecimal> integers = query.getResultList();
        return integers.get(0);
    }
}
