package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Funcionario;

public class FuncionarioDAO {

    private static FuncionarioDAO instance = new FuncionarioDAO();
    
    public static FuncionarioDAO getInstance() {
        return instance;
    }
    
    private FuncionarioDAO(){
    }
    
    public void salvar (Funcionario funcionario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(funcionario);
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
    
    public void editar (Funcionario funcionario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(funcionario);
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
    
    public void excluir (Funcionario funcionario){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Funcionario.class, funcionario.getCodFuncionario()));
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
    
    public Funcionario obterFuncionario(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Funcionario funcionario = null;
        try {
            tx.begin();
            funcionario = em.find(Funcionario.class, id);
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();    
            }  
            throw new RuntimeException(e);
        }finally{
         PersistenceUtil.close(em);
         return funcionario;
        }
    } 
    
    public List<Funcionario> obterFuncionarios() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Funcionario> funcionarios = null;
        try{
            tx.begin();
            TypedQuery<Funcionario> query = em.createQuery("select f from Funcionario f", Funcionario.class);
            funcionarios = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally{
            PersistenceUtil.close(em);
        }
        return funcionarios;
    }
}


