package com.andela.bookclub.models;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class ModelTest {

    // Stub object to use for testing abstract class

    Model model = Mockito.mock(Model.class);

    // Assign an id to the model object so as to test getId

    @Before
    public void beforeTestGetId() {
        model.setId("lorem12345");
    }

    @Test
    public void testGetId() throws Exception {
        assertEquals("lorem12345", model.getId());
        assertNotSame("lorem12345", model.getId());
    }

    @Test
    public void testSetId() throws Exception {

    }
}