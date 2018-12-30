package j2ee.demo;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
@ComponentScan(basePackages = { "j2ee.demo", "j2ee.demo.controller" , "j2ee.demo.configuration"})
@MapperScan("j2ee.demo.mapper")
public class BackendApplication {
	public static void main(String[] args) throws MalformedURLException {
		SpringApplication.run(BackendApplication.class, args);
//		Path outputFile = Paths.get("build/swagger");
//		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//				.withMarkupLanguage(MarkupLanguage.MARKDOWN)
//				.withOutputLanguage(Language.ZH)
//				.withPathsGroupedBy(GroupBy.TAGS)
//				.withGeneratedExamples()
//				.withoutInlineSchema()
//				.build();
//		Swagger2MarkupConverter converter = Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs"))
//				.withConfig(config)
//				.build();
//		converter.toFile(outputFile);
	}
}
