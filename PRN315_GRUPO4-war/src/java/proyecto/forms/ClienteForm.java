/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.forms;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import proyecto.ejb.ClienteFacadeLocal;
import proyecto.entidades.Cliente;
import static proyecto.entidades.Cliente_.clienteId;

/**
 *
 * @author Miguel Hernández
 */
@ManagedBean
@Named(value = "clienteForm")
@SessionScoped
public class ClienteForm implements Serializable {


    public ClienteForm() {
    }
private ClienteFacadeLocal clienteFacadeLocal;
private Cliente cliente;
private List<Cliente> clientes;
    
    @PostConstruct
    public void init(){
    try{
   cliente = new Cliente();
  
  String clienteIdParam = FacesContext.getCurrentInstance()
          .getExternalContext().getRequestParameterMap().get("cliente_id");
  if (clienteIdParam != null){
      Long actividadTuristicaId = Long.parseLong(clienteIdParam);
      cliente = clienteFacadeLocal.find(clienteId);
  }
    this.clientes = clienteFacadeLocal.findAll();
  
    }catch(Exception e){
    
    }
    
 }
    
     public void create() throws IOException {
    clienteFacadeLocal.create(cliente);
    FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
    FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Registro creado."));
    FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
 }
     public void edit() throws IOException {
     clienteFacadeLocal.edit(cliente);
       FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
    FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Registro actualizado."));
    FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
 }
     public void delete() throws IOException{
      clienteFacadeLocal.remove(cliente);
       FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
    FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Registro eliminado."));
    FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
 }
      public List<Cliente> getClientes(){
      return clientes;
 }
 
    public Cliente getCliente(){
    return cliente;
    }
    
    public void setCliente(Cliente cliente){
    this.cliente=cliente;
    
    }
    
}
