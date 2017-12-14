package org.spring.springboot.pool;

import org.apache.commons.pool.PoolableObjectFactory;

public class TestPoolableFactory implements PoolableObjectFactory<Object>{

	@Override
	public void activateObject(Object arg0) throws Exception {
		((BaseObject)arg0).setActive(true);
	}

	@Override
	public void destroyObject(Object arg0) throws Exception {
		arg0 = null;
	}

	@Override
	public Object makeObject() throws Exception {
		BaseObject bo = new BaseObject();
		return bo;
	}

	@Override
	public void passivateObject(Object arg0) throws Exception {
		((BaseObject)arg0).setActive(false);
	}

	@Override
	public boolean validateObject(Object arg0) {
		if(((BaseObject)arg0).isActive())  
            return true;  
        else  
            return false;  
    	}  
}

