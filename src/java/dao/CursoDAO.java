package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Curso;

public class CursoDAO {

     private static CursoDAO instance = new CursoDAO();
    
    public static CursoDAO getInstance() {
        return instance;
    }
    
    private CursoDAO(){
    }
    
    public void salvar (Curso curso) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(curso);
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
    
    public void editar (Curso curso) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(curso);
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
    
     public void excluir (Curso curso){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Curso.class, curso.getCodCurso()));
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
    
    public Curso obterCurso(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Curso curso = null;
        try {
            tx.begin();
            curso = em.find(Curso.class, id);
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();    
            }  
            throw new RuntimeException(e);
        }finally{
         PersistenceUtil.close(em);
         return curso;
        }
    } 
    
    public List<Curso> obterCursos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Curso> cursos = null;
        try{
            tx.begin();
            TypedQuery<Curso> query = em.createQuery("select c from Curso c", Curso.class);
            cursos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
        return cursos;
    }
}
