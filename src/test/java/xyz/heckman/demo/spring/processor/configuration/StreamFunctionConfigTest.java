package xyz.heckman.demo.spring.processor.configuration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import xyz.heckman.demo.spring.processor.dto.GreetingDto;
import xyz.heckman.demo.spring.processor.dto.HelloDto;

import java.util.Collections;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class StreamFunctionConfigTest {

	private Function<Message<HelloDto>, GreetingDto> demoFunction;

	@BeforeEach
	void setUp() {
		StreamFunctionConfig streamFunctionConfig = new StreamFunctionConfig();
		demoFunction = streamFunctionConfig.demoFunction();
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void demoFunction_doesSomething() {
		GreetingDto dto = demoFunction.apply(MessageBuilder
				.createMessage(
						HelloDto.builder()
								.name("Nickolas")
								.build(),
						new MessageHeaders(Collections.emptyMap())));

		assertThat(dto).isNotNull();
		assertThat(dto.getGreeting()).isNotNull();
		assertThat(dto.getGreeting().contains("Nickolas")).isTrue();
	}
}