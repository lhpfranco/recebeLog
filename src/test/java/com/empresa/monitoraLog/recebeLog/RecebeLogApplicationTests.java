package com.empresa.monitoraLog.recebeLog;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.empresa.monitoraLog.recebeLog.domain.StackTrace;
import com.empresa.monitoraLog.recebeLog.repository.StackTraceRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecebeLogApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void listarLog() {
		
//		private StackTraceRepository repository = new StackTraceRepository();
//		
//		List<StackTrace> lista = repository.listarlog();
	}
}
