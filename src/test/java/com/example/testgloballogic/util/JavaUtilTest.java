package com.example.testgloballogic.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class JavaUtilTest {

    @Test
    void validatePassword() {
        Assert.isTrue(JavaUtil.validatePassword("A34dsfdggg"),"validate password");

    }

    @Test
    void validateEmail() {
        Assert.isTrue(JavaUtil.validateEmail("saddasg@gasd.cl"),"validate email");
    }
}