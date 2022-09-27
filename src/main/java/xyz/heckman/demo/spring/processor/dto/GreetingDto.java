package xyz.heckman.demo.spring.processor.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class GreetingDto implements Serializable {
	private static final long serialVersionUID = 7245529544816222018L;

	private String greeting;
}
