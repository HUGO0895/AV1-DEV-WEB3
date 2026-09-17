package com.autobots.automanager.Mappers;
import org.springframework.stereotype.Component;

import com.autobots.automanager.DTO.Request.CriarDocumento;
import com.autobots.automanager.DTO.Request.atualizarDocumento;
import com.autobots.automanager.DTO.Response.DocumentoDtO;
import com.autobots.automanager.entidades.Documento;

@Component 
public class MapperDicumento {
    public Documento criarDtoParaDocumento(CriarDocumento doc){
            Documento documento=new Documento();
           documento.setNumero(doc.getNumero());
           documento.setTipo(doc.getTipo());
           return documento;
    }

    public void atualizarDtoParaDocumento(atualizarDocumento doc,Documento documento){
     if(doc.getNumero()!=null && !doc.getNumero().isEmpty())
       documento.setNumero(doc.getNumero());

     if(doc.getTipo()!=null && !doc.getTipo().isEmpty())
        documento.setTipo(doc.getTipo());
    }


    public DocumentoDtO DocumentoParaDTo(Documento doc){
        DocumentoDtO documento=new DocumentoDtO();
        if(doc.getCliente()!=null)
        documento.setCliente(doc.getCliente().getId());
        documento.setId(doc.getId());
        documento.setNumero(doc.getNumero());
        documento.setTipo(doc.getTipo());

            return  documento;
    }
}
