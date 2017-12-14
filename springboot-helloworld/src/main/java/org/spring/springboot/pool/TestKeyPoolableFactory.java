package org.spring.springboot.pool;

import org.apache.commons.pool.KeyedPoolableObjectFactory;

public class TestKeyPoolableFactory implements KeyedPoolableObjectFactory<String, BaseObject>{

	@Override
	public void activateObject(String arg0, BaseObject arg1) throws Exception {
		((BaseObject)arg1).setActive(true);
	}

	@Override
	public void destroyObject(String arg0, BaseObject arg1) throws Exception {
		arg1 = null;
	}

	@Override
	public BaseObject makeObject(String arg0) throws Exception {
		BaseObject bo = new BaseObject();  
        bo.setNum(0);  
        return bo;
	}

	@Override
	public void passivateObject(String arg0, BaseObject arg1) throws Exception {
		((BaseObject)arg1).setActive(false);
	}

	@Override
	public boolean validateObject(String arg0, BaseObject arg1) {
		//这里可以判断实例状态是否可用  
        if(((BaseObject)arg1).isActive())  
            return true;  
        else  
            return false;  
	}

}
