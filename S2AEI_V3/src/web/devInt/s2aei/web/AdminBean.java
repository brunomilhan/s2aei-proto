package web.devInt.s2aei.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;

import devInt.s2aei.admin.Admin;
import devInt.s2aei.admin.AdminBR;


@ManagedBean
@RequestScoped
public class AdminBean {
	
	private Admin admin = new Admin();
	private AdminBR adminBR = new AdminBR();
	private List<Admin> listAll;
	
	@PostConstruct
	public void construct() {

		listAll = this.adminBR.listAll();
	}

	public List<Admin> listAll() {
		return listAll;
	}

		
	public void delete(){
		try{			
			adminBR.delete(admin);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Excluido com sucesso!"));
			this.admin = new Admin();
		}catch(HibernateException e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possível deletar.",""));
			this.admin = new Admin();
		}
	}

	public void save(){
		try{
			adminBR.save(admin);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Cadastrado com sucesso!"));
			this.admin = new Admin();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possível, verifique se os dados estão corretos.",""));
		}
				
		
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
