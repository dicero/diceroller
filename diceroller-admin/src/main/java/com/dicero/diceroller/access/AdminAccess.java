package com.dicero.diceroller.access;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dicero.diceroller.domain.enums.AdminRole;

/**
* <p></p>
* @author ningzhong.zeng
*
 */
@Target( { ElementType.METHOD, ElementType.TYPE, ElementType.PACKAGE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminAccess {
	AdminRole[] value() default {};
}