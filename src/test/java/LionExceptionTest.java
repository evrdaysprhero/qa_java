import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionExceptionTest {

    @Mock
    Feline feline;

    @Test
    public void lionException() {
        Exception exception = Assert.assertThrows(Exception.class,
                () -> new Lion("сам", feline)
        );
        Assert.assertEquals("Неверный текст исключения",
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }
}
