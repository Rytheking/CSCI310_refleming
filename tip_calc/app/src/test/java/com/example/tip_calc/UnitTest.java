package com.example.tip_calc;

import org.junit.Test;


import static org.junit.Assert.*;
public class UnitTest {

        @Test
        public void calc_is_correct(){
            assertEquals(4.0, new MainActivity().calc(100,.04), 0);
            assertEquals(10.11, new MainActivity().calc(50.55,.2), 0);
            assertEquals(24.12, new MainActivity().calc(160.8,.15), 0);
            assertEquals(2.563, new MainActivity().calc(25.63,.1), 0);
        }
}
