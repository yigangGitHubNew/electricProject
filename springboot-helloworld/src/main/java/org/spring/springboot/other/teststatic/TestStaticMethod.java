package org.spring.springboot.other.teststatic;

/**
 * 	测试static关键字
 * 	1、静态方法不能调用非静态的方法（因为非静态成员方法/变量都是必须依赖具体的对象才能够被调用。）
 * 	2、方便在没有创建对象的情况下来进行调用
 * 	3、static可以用来修饰类的成员方法、类的成员变量，另外可以编写static代码块来优化程序性能
 * 	4、即使没有显示地声明为static，类的构造器实际上也是静态方法
 * 	5、静态变量和非静态变量的区别是：静态变量被所有的对象所共享，在内存中只有一个副本，
 * 	      它当且仅当在类初次加载时会被初始化。而非静态变量是对象所拥有的，在创建对象的时候被初始化，
 * 	      存在多个副本，各个对象拥有的副本互不影响
 * 	6、静态成员变量虽然独立于对象，但是不代表不可以通过对象去访问，所有的静态方法和静态变量都可以通过对象访问
 *  @author yigang.wu
 *	@date 2017年10月19日 上午10:15:49
 *
 */
public class TestStaticMethod {
	
	public static String getStringMethod() {
		return "123";
	}
	
	public String getStr() {
		return "test";
	}
	
	/**
	 * 使用static代码块的给性能带来的好处
	 */
	/*private Date birthDate;
    private static Date startDate,endDate;
    static{
        startDate = new Date(1946);
        endDate = new Date(1964);
    }
     
    public TestStaticMethod(Date birthDate) {
        this.birthDate = birthDate;
    }
     
    boolean isBornBoomer() {
        return birthDate.compareTo(startDate)>=0 && birthDate.compareTo(endDate) < 0;
    }*/
    
    /**
     * 说明在类中今天成员变量也是可以使用this的
     */
    /*static int value = 33;
    
    public static void main(String[] args) throws Exception{
        new TestStaticMethod().printValue();
    }
 
    private void printValue(){
        int value = 3;
        System.out.println(this.value);
    }*/
}

