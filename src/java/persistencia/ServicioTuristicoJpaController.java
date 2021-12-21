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
import logica.PaqueteTuristico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import logica.ServicioTuristico;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author axelb
 */
public class ServicioTuristicoJpaController implements Serializable {

    public ServicioTuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ServicioTuristicoJpaController () {
        emf = Persistence.createEntityManagerFactory("TPAgenciaDeViajesPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ServicioTuristico servicioTuristico) {
        if (servicioTuristico.getPaquete() == null) {
            servicioTuristico.setPaquete(new ArrayList<PaqueteTuristico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<PaqueteTuristico> attachedPaquete = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico paquetePaqueteTuristicoToAttach : servicioTuristico.getPaquete()) {
                paquetePaqueteTuristicoToAttach = em.getReference(paquetePaqueteTuristicoToAttach.getClass(), paquetePaqueteTuristicoToAttach.getCodigoPaquete());
                attachedPaquete.add(paquetePaqueteTuristicoToAttach);
            }
            servicioTuristico.setPaquete(attachedPaquete);
            em.persist(servicioTuristico);
            for (PaqueteTuristico paquetePaqueteTuristico : servicioTuristico.getPaquete()) {
                paquetePaqueteTuristico.getServiciosIncluidos().add(servicioTuristico);
                paquetePaqueteTuristico = em.merge(paquetePaqueteTuristico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ServicioTuristico servicioTuristico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ServicioTuristico persistentServicioTuristico = em.find(ServicioTuristico.class, servicioTuristico.getCodigoServicio());
            ArrayList<PaqueteTuristico> paqueteOld = persistentServicioTuristico.getPaquete();
            ArrayList<PaqueteTuristico> paqueteNew = servicioTuristico.getPaquete();
            ArrayList<PaqueteTuristico> attachedPaqueteNew = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico paqueteNewPaqueteTuristicoToAttach : paqueteNew) {
                paqueteNewPaqueteTuristicoToAttach = em.getReference(paqueteNewPaqueteTuristicoToAttach.getClass(), paqueteNewPaqueteTuristicoToAttach.getCodigoPaquete());
                attachedPaqueteNew.add(paqueteNewPaqueteTuristicoToAttach);
            }
            paqueteNew = attachedPaqueteNew;
            servicioTuristico.setPaquete(paqueteNew);
            servicioTuristico = em.merge(servicioTuristico);
            for (PaqueteTuristico paqueteOldPaqueteTuristico : paqueteOld) {
                if (!paqueteNew.contains(paqueteOldPaqueteTuristico)) {
                    paqueteOldPaqueteTuristico.getServiciosIncluidos().remove(servicioTuristico);
                    paqueteOldPaqueteTuristico = em.merge(paqueteOldPaqueteTuristico);
                }
            }
            for (PaqueteTuristico paqueteNewPaqueteTuristico : paqueteNew) {
                if (!paqueteOld.contains(paqueteNewPaqueteTuristico)) {
                    paqueteNewPaqueteTuristico.getServiciosIncluidos().add(servicioTuristico);
                    paqueteNewPaqueteTuristico = em.merge(paqueteNewPaqueteTuristico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = servicioTuristico.getCodigoServicio();
                if (findServicioTuristico(id) == null) {
                    throw new NonexistentEntityException("The servicioTuristico with id " + id + " no longer exists.");
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
            ServicioTuristico servicioTuristico;
            try {
                servicioTuristico = em.getReference(ServicioTuristico.class, id);
                servicioTuristico.getCodigoServicio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicioTuristico with id " + id + " no longer exists.", enfe);
            }
            ArrayList<PaqueteTuristico> paquete = servicioTuristico.getPaquete();
            for (PaqueteTuristico paquetePaqueteTuristico : paquete) {
                paquetePaqueteTuristico.getServiciosIncluidos().remove(servicioTuristico);
                paquetePaqueteTuristico = em.merge(paquetePaqueteTuristico);
            }
            em.remove(servicioTuristico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ServicioTuristico> findServicioTuristicoEntities() {
        return findServicioTuristicoEntities(true, -1, -1);
    }

    public List<ServicioTuristico> findServicioTuristicoEntities(int maxResults, int firstResult) {
        return findServicioTuristicoEntities(false, maxResults, firstResult);
    }

    private List<ServicioTuristico> findServicioTuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        
        String queryStringServHab = "SELECT * FROM `servicios` WHERE habilitado=1";
        
        
        List<ServicioTuristico> listaServicios = null;
            try {

                listaServicios = em.createNativeQuery(queryStringServHab, 
             ServicioTuristico.class)
                        .getResultList();
            } catch (Exception ex) {

            }

            if (listaServicios  == null) {
                listaServicios  = new ArrayList<>();
            }

            return listaServicios ;

}
    
   

    public ServicioTuristico findServicioTuristico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ServicioTuristico.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioTuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ServicioTuristico> rt = cq.from(ServicioTuristico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
