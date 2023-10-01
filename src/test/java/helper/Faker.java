package helper;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Faker {
    static com.github.javafaker.Faker faker = new com.github.javafaker.Faker();

    @Getter
    public static String fullName = faker.name().fullName();
    @Getter
    public static String email = faker.internet().emailAddress();
    @Getter
    public static String address = faker.address().fullAddress();
    @Getter
    public static String name = faker.name().firstName();
    @Getter
    public static String lastName = faker.name().lastName();
    @Getter
    public static int age = faker.number().numberBetween(10,100);
    @Getter
    public static int salary = faker.number().numberBetween(1000, 10000);
    public static String department = faker.company().profession();





}
