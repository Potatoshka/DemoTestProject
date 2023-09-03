package helper;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.intellij.lang.annotations.Language;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class StringUtils {
    public static String findByRegex(@Language("regexp") String regex, String text){
        Matcher matcher = Pattern.compile(regex).matcher(text);
        if (matcher.find())
            return matcher.group(1);
        return null;
    }

    public static boolean isMatch(@Language("regexp") String regex, String text){
        return Pattern.compile(regex).matcher(text).find();
    }

    public static String format(String str, String ... args){
        for (Object arg: args)
            str = str.replaceFirst("\\{}", Objects.requireNonNull(arg).toString());
        return str;
    }

    public static String doubleToString(double d) {
        return String.format(Locale.US, "%,.2f", d).replace(',', ' ').replace('.', ',');
    }

    public static SelenideElement $x(@Language("XPath") String xpath, String... args){
        return Selenide.$x(format(xpath, args));
    }

    public static ElementsCollection $$x(@Language("XPath") String xpath, String... args){
        return Selenide.$$x(format(xpath, args));
    }
    @SneakyThrows
    public static void copyAvailableFields(Object source, Object target) throws IllegalAccessException {
        Field[] fields = source.getClass().getDeclaredFields();
        for(Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())){
                field.setAccessible(true);
                Object value = field.get(source);
                if(Objects.nonNull(value))
                    field.set(target, value);
            }
        }
    }

    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length())/ target.length();
    }

    public static String getClipBoardText(){
        Selenide.executeJavaScript("async function getCBContents() { try { window.cb = await navigator." +
                "clipboard.readText(); console.log(\"Pasted content: \", window.cb); } catch (err) { " +
                "console.error(\"Failed to read clipboard contents: \", err); window.cb = \"Error : \" + err; } " +
                "} getCBContents();");
        return Objects.requireNonNull(Selenide.<String>executeJavaScript("return window.cb"));
    }

    public static String getStackTraceThrowable(Throwable e) {
        List<String> regexList = Collections.singletonList("\\.(tests)\\..*\\n([\\w\\W]*)");
        String stackTrace = ExceptionUtils.getStackTrace(e);
        for(@Language("regexp") String regex : regexList){
            Matcher matcher = Pattern.compile(regex).matcher(stackTrace);
            if(matcher.find()) {
                String post = matcher.group(2);
                stackTrace = stackTrace.substring(0, stackTrace.indexOf(post));
            }
        }
        return stackTrace;
    }

    public static String getStackTrace(StackTraceElement[] trace) {
        StringJoiner stack = new StringJoiner("\n\t");
        for (StackTraceElement s : trace) {
            String e = s.toString();
            stack.add(e);
            if(e.startsWith("api.") || e.startsWith("ui.")){
                    break;}
        }
        return stack.toString();
    }

    public static boolean exist(SelenideElement element, Duration duration){
        try {
            element.should(Condition.exist, duration);
            return true;
        }catch (Throwable ignored){
            return false;
        }
    }

    public static boolean isNullOrEmpty(String value) {return value == null || value.length() == 0; }



}
