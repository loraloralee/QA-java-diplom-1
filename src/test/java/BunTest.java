import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun;

    @Test
    public void getNameNotNull(){
        Bun bun=new Bun("red bun",100);
        System.out.println((String.format("%s %n", bun.getName())));
        Assert.assertNotNull("Булки нет",bun.getName());

    }
    @Test
    public void getPriceNotNull(){
        Bun bun=new Bun("red bun",200);
        System.out.println(bun.getPrice());
        Assert.assertNotEquals("Цена не может быть 0",0.0f ,bun.getPrice());

    }
}

