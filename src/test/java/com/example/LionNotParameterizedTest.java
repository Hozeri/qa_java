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

    @Mock
    Feline feline;

    @Test
    public void testLionConstructorSexNotMaleAndFemaleGetException() {
        try {
            Lion lion = new Lion("Test", feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }

    @Test
    public void testDoesHaveManeReturnFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean actual = lion.doesHaveMane();
        assertFalse(actual);
    }

    @Test
    public void testGetKittensReturnSomeKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(2);
        int expectedKittens = 2;
        int actualKittens = lion.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testGetFoodReturnSomeFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
