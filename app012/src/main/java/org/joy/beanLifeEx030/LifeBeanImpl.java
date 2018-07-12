package org.joy.beanLifeEx030;

import org.springframework.beans.factory.BeanNameAware;

public class LifeBeanImpl implements IF_LifeBean, BeanNameAware{
	
	private String beanName; //설정파일에서 bean의 id를 저장하기위한 변수
	
	//사용자 초기화 메소드
	public void init(){
		System.out.println("사용자 초기화 메소드!!!");
	}
	//사용자 소멸 메소드
	public void end(){
		System.out.println("사용자 소멸 메소드!!!");
	}
	
	@Override
	public void lifeMethod(){
		System.out.println("비즈니스 로직을 수행합니다!!!!");
		System.out.println("beanName :"+ beanName);
	}
	
	// 빈객체가 자신의 이름을 알아야 하는 경우 사용하는 메소드 
	// (객체가 생성될 때 해당 객체의 id값을 전달(주입) 받는 메소드)
	
	// ApplicationContext가 org.springframework.beans.factory.BeanNameAware 인터페이스를
	// 구현한 클래스를 생성할 때 이 클래스는 관련된 객체 정의에서 정의한 이름에 대한 참조를 제공받는다.
	// / 컨테이너에의해 주입된다.
	
	// BeanNameAware 메소드
	@Override
	public void setBeanName(String beanName){
		this.beanName = beanName;
	}
}
