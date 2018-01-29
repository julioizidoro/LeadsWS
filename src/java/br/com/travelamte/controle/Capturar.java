/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.controle;

import br.com.travelamte.facade.AvisosFacade;
import br.com.travelamte.facade.ClienteFacade;
import br.com.travelamte.facade.HistoricoFacade;
import br.com.travelamte.facade.LeadFacade;
import br.com.travelamte.facade.LeadResponsavelFacade;
import br.com.travelamte.facade.UnidadeFacade;
import br.com.travelamte.facade.UsuarioFacade;
import br.com.travelamte.model.Avisos;
import br.com.travelamte.model.Avisousuario;
import br.com.travelamte.model.Cliente;
import br.com.travelamte.model.Lead;
import br.com.travelamte.model.Leadhistorico;
import br.com.travelamte.model.Leadresponsavel;
import br.com.travelamte.model.Leads;
import br.com.travelamte.model.Parametroslead;
import br.com.travelamte.model.Unidadenegocio;
import br.com.travelamte.model.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Wolverine
 */
public class Capturar {
    
    private boolean jaecliente;
    List<Leadresponsavel> listaLeadResponsavel;
    //private Parametroslead parametrosLead;
    
   /// public void carregarParametrosLead(){
  //      ParametrosLeadFacade parametrosLeadFacade = new ParametrosLeadFacade();
  //      parametrosLead = parametrosLeadFacade.get();
 //   }
    
    public void carregarListaResponsavel(int idUnidade){
        LeadResponsavelFacade leadResponsavelFacade = new LeadResponsavelFacade();
        if (idUnidade==0){
            idUnidade=6;
        }
        listaLeadResponsavel = leadResponsavelFacade.list(idUnidade);
    }

    public Unidadenegocio getUnidade(int idUnidade){
        UnidadeFacade unidadeFacade = new UnidadeFacade();
        return unidadeFacade.getUnidade(idUnidade); 
    }
    
    public int getUsuario(Unidadenegocio unidade) {
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        int idUsuario = 0;
        List<Usuario> listaUsuairo = usuarioFacade.consultar(unidade.getIdunidadeNegocio());
        if (listaUsuairo != null) {
            int contador = 0;
            idUsuario = unidade.getUsuarioleadautomatica();
            for (int i = 0; i < listaUsuairo.size(); i++) {
                if (listaUsuairo.get(i).getIdusuario() == idUsuario) {
                    contador = i;
                    i = 10000;
                }
            }
            if (contador >= (listaUsuairo.size() - 1)) {
                contador = 0;
            } else {
                contador++;
            }
            unidade.setUsuarioleadautomatica(listaUsuairo.get(contador).getIdusuario());
            UnidadeFacade unidadeFacade = new UnidadeFacade();
            unidadeFacade.salvar(unidade);
        }
        return idUsuario;
    }
    
    
    public void salvarLeads(Leads contato){
        //carregarParametrosLead();
        carregarListaResponsavel(contato.getUnidade());
        Unidadenegocio unidade = getUnidade(contato.getUnidade());
        jaecliente = true;
        Cliente cliente = salvarCliente(contato);
        Lead lead = new Lead();
        LeadFacade leadFacede = new LeadFacade();
        boolean lancarHistorico = false;
        if (jaecliente){
            lead = leadFacede.getLead(cliente.getIdcliente());
            lancarHistorico = true;
        }else{
            lead = null;
        }
        if (lead == null) {
            lead = new Lead();
            lead.setCliente(cliente.getIdcliente());
            lead.setJaecliente(jaecliente);
            lead.setNotas(contato.getMensagem());
            lead.setProdutos(21);
            lead.setSituacao(1);
            lead.setTipocontato(1);
            lead.setPais(5);
            lead.setPublicidade(11);
            lead.setUnidadenegocio(contato.getUnidade());
            lead.setMotivocancelamento1(1);
            lead.setDatarecebimento(new Date());
            lead.setHorarecebimento(formatarHoraString());
            lead.setUrlclient(contato.getUrlclient());
            int idUsuario =0;
            if (unidade.isLeadautomatica()){
                idUsuario = getUsuario(unidade);
                lead.setUsuario(idUsuario);
                lead.setDataenvio(new Date());
            }else {
                if (listaLeadResponsavel!=null){
                    lead.setUsuario(listaLeadResponsavel.get(0).getUsuario());
                }
            }
            lead.setIdcontrole(contato.getId());
            lead = leadFacede.salvar(lead);
            listaResponsavelUnidade(unidade.getIdunidadeNegocio(), idUsuario, cliente);
        }else if (lancarHistorico){
            lancarHistoricoLead(lead, contato);
        }       
    }
    
    public Cliente salvarCliente(Leads contato){
        ClienteFacade clienteFacade = new ClienteFacade();
        Cliente cliente = clienteFacade.consultarEmail(contato.getEmail());
        if (cliente==null){
            jaecliente=false;
            cliente = new Cliente();
            cliente.setNome(contato.getNome());
            cliente.setEmail(contato.getEmail());
            cliente.setDataCadastro(new Date());
            cliente.setFoneCelular(formatTelefone(contato.getTelefone()));
            cliente.setTipoCliente("FollowUp");
            cliente.setPublicidade(11);
            if (contato.getUnidade()==0){
                cliente.setUnidadenegocio(6);
            }else cliente.setUnidadenegocio(contato.getUnidade());
            
            cliente = clienteFacade.salvar(cliente);
        }
        return cliente;
    } 
    
    public String formatTelefone(String fone){
        String novoFone ="";
        int tamanho = fone.length();
        for(int i=0;i<tamanho;i++){
            if (fone.charAt(i)!=' '){
                if (fone.charAt(i)=='-'){
                    i++;
                    novoFone = novoFone + fone.charAt(i) + "-";
                }else {
                    novoFone = novoFone + fone.charAt(i);
                }
            }
        }
        return novoFone;
    }
    
    public String formatarHoraString() {
	DateFormat formato = new SimpleDateFormat("HH:mm:ss");
	String formattedDate = formato.format(new Date());
	return formattedDate;
    }
    
    public void lancarHistoricoLead(Lead lead, Leads contato){
        Leadhistorico historico = new Leadhistorico();
        historico.setCliente(lead.getCliente());
        historico.setDatahistorico(new Date());
        historico.setHistorico("Nova solictação do cliente via fale conosco para unidade " + contato.getUnidade_desc());
        historico.setTipocontato(1);
        HistoricoFacade historicoFacade = new HistoricoFacade();
        historicoFacade.salvar(historico);
    }
    
    public void listaResponsavelUnidade(int unidade, int usuario, Cliente cliente){
        if (usuario==0){
            if (listaLeadResponsavel!=null){
                Avisos aviso = criarAviso(unidade, cliente);
                for(int i=0;i<listaLeadResponsavel.size();i++){
                    criarAvisoUsuario(aviso, listaLeadResponsavel.get(i).getUsuario());
                }
            }
        }else {
            Avisos aviso = criarAviso(unidade, cliente);
            criarAvisoUsuario(aviso, usuario);
        }
    }
    
    public Avisos criarAviso(int unidade, Cliente cliente){
        Avisos aviso  = new Avisos();
        aviso.setData(new Date());
        aviso.setIdunidade(unidade);
        aviso.setImagem("lead");
        aviso.setLiberar(false);
        aviso.setTexto("Novo Lead recebido do Fale Conosco cliente " + cliente.getNome() );
        aviso.setUsuario(1);
        aviso.setLiberar(true);
        AvisosFacade avisosFacade = new AvisosFacade();
        aviso = avisosFacade.salvar(aviso);
        return aviso;
    }
    
    public void criarAvisoUsuario(Avisos aviso, int idusuario){
        Avisousuario avisoUsuario = new Avisousuario();
        avisoUsuario.setAvisos(aviso.getIdavisos());
        avisoUsuario.setUsuario(idusuario);
        avisoUsuario.setVisto(false);
        AvisosFacade avisosFacade = new AvisosFacade();
        avisosFacade.salvar(avisoUsuario);
    }
    
}
