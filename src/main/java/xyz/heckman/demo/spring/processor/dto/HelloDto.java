package xyz.heckman.demo.spring.processor.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class HelloDto implements Serializable {
	private static final long serialVersionUID = 6959522277641068413L;

	private String name;
}
