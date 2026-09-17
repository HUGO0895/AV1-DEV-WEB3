package com.autobots.automanager.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.autobots.automanager.DTO.Response.ErroRespostaDTO;
import com.autobots.automanager.exceptions.tipos.NaoexistenoBanco;

@ControllerAdvice 
public class ManipuladorGlobalDeErros {

   @ExceptionHandler(NaoexistenoBanco.class)
   public ResponseEntity<ErroRespostaDTO>manipularNaoExistenciaNoBanco(NaoexistenoBanco erro){
      ErroRespostaDTO erroRes=new ErroRespostaDTO(erro.getMessage(),erro.getMensagem());
      ResponseEntity<ErroRespostaDTO> resposta=new ResponseEntity<>(erroRes,HttpStatus.BAD_REQUEST);
      return resposta;
   }

   @ExceptionHandler(InvalidDataAccessApiUsageException.class)
   public ResponseEntity<ErroRespostaDTO>manipularInvalidDataAcess(InvalidDataAccessApiUsageException erro){
      ErroRespostaDTO erroRes=new ErroRespostaDTO(erro.getMessage(),"Verifique os dados enviados");
      ResponseEntity<ErroRespostaDTO> resposta=new ResponseEntity<ErroRespostaDTO>(erroRes,HttpStatus.BAD_REQUEST);
      return resposta;
   }
   
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Object>manipuladorFormularios(MethodArgumentNotValidException erro){
    Map<String,String> errors=new HashMap<>();
    erro.getBindingResult().getFieldErrors().forEach((error)->{
           String campo=error.getField();
           String mensagem=error.getDefaultMessage();
           errors.put(campo, mensagem);

    });

    return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);

   }

   @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
   public ResponseEntity<Object>manipularHtppRequestMethodNotSupport(HttpRequestMethodNotSupportedException erro){
       Map<String,String> errors=new HashMap<>();
       errors.put("erro",":Esse metodo não é possivel nessa rota:"+erro.getMethod());
       return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);


   }

   

   
    
}
