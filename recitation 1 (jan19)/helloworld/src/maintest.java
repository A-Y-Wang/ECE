import org.junit.Test;
import static org.junit.Assert.*;
public class maintest {
    @Test
    public void test(){
        main s = new s();
        int i = 3;
        int j = 4;
        assert s.add(i,j) == 7;
    }
}
