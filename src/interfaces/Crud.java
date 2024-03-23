/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;

/**
 *
 * @author jbila
 * @param <T>
 */
public interface Crud  <T>{
/**
   * Salva uma entidade do tipo T.
   * 
   * @param entity A entidade a ser salva.
   * @return A entidade salva (pode ser a mesma instância ou uma nova).
   */
  T save(T entity);

  /**
   * Busca uma entidade pelo seu identificador.
   * 
   * @param id O identificador da entidade.
   * @return A entidade encontrada, ou null caso não seja encontrada.
   */
  T findById(Long id); // Você pode alterar o tipo do identificador (Long) para se adequar ao seu caso

  /**
   * Busca todas as entidades do tipo T.
   * 
   * @return Uma lista com todas as entidades encontradas.
   */
  List<T> findAll();
  List<T> findAll(String nome);

  /**
   * Deleta uma entidade.
   * 
   * @param id O identificador da entidade a ser deletada.
   */
  void deleteById(int id); // Você pode alterar o tipo do identificad
    
}
