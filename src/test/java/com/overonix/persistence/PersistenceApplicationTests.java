package com.overonix.persistence;

import com.overonix.persistence.model.Player;
import com.overonix.persistence.repository.PlayerRepository;
import com.overonix.persistence.service.PersistenceServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
class PersistenceApplicationTests {


	@Autowired
	private PlayerRepository playerRepository;


	Player player = new Player();

	@BeforeEach
	public void setUp() {
		player.setEmail("akobundumichael94@gmail.com");
		player.setUuid("e7beb474-5468-4d83-a99d-5e1a3c5affa5");
		player.setPassword("easypeasy");
	}

	@AfterEach
	public void destroy() {
		//delete the saved record to avoid flooding our database
		playerRepository.deleteById(player.getId());
	}

	@Test
	public void savePlayerRecordTest() {
		playerRepository.save(player);
		assertNotNull(player.getId());
	}

}
