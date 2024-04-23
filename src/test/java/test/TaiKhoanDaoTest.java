package test;

import dao.TaiKhoanDao;
import entities.TaiKhoan;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaiKhoanDaoTest {
    private TaiKhoanDao taiKhoanDao;

    @BeforeAll
    void setUp() {
        taiKhoanDao = new TaiKhoanDao();
    }


    @SneakyThrows
    @Test
    void testGetList(){
        ArrayList list = (ArrayList) taiKhoanDao.getList();
        assert list.size() > 0;

    }


    @SneakyThrows
    @Test
    void testInsertAccount(){
        TaiKhoan taiKhoan = new TaiKhoan("Vinhpro", "123456", null, true);
        int result = taiKhoanDao.insertAccount(taiKhoan);
        assert result == 1;
    }


    @SneakyThrows
    @Test
    void testGetTaiKhoanTheoMaNV(){
        TaiKhoan taiKhoan = taiKhoanDao.getTaiKhoanTheoMaNV("NV000001");
        assert taiKhoan != null;
    }



    @SneakyThrows
    @Test
    void doiMatKhau(){
        int result = taiKhoanDao.doiMatKhau("654123", "NV000001");
        assert result == 1;
    }



    @AfterAll
    void tearDown() {
        taiKhoanDao = null;
    }
}
