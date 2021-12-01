package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void testEatMeatReturnPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFamilyReturnFelineFamily() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittensNotParameterizedReturnOneKitten() {
        Feline feline = new Feline();
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void testGetKittensParameterizedReturnOneKitten () throws Exception {
        Feline feline = new Feline();
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens(1);
        assertEquals(expectedKittensCount, actualKittensCount);
    }

}