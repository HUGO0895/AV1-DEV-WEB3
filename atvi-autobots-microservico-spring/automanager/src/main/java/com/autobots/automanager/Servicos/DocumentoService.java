package com.autobots.automanager.Servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.DTO.Request.CriarDocumento;
import com.autobots.automanager.Mappers.MapperDicumento;
import com.autobots.automanager.repositorios.DocumentoRepositorio;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.DTO.Request.atualizarDocumento;
@Service 
public class DocumentoService {
    @Autowired 
    private DocumentoRepositorio docRepo;
    
    @Autowired  
    private MapperDicumento mapperdoc;

    @Autowired  
    private ClienteService clieServ;
    

    public List<Documento> pegarDocumentos(){
        return docRepo.findAll();
    }

    public Documento pegarDocumento(Long id){
      return docRepo.findById(id).get();
    }

    public void criarDocumento(CriarDocumento documento){
     Documento doc=mapperdoc.criarDtoParaDocumento(documento);
     doc.setCliente(clieServ.acharUmCliente(documento.getCliente()));
     docRepo.save(doc);

    }

    public void atualizarDocumento(atualizarDocumento documento){

        Documento doc=docRepo.findById(documento.getCliente()).get();
        mapperdoc.atualizarDtoParaDocumento(documento,doc);
        docRepo.save(doc);
    }

    public void deletarDocumento(Long id){
       Documento doc= docRepo.findById(id).get();
       if(doc==null){
        throw new Error("Matrix");
       }
        docRepo.deleteById(id);
    }

    
}
