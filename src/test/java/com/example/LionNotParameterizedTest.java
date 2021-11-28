package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionNotParameterizedTest {

    @Test
    public void testLionConstructorSexNotMaleAndFemaleGetException() {
        try {
            Lion lion = new Lion("Test");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }

    @Test
    public void testDoesHaveManeReturnFalse() throws Exception {
        Lion lion = new Lion("Самка");
        boolean actual = lion.doesHaveMane();
        assertFalse(actual);
    }

    @Mock
    Feline feline;

    @Test
    public void testGetKittensReturnSomeKittens() {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(2);
        int expectedKittens = 2;
        int actualKittens = lion.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testGetFoodReturnSomeFood() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(List.of("Еда", "Еда", "Еда"));
        List<String> expectedFood = List.of("Еда", "Еда", "Еда");
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
