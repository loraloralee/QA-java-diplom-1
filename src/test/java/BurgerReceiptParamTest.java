import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

@RunWith(value = JUnitParamsRunner.class)
public class BurgerReceiptParamTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    public Iterable getParameters() {
        return Arrays.asList(new Object[][]{
                {"black bun", "hot sauce", IngredientType.SAUCE, 100F},
                {"white bun", "sour cream", IngredientType.SAUCE, 100F},
                {"red bun", "chili sauce", IngredientType.SAUCE, 900F},
                {"black bun", "cutlet", IngredientType.FILLING, 100F},
                {"white bun", "dinosaur", IngredientType.FILLING, 1200F},
                {"red bun", "sausage", IngredientType.FILLING, 800F},
        });
    }

    @Test
    @Parameters(method = "getParameters")
    public void getReceiptTest(String buns, String ingredients, IngredientType type, float price) {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(buns);
        Mockito.when(ingredient.getName()).thenReturn(ingredients);
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(burger.getPrice()).thenReturn(price);
        String receipt = String.format("(==== %s ====)%n", buns) + String.format("= %s %s =%n", type.toString().toLowerCase(), ingredients) +
                String.format("(==== %s ====)%n", buns) +
                String.format("%nPrice: %.2f%n", price);
        assertEquals(String.format("Метод должен возвращать строку c %s, %s %s и ценой %.2f", buns, ingredients,type,  price), receipt, burger.getReceipt());
        System.out.println(burger.getReceipt());
    }
}

