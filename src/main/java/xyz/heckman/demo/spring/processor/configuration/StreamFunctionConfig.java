package xyz.heckman.demo.spring.processor.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import xyz.heckman.demo.spring.processor.dto.GreetingDto;
import xyz.heckman.demo.spring.processor.dto.HelloDto;

import java.util.function.Function;

@Configuration
@Slf4j
public class StreamFunctionConfig {

	/**
	 * @see <a href=https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/spring-cloud-stream.html#_bindings>
	 * Spring Cloud Documentation: Function Bindings</a>
	 */
	@Bean
	public Function<Message<HelloDto>, GreetingDto> demoFunction() {
		return msg -> {
			log.trace("Transform: {}", msg);

			return GreetingDto.builder()
					.greeting(String.format("Nice to meet you %s!", msg.getPayload().getName()))
					.build();
		};
	}
}
