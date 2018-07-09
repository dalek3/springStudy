package exem.java34;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/* 사용자 정의 어노테이션 생성(?)
 *  - 일반적인 어노테이션
 * 		- @Override, @D , @Su 
 * 
 *  - @Target: 어노테이션 적용될 위치
 *  	- FIELD : 필드 선언부에 달아두는 태크
 *  	- METHOD : 메소드에 달아두는 태그
 *  	- CONSTRUCTOR : 생성자에 달아두는 태그 
 *  	- PARAMETER : 매개변수에 달아두는 태그
 *  
 *	- @Retention : 유효기간 지정 
 *		- RUNTIME : 실행시에도 유지
 *		- CLASS: 클래스파일까지 유지
 *		- SOURCE : 소스코드에만 존재
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTag { // ...마치 인터페이스를 만든 것처럼 작동.
    String myName() default "홍길동";
}
