/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fastchoice.bean;

import br.com.fastchoice.DAO.EstabelecimentoDAO;
import br.com.fastchoice.entity.Estabelecimento;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author David
 */
@ManagedBean
@SessionScoped
public class EstabelecimentosBean {

    private Estabelecimento estabelecimento = new Estabelecimento();
    public EstabelecimentoDAO estabelecimentoDao = new EstabelecimentoDAO();
    List<Estabelecimento> listaEstabelecimentos;
    
    
    public List listaEstabelecimentos(){
      listaEstabelecimentos =  estabelecimentoDao.getList();
      return this.listaEstabelecimentos;
    }
    
    public EstabelecimentosBean() {
    
    }
    
    public String adicionarEstabelecimento (){
       estabelecimentoDao.adicionarEstabelecimento(estabelecimento);
       estabelecimento.setUsuario(null);
       estabelecimento.setEmail(null);
       estabelecimento.setSenha(null);
       estabelecimento.setConfSenha(null);
        return "cadastroUsuario";
    }

     public String removerEstabelecimento (Estabelecimento es){
       this.estabelecimento = es;
       estabelecimentoDao.removerEstabelecimento(this.estabelecimento);
       this.estabelecimento.setUsuario("");
       this.estabelecimento.setEmail("");
       this.estabelecimento.setSenha("");
       this.estabelecimento.setConfSenha("");
       return "cadastroUsuario";
    }
     
    /**
     *
     * @param c
     * @return
     */
    
     public String atualizarEstabelecimento(){
         estabelecimentoDao.editarEstabelecimento(estabelecimento);
         estabelecimento.setUsuario(null);
         estabelecimento.setEmail(null);
         estabelecimento.setSenha(null);
         estabelecimento.setConfSenha(null);
         return "cadastroUsuario";
     }
     
     public String carregarEstabelecimento(Estabelecimento es){
        this.estabelecimento = es;
         return "editarUsuario";
         
        }
     
    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.estabelecimento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EstabelecimentosBean other = (EstabelecimentosBean) obj;
        if (!Objects.equals(this.estabelecimento, other.estabelecimento)) {
            return false;
        }
        return true;
    }
    
}