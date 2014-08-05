package com.thomas.inmueble.repositorios;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Repositorio<T> extends HibernateDaoSupport implements IRepositorio<T>{
	
	Session sesn=null;
	@Override
	public List<T> get(Class<T> tipo) {
		
		if(sesn==null||!sesn.isOpen()){
			sesn=getSessionFactory().getCurrentSession();			
		}
		
		Query q=sesn.createQuery("from "+tipo.getName());
		List<T> ls=(List<T>)q.list();
		return ls;
	}

	@Override
	public T get(Class<T> tipo, int id) {
		
		if(sesn==null||!sesn.isOpen()){
		sesn=getSessionFactory().getCurrentSession();
		}
		T obj=(T)sesn.get(tipo, id);
		return obj;
	}

	@Override
	public void add(T objeto) {
		
		if(sesn==null||!sesn.isOpen()){
		sesn=getSessionFactory().getCurrentSession();
		}
		sesn.save(objeto);
		
	}

	@Override
	public void delete(T objeto) {
		
		if(sesn==null||!sesn.isOpen()){
		sesn=getSessionFactory().getCurrentSession();
		}
		sesn.delete(objeto);
		
	}

	@Override
	public void update(T objeto) {
		
		if(sesn==null||!sesn.isOpen()){
		sesn=getSessionFactory().getCurrentSession();
		}
		sesn.update(objeto);
		
	}

	@Override
	public List<T> find(String consulta, Map<String, Object> params) {
		
		if(sesn==null||!sesn.isOpen()){
		sesn=getSessionFactory().getCurrentSession();
		}
		Query q=sesn.getNamedQuery(consulta);
		for(String param : params.keySet()){
			q.setParameter(param, params.get(param));
		}
		List<T> ls=q.list();
		return ls;
	}
	

}
