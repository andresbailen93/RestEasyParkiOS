/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloddbb.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modeloddbb.Parkzone;

/**
 *
 * @author andresbailen93
 */
@Stateless
@Path("modeloddbb.parkzone")
public class ParkzoneFacadeREST extends AbstractFacade<Parkzone> {

    @PersistenceContext(unitName = "RestEasyParkPU")
    private EntityManager em;

    public ParkzoneFacadeREST() {
        super(Parkzone.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Parkzone entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public int edit(@PathParam("id") Long id, Parkzone entity) {
        
        if (entity.getOcupado() == 1) {
            List<Parkzone> lista_park = em.createNamedQuery("Parkzone.findByIdUserFree").setParameter("idPlaza", entity.getIdPlaza()).getResultList();
            if (lista_park.get(0).getOcupado() == 0) {
                super.edit(entity);
                return 0;
            } else {
                return -1;
            }
        } else {
            super.edit(entity);
            return 0;
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Parkzone> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Parkzone> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("findFree")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Parkzone> findFreeParkZone() {
        List<Parkzone> list_park = em.createNamedQuery("Parkzone.findByOcupado").setParameter("ocupado", 0).getResultList();
        return list_park;
    }

    @GET
    @Path("countCA")
    @Produces({MediaType.TEXT_PLAIN})
    public int countCarrefour() {
        List<Parkzone> list_park = em.createNamedQuery("Parkzone.findByCentrocomercial").setParameter("centrocomercial", "CARREFOUR").setParameter("ocupado", 0).getResultList();
        return list_park.size();
    }

    @GET
    @Path("countCI")
    @Produces({MediaType.TEXT_PLAIN})
    public int countCorteIngles() {
        List<Parkzone> list_park = em.createNamedQuery("Parkzone.findByCentrocomercial").setParameter("centrocomercial", "CORTEINGLES").setParameter("ocupado", 0).getResultList();
        return list_park.size();

    }

    @GET
    @Path("freeCA")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Parkzone> findFreeCarrefour() {
        List<Parkzone> list_park = em.createNamedQuery("Parkzone.findByCentrocomercial").setParameter("centrocomercial", "CARREFOUR").setParameter("ocupado", 0).getResultList();
        return list_park;

    }

    @GET
    @Path("freeCI")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Parkzone> findFreeCorteIngles() {
        List<Parkzone> list_park = em.createNamedQuery("Parkzone.findByCentrocomercial").setParameter("centrocomercial", "CORTEINGLES").setParameter("ocupado", 0).getResultList();
        return list_park;

    }

    @GET
    @Path("{idUsuario}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Parkzone> findUser(@PathParam("idUsuario") String idUser) {
        List<Parkzone> lista_parkzone = em.createNamedQuery("Parkzone.findByIdUsuario").setParameter("idUsuario", idUser).getResultList();
        return lista_parkzone;
    }

}
