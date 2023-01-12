package com.pengo.jvm_pratice.chapter10;

/**
 * @author Benpeng
 * @date 2023/1/4
 */
public class BADLY_NAMED_CODE {
    enum colors {
        red, blue, green;
    }
    static final int _FORTY_TWO = 42;
    public static int NOT_A_CONSTANT = _FORTY_TWO;
    protected void BADLY_NAMED_CODE() { return;
    }
    public void NOTcamelCASEmethodNAME() { return;
    }
}
