package com.fer.service;

import com.fer.model.Usuario;
import com.fer.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class UsuarioService {

    public void guardarUsuario(Usuario usuario) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }

        
    }
    
    public List<Usuario> listarUsuario() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            List<Usuario> listar=session.createQuery("from Usuario").list();
            session.getTransaction().commit();
            return listar;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
            return null;
        }
       
        
    }

}
