package java8Features;

/**
 * Resolves a limitation, where applying the same annotation on a part of code was not allowed. 
 * Simplifies usage of some annotations in frameworks (such as, Spring, Hibernate, JPA, Struts 2).
 */

public class RepeatingAnnotations {
	public static void main() {
		// Before Java 8 – with Spring
		/*@PropertySources({
		@PropertySource("default.properties"),
		@PropertySource(value = "file:${CONF_DIR}/optional-override.properties", ignoreResourceNotFound = true) })
		public class ApplicationConfig {}*/
		
		// After Java 8 – with Spring
		/*@PropertySource("default.properties")
		@PropertySource(value = "file:${CONF_DIR}/optional-override.properties", ignoreResourceNotFound = true)
		public class ApplicationConfig {}
		
		
		// Before Java 8 – role based security
		@Authorize(roles = {"USER", "ADMIN"})
		public void doStuff(){}
		
		// After Java 8 – role based security
		@Authorize("USER")
		@Authorize("ADMIN")
		public void doStuff(){}
		
		// Before Java 8 – Quartz cron expression
		@Cron(values={"* * * * * 10", "12 * * * * 0"})
		public void doStuff(){}

		// After Java 8 – Quartz cron expression
		@Cron("* * * * * 10")
		@Cron("12 * * * * 0")
		public void doStuff(){}*/
	}
}
