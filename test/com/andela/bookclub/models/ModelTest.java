package com.andela.bookclub.models;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.mock;


public class ModelTest {

    // Stub object to use for testing abstract class

    Model model;

    /*
    * One test should be adequate for each getter-setter pair
    * */

    @Before
    public void beforeTestGetId() {
        model = mock(Model.class, Mockito.CALLS_REAL_METHODS);
        model.setId("lorem12345");
    }

    @Test
    public void testGetId() throws Exception {
        assertEquals("lorem12345", model.getId());
        assertNotSame("foo", model.getId());
    }
}