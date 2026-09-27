package com.autobots.automanager.controles;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.DTO.Request.CriarDocumento;
import com.autobots.automanager.DTO.Request.atualizarDocumento;
import com.autobots.automanager.DTO.Response.DocumentoDtO;
import com.autobots.automanager.Mappers.MapperDicumento;
import com.autobots.automanager.Servicos.DocumentoService;

@RestController 
public class DocumentoControle {
    @Autowired 
    DocumentoService docServ;

    @Autowired 
    MapperDicumento mappperDoc;

    @GetMapping("/documentos")
    public List<DocumentoDtO> listarDocs(){
        return docServ.pegarDocumentos().stream().map(doc->mappperDoc.DocumentoParaDTo(doc)).collect(Collectors.toList());
    }

    @GetMapping("/documentos/{id}")
    public DocumentoDtO pegarDoc(@PathVariable Long id ){
         return mappperDoc.DocumentoParaDTo(docServ.pegarDocumento(id));
    } 

    @PostMapping("/documentos")
    public void criarDoc(@RequestBody CriarDocumento doc){
        docServ.criarDocumento(doc);

    }

    @PutMapping("/documentos")
    public void atualizarDoc(@RequestBody atualizarDocumento doc){
          docServ.atualizarDocumento(doc);
    }

    @DeleteMapping("/documentos")
    public void deletarDoc(@PathVariable Long id){
        docServ.deletarDocumento(id);
    }
}
