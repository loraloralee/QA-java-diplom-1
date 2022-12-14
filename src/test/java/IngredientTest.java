import org.junit.Assert;
import org.junit.Test;

import praktikum.Ingredient;
import praktikum.IngredientType;


import static praktikum.IngredientType.FILLING;

public class IngredientTest {

    Ingredient ingredient;

    @Test
    public void getPriceTest(){
        Ingredient ingredient=new Ingredient(IngredientType.SAUCE,"hot sauce",100);
        System.out.println(ingredient.getPrice());
        Assert.assertEquals("Цена должна быть 100 рублей",100,ingredient.getPrice(),0);

    }
    @Test
    public void getNameTest(){
        Ingredient ingredient=new Ingredient(IngredientType.FILLING,"sausage",300);
        System.out.println(ingredient.getName());
        Assert.assertEquals("Верни сосиску","sausage",ingredient.getName());
    }
    @Test
    public void getNameType(){
        Ingredient ingredient=new Ingredient(IngredientType.FILLING,"cutlet",100);
        System.out.println(ingredient.getType());
        Assert.assertEquals("Нужно мясо!",FILLING,ingredient.getType());

    }
}


