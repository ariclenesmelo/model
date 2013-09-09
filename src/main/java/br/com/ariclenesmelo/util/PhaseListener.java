
package br.com.ariclenesmelo.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.hibernate.Session;

public class PhaseListener implements javax.faces.event.PhaseListener{


        //Antes da Fase
    @Override
    public void beforePhase(PhaseEvent event) {
        if (event.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            System.out.println("Antes da Fase: " + getPhaseId());
            Session session = HibernateUtil.getSession_factory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);            
        }
    }
    
    //Depois da Fase
    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("Depois da Fase: " + getPhaseId());
        if(event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)){
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if(session.getTransaction().isActive()){
                   session.getTransaction().rollback();
                }
            }finally {
                session.close();
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
