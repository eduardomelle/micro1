package br.com.micro1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.Tracing;
import brave.opentracing.BraveTracer;
import brave.sampler.Sampler;
import zipkin2.Span;
import zipkin2.codec.Encoding;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.okhttp3.OkHttpSender;

@SpringBootApplication
public class Micro1Application {

	@Value("${spring.application.name}")
	private String localServiceName;

	public static void main(String[] args) {
		SpringApplication.run(Micro1Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	/*
	 * @Bean public io.opentracing.Tracer zipkinTracer() { OkHttpSender okHttpSender
	 * = OkHttpSender.newBuilder().encoding(Encoding.JSON)
	 * .endpoint("http://localhost:9411/api/v2/spans").build(); AsyncReporter<Span>
	 * reporter = AsyncReporter.builder(okHttpSender).build(); Tracing braveTracer =
	 * Tracing.newBuilder().localServiceName(localServiceName).spanReporter(
	 * reporter) .traceId128Bit(true).sampler(Sampler.ALWAYS_SAMPLE).build(); return
	 * BraveTracer.create(braveTracer); }
	 */

}
