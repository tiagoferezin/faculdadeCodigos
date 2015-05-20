package br.com.cuml.dao;

import java.util.List;

public interface ICrud {
	Object getPorId(Object id) throws Exception;
	List<Object> listar() throws Exception;
	Integer inserir(Object objetoPersistir) throws Exception;
	Integer alterar(Object objetoPersistir) throws Exception;
	Integer deletar(Object objetoPersistir) throws Exception;
}
