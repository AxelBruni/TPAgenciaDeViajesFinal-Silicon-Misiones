/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.ServicioTuristico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.PaqueteTuristico;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author axelb
 */
public class PaqueteTuristicoJpaController implements Serializable {

    public PaqueteTuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public PaqueteTuristicoJpaController () {
        emf = Persistence.createEntityManagerFactory("TPAgenciaDeViajesPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PaqueteTuristico paqueteTuristico) {
        if (paqueteTuristico.getServiciosIncluidos() == null) {
            paqueteTuristico.setServiciosIncluidos(new ArrayList<ServicioTuristico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<ServicioTuristico> attachedServiciosIncluidos = new ArrayList<ServicioTuristico>();
            for (ServicioTuristico serviciosIncluidosServicioTuristicoToAttach : paqueteTuristico.getServiciosIncluidos()) {
                serviciosIncluidosServicioTuristicoToAttach = em.getReference(serviciosIncluidosServicioTuristicoToAttach.getClass(), serviciosIncluidosServicioTuristicoToAttach.getCodigoServicio());
                attachedServiciosIncluidos.add(serviciosIncluidosServicioTuristicoToAttach);
            }
            paqueteTuristico.setServiciosIncluidos(attachedServiciosIncluidos);
            em.persist(paqueteTuristico);
            for (ServicioTuristico serviciosIncluidosServicioTuristico : paqueteTuristico.getServiciosIncluidos()) {
                serviciosIncluidosServicioTuristico.getPaquete().add(paqueteTuristico);
                serviciosIncluidosServicioTuristico = em.merge(serviciosIncluidosServicioTuristico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PaqueteTuristico paqueteTuristico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaqueteTuristico persistentPaqueteTuristico = em.find(PaqueteTuristico.class, paqueteTuristico.getCodigoPaquete());
            ArrayList<ServicioTuristico> serviciosIncluidosOld = persistentPaqueteTuristico.getServiciosIncluidos();
            ArrayList<ServicioTuristico> serviciosIncluidosNew = paqueteTuristico.getServiciosIncluidos();
            ArrayList<ServicioTuristico> attachedServiciosIncluidosNew = new ArrayList<ServicioTuristico>();
            for (ServicioTuristico serviciosIncluidosNewServicioTuristicoToAttach : serviciosIncluidosNew) {
                serviciosIncluidosNewServicioTuristicoToAttach = em.getReference(serviciosIncluidosNewServicioTuristicoToAttach.getClass(), serviciosIncluidosNewServicioTuristicoToAttach.getCodigoServicio());
                attachedServiciosIncluidosNew.add(serviciosIncluidosNewServicioTuristicoToAttach);
            }
            serviciosIncluidosNew = attachedServiciosIncluidosNew;
            paqueteTuristico.setServiciosIncluidos(serviciosIncluidosNew);
            paqueteTuristico = em.merge(paqueteTuristico);
            for (ServicioTuristico serviciosIncluidosOldServicioTuristico : serviciosIncluidosOld) {
                if (!serviciosIncluidosNew.contains(serviciosIncluidosOldServicioTuristico)) {
                    serviciosIncluidosOldServicioTuristico.getPaquete().remove(paqueteTuristico);
                    serviciosIncluidosOldServicioTuristico = em.merge(serviciosIncluidosOldServicioTuristico);
                }
            }
            for (ServicioTuristico serviciosIncluidosNewServicioTuristico : serviciosIncluidosNew) {
                if (!serviciosIncluidosOld.contains(serviciosIncluidosNewServicioTuristico)) {
                    serviciosIncluidosNewServicioTuristico.getPaquete().add(paqueteTuristico);
                    serviciosIncluidosNewServicioTuristico = em.merge(serviciosIncluidosNewServicioTuristico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paqueteTuristico.getCodigoPaquete();
                if (findPaqueteTuristico(id) == null) {
                    throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaqueteTuristico paqueteTuristico;
            try {
                paqueteTuristico = em.getReference(PaqueteTuristico.class, id);
                paqueteTuristico.getCodigoPaquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.", enfe);
            }
            ArrayList<ServicioTuristico> serviciosIncluidos = paqueteTuristico.getServiciosIncluidos();
            for (ServicioTuristico serviciosIncluidosServicioTuristico : serviciosIncluidos) {
                serviciosIncluidosServicioTuristico.getPaquete().remove(paqueteTuristico);
                serviciosIncluidosServicioTuristico = em.merge(serviciosIncluidosServicioTuristico);
            }
            em.remove(paqueteTuristico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities() {
        return findPaqueteTuristicoEntities(true, -1, -1);
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities(int maxResults, int firstResult) {
        return findPaqueteTuristicoEntities(false, maxResults, firstResult);
    }

    private List<PaqueteTuristico> findPaqueteTuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        
        String queryStringServHab = "SELECT * FROM `paquetes` WHERE habilitado=1";
        
        
        List<PaqueteTuristico> listaPaquete = null;
            try {

                listaPaquete = em.createNativeQuery(queryStringServHab, 
             PaqueteTuristico.class)
                        .getResultList();
            } catch (Exception ex) {

            }

            if (listaPaquete  == null) {
                listaPaquete  = new ArrayList<>();
            }

            return listaPaquete ;
    }

    public PaqueteTuristico findPaqueteTuristico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PaqueteTuristico.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteTuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PaqueteTuristico> rt = cq.from(PaqueteTuristico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
