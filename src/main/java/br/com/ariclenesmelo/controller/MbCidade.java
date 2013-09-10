
package br.com.ariclenesmelo.controller;

import br.com.ariclenesmelo.model.dao.HibernateDAO;
import br.com.ariclenesmelo.model.dao.InterfaceDAO;
import br.com.ariclenesmelo.model.entity.Cidade;
import br.com.ariclenesmelo.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean (name="mbCidade")
@SessionScoped

public class MbCidade implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade;
    private List<Cidade> cidades;

    public MbCidade() {
    }
    private InterfaceDAO<Cidade> cidadeDAO(){
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO;
    }
    
    public String limparCidade() {
        cidade = new Cidade();
        return "/restrict/cadastrarcidade.faces";
    }
    
    public String editCidade(){
        return "/restrict/cadastrarcidade.faces";
    }
    
    public String addCidade(){
        if(cidade.getIdCidade() == null || cidade.getIdCidade() == 0 ){
            insertCidade();
        }else {
            updateCidade();
        }
        
        limparCidade();
        return null;
    }
    
    private void insertCidade() {
        cidadeDAO().save(cidade);
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,"Gravação efetuada com Sucesso",""));
    }

    private void updateCidade() {
        cidadeDAO().update(cidade);
        FacesContext.getCurrentInstance().addMessage(null,
             new FacesMessage(FacesMessage.SEVERITY_INFO,"Atualização efetuada com Sucesso",""));
    }

      public void deleteCidade() {
        cidadeDAO().remove(cidade);
        FacesContext.getCurrentInstance().addMessage(null,
             new FacesMessage(FacesMessage.SEVERITY_INFO,"Exclusão efetuada com Sucesso",""));
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        cidades = cidadeDAO().getEntities();
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
}
