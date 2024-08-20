import com.slz.model.Student;
import com.slz.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @author : SunLZ
 * @project : MybatisLearning
 * @date : 2024/8/20
 */
public class TestSelect {
    public static void main(String[] args) throws IOException {
        SqlSession session = SessionUtil.getSession(true);
//        List<Student> selectList1 = session.selectList("selectList");
//        selectList1.forEach(student -> System.out.print(student));
        Student selectById = session.selectOne("selectById", 58);
        System.out.println(selectById);
        session.close();
    }
}
