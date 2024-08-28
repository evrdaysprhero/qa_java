import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void getSoundSuccess() {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        Assert.assertEquals("Звук не соответствует ожидаемому","Мяу", sound);
    }

    @Test
    public void getFoodSuccess() throws Exception {
        List <String> testFood = List.of("Животные", "Птицы", "Рыба");
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(testFood);
        List<String> food = cat.getFood();
        Assert.assertEquals(testFood, food);
    }
}
