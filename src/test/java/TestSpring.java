import entity.FeeFrozenRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.Application;
import spring.dao.FeeFrozenRecordMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class TestSpring {
    @Autowired
    private FeeFrozenRecordMapper feeFrozenRecordMapper;

    @Test
    public void test(){
        FeeFrozenRecord feeFrozenRecord = feeFrozenRecordMapper.selectById("B911BAMD2LFL5AKHPQ5G");

        System.out.println(feeFrozenRecord);
    }
}
