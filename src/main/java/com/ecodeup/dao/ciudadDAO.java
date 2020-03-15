package com.ecodeup.dao;


	
	import java.util.List;

	import javax.persistence.EntityManager;

	import com.ecodeup.app.JPAUtil;
	import com.ecodeup.model.ciudad;

public class ciudadDAO {
	
		private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		private List<ciudad> listaciudad;

		public void Registrar(ciudad  mciudad) {
			entity.getTransaction().begin();
			entity.persist(mciudad);
			entity.getTransaction().commit();
		}
		
		public void Actualizar(ciudad mciudad) {
			entity.getTransaction().begin();
			entity.merge( mciudad);
			entity.getTransaction().commit();
		}
		
		public void Eliminar(ciudad mciudad) {
			
			mciudad = entity.find(ciudad.class,  mciudad.getIdciudad());
			entity.getTransaction().begin();
			entity.remove(mciudad);
			entity.getTransaction().commit();
			
		}
		
		public List< ciudad> Listar(){
			
					
			return listaciudad;
		}

}
