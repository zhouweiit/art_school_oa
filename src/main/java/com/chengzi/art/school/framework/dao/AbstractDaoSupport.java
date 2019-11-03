
package com.chengzi.art.school.framework.dao;

import lombok.Getter;
import org.mybatis.spring.SqlSessionTemplate;

import java.io.Serializable;

/**
 * 抽象的统一常用的Dao操作方法
 *
 * @author zhouwei
 */
@Getter
public abstract class AbstractDaoSupport<T, ID extends Serializable> implements CURDDao<T, ID> {

	protected abstract SqlSessionTemplate getSqlSessionTemplate();

	protected abstract String getNamespace();

	public int deleteSoftByPrimaryKey(ID id) {
		return getSqlSessionTemplate().update(getNamespace() + ".deleteSoftByPrimaryKey", id);
	}

	public int deleteByPrimaryKey(ID id) throws DaoException{
		return getSqlSessionTemplate().delete(getNamespace() + ".deleteByPrimaryKey", id);
	}

	public int insert(T record) {
		return getSqlSessionTemplate().insert(getNamespace() + ".insert", record);
	}

	public T selectByPrimaryKey(ID id) {
		return getSqlSessionTemplate().selectOne(getNamespace() + ".selectByPrimaryKey", id);
	}

	public int updateByPrimaryKey(T record) {
		return getSqlSessionTemplate().update(getNamespace() + ".updateByPrimaryKey", record);
	}
}
