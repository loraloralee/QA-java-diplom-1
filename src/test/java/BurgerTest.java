import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.*;
import java.util.List;
import static org.mockito.MockitoAnnotations.openMocks;

public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Burger burger;
    Database database=new Database();
    List<Ingredient> ingredients=database.availableIngredients();

    @Before
    public void setup() throws Exception {
        openMocks(this).close();
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredients.get(2));
        Mockito.verify(burger).addIngredient(Mockito.any());
    }
    @Test
    public void removeIngredientTest(){
        burger.removeIngredient(1);
        burger.removeIngredient(2);
        Mockito.verify(burger,Mockito.times(2)).removeIngredient (Mockito.anyInt());
    }
    @Test
    public void moveIngredientTest(){
        burger.moveIngredient(1,3);
        Mockito.verify(burger,Mockito.times(1)).moveIngredient (1,3);
    }
    @Test
    public void getPriceTest(){
        Burger burger=new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(300F);
        Assert.assertEquals("Итого: 1300 руб.",1300, burger.getPrice(), 0);
        System.out.println(burger.getPrice());
    }
}


