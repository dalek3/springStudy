package org.joy.diEx090;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
// diEx080과 다르게 bean쪽에서 한 통으로 모아서 사용
@ImportResource("classpath:beanDiEx090.xml")
public class ConfigApp {

	@Bean
	public Player player1(){
		ArrayList<String> position = new ArrayList<String>();
		position.add("4번타자");
		position.add("3루수");
		
		Player player = new Player("박병호", 28, position);
		player.setHeight(187);
		player.setWeight(80);
		
		return player;
	}
}
