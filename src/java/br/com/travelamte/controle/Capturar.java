/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.controle;

import br.com.travelamte.facade.AvisosFacade;
import br.com.travelamte.facade.ClienteFacade;
import br.com.travelamte.facade.HistoricoFacade;
import br.com.travelamte.facade.ImportleadFacade;
import br.com.travelamte.facade.LeadFacade;
import br.com.travelamte.facade.LeadResponsavelFacade;
import br.com.travelamte.facade.PaisFacade;
import br.com.travelamte.facade.PublicidadeFacade;
import br.com.travelamte.facade.UnidadeFacade;
import br.com.travelamte.facade.UsuarioFacade;
import br.com.travelamte.model.Avisos;
import br.com.travelamte.model.Avisousuario;
import br.com.travelamte.model.Cliente;
import br.com.travelamte.model.Importlead;
import br.com.travelamte.model.Lead;
import br.com.travelamte.model.Leadblog;
import br.com.travelamte.model.Leadbot;
import br.com.travelamte.model.Leadhistorico;
import br.com.travelamte.model.Leadresponsavel;
import br.com.travelamte.model.Leads;
import br.com.travelamte.model.Pais;
import br.com.travelamte.model.Publicidade;
import br.com.travelamte.model.Unidadenegocio;
import br.com.travelamte.model.Usuario;
import com.sun.accessibility.internal.resources.accessibility;
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
        List<Usuario> listaUsuairo = usuarioFacade.consultar(unidade.getIdws());
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
        Cliente cliente = salvarCliente(contato.getNome(), contato.getEmail(), contato.getTelefone(), contato.getUnidade(), 11, "FC");
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
            lead.setCaptacao("Fale conosco/Site");
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
            listaResponsavelUnidade(unidade.getIdws(), idUsuario, cliente);
        }else if (lancarHistorico){
            lancarHistoricoLead(lead, contato.getUnidade_desc());
        }       
    }
    
    public Lead salvarLeadBlog(Leadblog contato){
        //carregarParametrosLead();
        carregarListaResponsavel(6);
        Unidadenegocio unidade = getUnidade(6);
        jaecliente = true;
        Cliente cliente = salvarCliente(contato.getNome(), contato.getEmail(), contato.getTelefone(), 6, 13, "blog");
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
            String nota = "Cidade : " + contato.getCidade() + "/" + contato.getEstado() + "\b\n";
            nota = nota + "Destinos : ";
            if (contato.getListaPais()!=null){
                for(int i=0;i<contato.getListaPais().size();i++){
                    nota = nota + contato.getListaPais().get(i) + " - ";
                }
            }
            nota = nota + "\b\n";
            nota = nota + "Tipo de intercâmbio : " + contato.getTipoIntercambio() + "\b\n";
            nota = nota + "Idade do intercambista : " + contato.getIdade() + "\b\n";
            nota = nota + "Objetivo : " + contato.getObjetivo() + "\b\n";
            nota = nota + "Duração : " + contato.getDuracao() + "\b\n";
            nota = nota + "Quando pretende viajar : " + contato.getQuandoviajar() + "\b\n";
            nota = nota + " Detalhe :" + contato.getDetalhe() + "\b\n";
            
            
            
            lead.setNotas(nota);
            lead.setProdutos(21);
            lead.setSituacao(1);
            lead.setTipocontato(1);
            lead.setPais(5);
            lead.setPublicidade(13);
            lead.setCaptacao("Intercâmbio e Viagem");
            lead.setUnidadenegocio(6);
            lead.setMotivocancelamento1(1);
            lead.setDatarecebimento(new Date());
            lead.setHorarecebimento(formatarHoraString());
            lead.setUrlclient("");
            if (listaLeadResponsavel!=null){
                lead.setUsuario(listaLeadResponsavel.get(0).getUsuario());
            }
            lead.setIdcontrole(0);
            lead = leadFacede.salvar(lead);
            listaResponsavelUnidade(6, 212, cliente);
        }else if (lancarHistorico){
            lancarHistoricoLead(lead, "Matriz");
        }    
        return lead;
    }
    
    public Lead salvarLeadBot(Leadbot contato){
        int idpublicidade = getPublicidade(contato.getComoficousabendo());
        Unidadenegocio unidade = null;
        if (contato.getUnidadetravelmate()!=null){
            if (contato.getUnidadetravelmate().length()>0){
                UnidadeFacade unidadeFacade = new UnidadeFacade();
                unidade = unidadeFacade.getUnidade(contato.getUnidadetravelmate());
            }
        }
        if (unidade!=null){
            carregarListaResponsavel(unidade.getIdws());
        }else {
            UnidadeFacade unidadeFacade = new UnidadeFacade();
            unidade = unidadeFacade.getUnidade(6);
            carregarListaResponsavel(6);
        }
        jaecliente = true;
        Cliente cliente = salvarCliente(contato.getName(), contato.getEmail(), contato.getTelefone(), unidade.getIdws(), idpublicidade, "Bot");
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
            if (contato.getMotivodaviagem().equalsIgnoreCase("Estudar")){
                lead = motivoViagemEstudar(lead, contato);
            }else if (contato.getMotivodaviagem().equalsIgnoreCase("Trabalhar")){
                lead = motivoViagemTrabalho(lead, contato);
            }else if (contato.getMotivodaviagem().equalsIgnoreCase("Tenho outras duvídas")){
                lead = motivoViagemEstudoTrabalho(lead, contato);
            }else {
                lead = motivoViagemEstudoTrabalho(lead, contato);
            }
            String notas = "";
            if (contato.getAlgumaduvida().length()>0){
                notas = notas + contato.getAlgumaduvida() + " ";
            }
            if (contato.getDuvidafim().length()>0){
                notas = notas + contato.getDuvidafim() + " ";
            }
            lead.setNotas(notas);
            lead.setSituacao(1);
            lead.setTipocontato(1);
            lead.setCaptacao("Chatbot");
            lead.setPublicidade(idpublicidade);
            lead.setUnidadenegocio(unidade.getIdws());
            lead.setMotivocancelamento1(1);
            lead.setDatarecebimento(new Date());
            lead.setHorarecebimento(formatarHoraString());
            lead.setUrlclient("bot");
            if (listaLeadResponsavel!=null){
                lead.setUsuario(listaLeadResponsavel.get(0).getUsuario());
            }
            lead.setIdcontrole(0);
            lead = leadFacede.salvar(lead);
            listaResponsavelUnidade(unidade.getIdws(), 0, cliente);
        }else if (lancarHistorico){
            lancarHistoricoLead(lead, contato.getUnidadetravelmate());
        }    
        return lead;
    }
    
    public Cliente salvarCliente(String nome, String email, String telefone, int unidade, int idPrublicidade, String tipoFone){
        ClienteFacade clienteFacade = new ClienteFacade();
        Cliente cliente = clienteFacade.consultarEmail(email);
        if (cliente==null){
            jaecliente=false;
            cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setDataCadastro(new Date());
            if (tipoFone.equalsIgnoreCase("FC")){
                cliente.setFoneCelular(formatTelefoneFC(telefone));
            }else if (tipoFone.equalsIgnoreCase("Blog")){
                cliente.setFoneCelular(formatTelefoneBlog(telefone));
            }else if (tipoFone.equalsIgnoreCase("Bot")){
                cliente.setFoneCelular(formatTelefoneBot(telefone));
            }else if (tipoFone.equalsIgnoreCase("Excel")){
                cliente.setFoneCelular(formatTelefoneExcel(telefone));
            }
            
            cliente.setTipoCliente("FollowUp");
            cliente.setPublicidade(idPrublicidade);
            if (unidade==0){
                cliente.setUnidadenegocio(6);
            }else cliente.setUnidadenegocio(unidade);
            
            cliente = clienteFacade.salvar(cliente);
        }
        return cliente;
    } 
    
    public String formatTelefoneFC(String fone){
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
    
    public String formatTelefoneBlog(String fone) {
        if (fone.length() == 11) {
            String novoFone = "(" + fone.substring(0, 2);
            novoFone = novoFone + ")" + fone.substring(2, 7);
            novoFone = novoFone + "-" + fone.substring(7, 11);
            return novoFone;
        }
        return "(00)00000-0000";
    }
    
    public String formatTelefoneBot(String fone) {
        String novoFone="";
        if (fone.length()==14){
            novoFone = fone.substring(0, 4);
            novoFone = novoFone  + fone.substring(5, 14);
            return novoFone;
        }else if (fone.length()==15){
            novoFone = fone.substring(0, 4);
            novoFone = novoFone  + fone.substring(5, 15);
            return novoFone;   
        }
        return "(00)00000-0000";
    }
    
    public String formatTelefoneExcel(String fone) {
        String novoFone="(";
        if (fone.length()==16){
            novoFone = novoFone + fone.substring(4, 6) + ")";
            novoFone = novoFone  + fone.substring(7, 16);
            return novoFone;
        }else if (fone.length()==17){
            novoFone = novoFone + fone.substring(4, 6) + ")";
            novoFone = novoFone  + fone.substring(7, 17);
            return novoFone;   
        }
        return "(00)00000-0000";
    }
    
    public String formatarHoraString() {
	DateFormat formato = new SimpleDateFormat("HH:mm:ss");
	String formattedDate = formato.format(new Date());
	return formattedDate;
    }
    
    public void lancarHistoricoLead(Lead lead, String unidadeDescricao){
        Leadhistorico historico = new Leadhistorico();
        historico.setCliente(lead.getCliente());
        historico.setDatahistorico(new Date());
        historico.setHistorico("Nova solictação do cliente via fale conosco para unidade " + unidadeDescricao);
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
    
    public int getPais(String nomePais){
        PaisFacade paisFacade = new PaisFacade();
        Pais pais = paisFacade.consultarNome(nomePais);
        if (pais!=null){
            return pais.getIdpais();
        }else return 0;
    }
    
    public Lead motivoViagemEstudar(Lead lead, Leadbot contato){
        int idPais = getPais(contato.getPaisdestino());
        if (idPais>0){
            lead.setPais(idPais);
        }else lead.setPais(5);
        if (contato.getCursos().equalsIgnoreCase("Curso de idiomas")){
            lead.setProdutos(1);
            return lead;
        }else if (contato.getCursos().equalsIgnoreCase("Férias Teen")){
            lead.setProdutos(5);
            return lead;
        }if (contato.getCursos().equalsIgnoreCase("High School")){
            lead.setProdutos(4);
            return lead;
        }else if (contato.getCursos().equalsIgnoreCase("Higher Education")){
            lead.setProdutos(22);
            return lead;
        }else{
            lead.setProdutos(21);
            return lead;
        }
    }
    
    public Lead motivoViagemTrabalho(Lead lead, Leadbot contato) {
        int idPais = getPais(contato.getPaisdestino());
        if (idPais > 0) {
            lead.setPais(idPais);
        } else {
            lead.setPais(5);
        }
        if (contato.getTrabalho() != null) {
            if (contato.getTrabalho().equalsIgnoreCase("Au pair")) {
                lead.setProdutos(9);
                return lead;
            } else if (contato.getTrabalho().equalsIgnoreCase("Work & Travel")) {
                lead.setProdutos(10);
                return lead;
            }
            if (contato.getTrabalho().equalsIgnoreCase("Voluntariado")) {
                lead.setProdutos(16);
                return lead;
            } else {
                lead.setProdutos(21);
                return lead;
            }
        } else {
            lead.setProdutos(21);
            return lead;
        }
    }
    
    public Lead motivoViagemEstudoTrabalho(Lead lead, Leadbot contato){
        int idPais = getPais(contato.getPaisdestino());
        if (idPais>0){
            lead.setPais(idPais);
        }else lead.setPais(5);
        lead.setProdutos(21);
        return lead;
        
    }
    
    
    
    public int getPublicidade(String nome){
        PublicidadeFacade publicidadeFacade = new PublicidadeFacade();
        Publicidade publicidade = new Publicidade();
        publicidade = publicidadeFacade.getPublicidade(nome);
        if (publicidade!=null){
            return publicidade.getIdpublicidade();
        }else return 1;
    }
    
    public String salvarLeadExcel() {
        ImportleadFacade importleadFacade = new ImportleadFacade();
        List<Importlead> lista = importleadFacade.listar();
        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                salvarLead(lista.get(i));
            }
        }
        return "Lista importada com sucesso";
    }
    
    public void salvarLead(Importlead importe) {
        carregarListaResponsavel(importe.getUnidade());
        Unidadenegocio unidade = getUnidade(importe.getUnidade());
        jaecliente = true;
        String nome = importe.getNome() + " " + importe.getSobrenome();
        Cliente cliente = salvarCliente(nome, importe.getEmail(), importe.getFone(), importe.getUnidade(), importe.getPublicidade(), "Excel");
        Lead lead = new Lead();
        LeadFacade leadFacede = new LeadFacade();
        boolean lancarHistorico = false;
        if (jaecliente) {
            lead = leadFacede.getLead(cliente.getIdcliente());
            lancarHistorico = true;
        } else {
            lead = null;
        }
        if (lead == null) {
            lead = new Lead();
            lead.setCliente(cliente.getIdcliente());
            lead.setJaecliente(jaecliente);
            lead.setNotas(importe.getNomeprograma());
             if (importe.getObservacao()!= null) {
                 lead.setNotas(lead.getNotas() +  " " + importe.getObservacao()); 
             }
            lead.setProdutos(importe.getPrograma());
            lead.setSituacao(1);
            lead.setTipocontato(1);
            lead.setPais(5);
            lead.setPublicidade(importe.getPublicidade());
            lead.setUnidadenegocio(importe.getUnidade());
            lead.setMotivocancelamento1(1);
            lead.setDatarecebimento(new Date());
            lead.setHorarecebimento(formatarHoraString());
            lead.setUrlclient("Feira Setembro de 2018");
            int idUsuario = 0;
            if (unidade.isLeadautomatica()) {
                idUsuario = getUsuario(unidade);
                lead.setUsuario(idUsuario);
                lead.setDataenvio(new Date());
            } else {
                if (listaLeadResponsavel != null) {
                    lead.setUsuario(listaLeadResponsavel.get(0).getUsuario());
                }
            }
            lead.setIdcontrole(0);
            lead = leadFacede.salvar(lead);
            listaResponsavelUnidade(unidade.getIdws(), idUsuario, cliente);
        } else if (lancarHistorico) {
            lancarHistoricoLead(lead, "Paulista");
        }

    }

}
