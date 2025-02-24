import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            instances.put(clazz, instance);
        } catch (Exception e) {
            throw new RuntimeException("Registration error", e);
        }
    }

    public void injectDependencies(Object obj) {
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> dependencyType = field.getType();
                    Object dependency = instances.get(dependencyType);
                    if (dependency == null) {
                        dependency = dependencyType.getDeclaredConstructor().newInstance();
                        instances.put(dependencyType, dependency);
                    }
                    field.setAccessible(true);
                    field.set(obj, dependency);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Dependency injection error", e);
        }
    }
}

class Service {
    public void execute() {
        System.out.println("Service executed");
    }
}

class Client {
    @Inject
    private Service service;

    public void run() {
        service.execute();
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        container.register(Service.class);

        Client client = new Client();
        container.injectDependencies(client);
        client.run();
    }
}
