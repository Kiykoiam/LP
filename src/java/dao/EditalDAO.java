package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Edital;

public class EditalDAO {
    
    private static EditalDAO instance = new EditalDAO();
    
    public static EditalDAO getInstance() {
        return instance;
    }
    
    private EditalDAO(){
    }
    
    public void salvar (Edital edital) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(edital);
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
    
    public void editar (Edital edital) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(edital);
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
    
     public void excluir (Edital edital){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Edital.class, edital.getCodEdital()));
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
    
    public Edital obterEdital(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Edital edital = null;
        try {
            tx.begin();
            edital = em.find(Edital.class, id);
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();    
            }  
            throw new RuntimeException(e);
        }finally{
         PersistenceUtil.close(em);
         return edital;
        }
    } 
    
    public List<Edital> obterEditais() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Edital> editais = null;
        try{
            tx.begin();
            TypedQuery<Edital> query = em.createQuery("select e from Edital e", Edital.class);
            editais = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
        return editais;
    }
}
