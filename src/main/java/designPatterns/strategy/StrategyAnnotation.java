package designPatterns.strategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by za-hejun on 2018/3/26.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategyAnnotation {
    int max() default Integer.MAX_VALUE;
    int min() default Integer.MIN_VALUE;
}
