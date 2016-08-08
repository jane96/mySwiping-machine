package swing;

import java.util.ArrayList;
import java.util.List;

public class Data {
	public List<User> userInfo(){
		List<Class1> list=class1Info();
		User user1=new User();
		user1.setId("201410411105");
		user1.setName("¹ùÎ°Óî");
		user1.setClass1(list.get(0));
		User user2=new User();
		user2.setId("201410421107");
		user2.setName("º«Ñ©");
		user2.setClass1(list.get(1));
		User user3=new User();
		user3.setId("201310311221");
		user3.setName("»ÆÕñ");
		user3.setClass1(list.get(2));
		User user4=new User();
		/*user4.setId(4);
		user4.setName("³ÂĞ¤Ôò");
		user4.setClass1(list.get(3));
		User user5=new User();
		user5.setId(5);
		user5.setName("ÍõÈÊöÎ");
		user5.setClass1(list.get(0));
		User user6=new User();
		user6.setId(6);
		user6.setName("ÀîÁØ");
		user6.setClass1(list.get(1));
		User user7=new User();
		user7.setId(7);
		user7.setName("»ÆÕñ");
		user7.setClass1(list.get(2));*/
		List<User> list1=new ArrayList<User>();
		list1.add(user1);
		list1.add(user2);
		list1.add(user3);
		/*list1.add(user4);
		list1.add(user5);
		list1.add(user6);
		list1.add(user7);*/
		return list1;
	
	}
	public List<Class1>class1Info(){
		Class1 class1=new Class1();
		Class1 class2=new Class1();
		Class1 class3=new Class1();
		Class1 class4=new Class1();
		class1.setOoc("A");
		class1.setLine("L1");
		class1.setCar("1111");
	
		class2.setOoc("B");
		class2.setLine("L2");
		class2.setCar("2222");
		class3.setOoc("C");
		class3.setLine("L3");
		class3.setCar("3333");
		class4.setOoc("D");
		class4.setLine("L4");
		class4.setCar("4444");
		List list=new ArrayList<Class1>();
		list.add(0,class1);
		list.add(1,class2);
		list.add(2,class3);
		list.add(3,class4);
		return list;
	}
}
