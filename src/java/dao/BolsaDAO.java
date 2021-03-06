package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Bolsa;

public class BolsaDAO {
    private static BolsaDAO instance = new BolsaDAO();
    
    public static BolsaDAO getInstance() {
        return instance;
    }
    
    private BolsaDAO(){
    }
    
    public void salvar (Bolsa bolsa) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(bolsa);
            tx.commit();
        } catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
    }
    
    public void editar (Bolsa bolsa) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(bolsa);
            tx.commit();
        } catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
    }
    
    public void excluir (Bolsa bolsa){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Bolsa.class, bolsa.getCodBolsa()));
            tx.commit();
        }catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
    }
    
    public Bolsa obterBolsa(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Bolsa bolsa = null;
        try {
            tx.begin();
            bolsa = em.find(Bolsa.class, id);
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();    
            }  
            throw new RuntimeException(e);
        }finally{
         PersistenceUtil.close(em);
         return bolsa;
        }
    } 
    
    public List<Bolsa> obterBolsas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Bolsa> bolsas = null;
        try{
            tx.begin();
            TypedQuery<Bolsa> query = em.createQuery("select b from Bolsa b", Bolsa.class);
            bolsas = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
        return bolsas;
    }
}
