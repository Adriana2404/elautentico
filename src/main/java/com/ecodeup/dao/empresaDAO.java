package com.ecodeup.dao;

	import java.util.List;

	import javax.persistence.EntityManager;

	import com.ecodeup.app.JPAUtil;
	import com.ecodeup.model.empresa;

	public class empresaDAO {

		private List<empresa> listaempresa;
		private EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		public void Registrar(empresa mempresa) {
			entity.getTransaction().begin();
			entity.persist(mempresa);
			entity.getTransaction().commit();
		}
		
		public void Actualizar(empresa mempresa) {
			entity.getTransaction().begin();
			entity.merge( mempresa);
			entity.getTransaction().commit();
		}
		
		public void Eliminar(empresa mempresa) {
			
			mempresa = entity.find(empresa.class,  mempresa.getIdemp());
			entity.getTransaction().begin();
			entity.remove(mempresa);
			entity.getTransaction().commit();
			
		}
		
		public List< empresa> Listar(){
			
					
			return listaempresa;
		}
}
