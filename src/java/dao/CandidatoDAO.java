package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Candidato;

public class CandidatoDAO {
    
   private static CandidatoDAO instance = new CandidatoDAO();
    
    public static CandidatoDAO getInstance() {
        return instance;
    }
    
    private CandidatoDAO(){
    }
    
    public void salvar (Candidato candidato) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(candidato);
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
    
    public void editar (Candidato candidato) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(candidato);
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
    
    public void excluir (Candidato candidato){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Candidato.class, candidato.getCodCandidato()));
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
    
    public Candidato obterCandidato(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Candidato candidato = null;
        try {
            tx.begin();
            candidato = em.find(Candidato.class, id);
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();    
            }  
            throw new RuntimeException(e);
        }finally{
         PersistenceUtil.close(em);
         return candidato;
        }
    } 
    
    public List<Candidato> obterCandidatos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Candidato> candidatos = null;
        try{
            tx.begin();
            TypedQuery<Candidato> query = em.createQuery("select c from Candidato c", Candidato.class);
            candidatos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
        return candidatos;
    }
}
